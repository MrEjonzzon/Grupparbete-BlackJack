package se.nackademin.blackjack.service;

import se.nackademin.blackjack.model.Deck;
import se.nackademin.blackjack.model.Gambler;

import java.util.Scanner;

public class BlackJackTable {
    private final String BANNER_START = "----------------------------------------------";
    private final String BANNER_END = "----------------------------------------------";

    private final Scanner scanner;
    private final Deck deck;
    private final Dealer dealer;
    boolean gamblerWon = false;

    public BlackJackTable(Scanner scanner) {
	this.scanner = scanner;
	dealer = new Dealer();
	deck = dealer.createNewDeck();
	dealer.shuffle(deck);
    }

    public boolean canBeginNewRound() {
	return deck.getCards().size() > 4;
	
    }

    public void startRound(Gambler gambler) {
	if (!canBeginNewRound()) {
	    throw new RuntimeException("No more round available");
	}
	System.out.println(BANNER_START);
	System.out.println("New Round");
	System.out.println(" Player 1: " + gambler.getName());
	System.out.println(" Player 2: Dealer");
	System.out.println(BANNER_END);
	dealer.hit(deck, dealer);
	dealer.hit(deck, dealer);
	dealer.hit(deck, gambler);
	dealer.hit(deck, gambler);
    }

    public void play(Gambler gambler) {
	int lastChoice = 0;
	while (gamblerCanPlay(gambler) && lastChoice != 1) {
	    lastChoice = getChoice();
	    if (lastChoice == 2) {
		dealer.hit(deck, gambler);
		showHands(gambler);
	    }
	}
    }

    private boolean gamblerCanPlay(Gambler gambler) {
	if (gambler.hasBusted()) {
	    return false;
	}
	return !gambler.isBlackJackHand();
    }

    private int getChoice() {
	int choice = 0;
	presentOptions();
	while (choice != 1 && choice != 2) {
	    choice = scanner.nextInt();
	    if (choice != 1 && choice != 2) {
		System.out.println("Invalid choice");
		presentOptions();
	    }
	}
	return choice;
    }

    private void presentOptions() {
	System.out.println("---- How do you want to continue? ----");
	System.out.println("1) Stand");
	System.out.println("2) Hit");
    }

    public void finishRound(Gambler gambler) {
	while (dealer.getCurrentPoints() < 16) {
	    dealer.hit(deck, dealer);
	}
	int gamblersPoints = gambler.getCurrentPoints();
	int dealersPoints = dealer.getCurrentPoints();
	System.out.println(BANNER_START);
	System.out.println(" Finished Round ");
	System.out.println(" " + gambler.getName() + "'s score: " + gamblersPoints);
	System.out.println(" " + gambler.getName() + "'s hand: " + gambler.revealHand());
	System.out.println(" Dealer's score: " + dealersPoints);
	System.out.println(" Dealer's hand: " + dealer.revealHand());
	String result = "";
	if (gambler.hasBusted()) {
	    result = gambler.getName() + " has busted and lost. Score exceeds 21.";
	} else if (gambler.isBlackJackHand()) {
	    result = gambler.getName() + " has blackjack hand. Gambler wins!";
	    gamblerWon = true;
	} else if (gamblersPoints == dealersPoints) {
	    result = "Dealer has same score as " + gambler.getName() + ". " + gambler.getName() + " wins!";
	    gamblerWon = true;
	} else if (dealer.hasBusted()) {
	    result = "Dealer has busted and lost. Score exceeds 21. " + gambler.getName() + " wins!";
	    gamblerWon = true;
	} else if (gamblersPoints > dealersPoints) {
	    result = gambler.getName() + " wins, closer to 21!";
	    gamblerWon = true;
	} else if (gamblersPoints < dealersPoints) {
	    result = "Dealer wins, closer to 21!";
	}
	System.out.println(" Result: " + result);
	System.out.println(BANNER_END);
	dealer.clearHand();
	gambler.clearHand();
    }

    public void updateBalance(int bet, Gambler gambler) {
	if (gamblerWon == true) {
	    gambler.setBalance(gambler.getBalance() + bet);
	} else if (gamblerWon == false){
	    gambler.setBalance(gambler.getBalance() - bet);
	}
    }

    /**
     * Show gamblers hand as well as dealers first card
     * 
     * @param gambler Gambler
     */
    public void showHands(Gambler gambler) {
	System.out.println("Dealer Hand:");
	dealer.showHand();
	System.out.println();
	System.out.println(gambler.getName() + "'s Hand:");
	gambler.showHand();
    }
}