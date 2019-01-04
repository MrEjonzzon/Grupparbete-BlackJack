package se.nackademin.blackjack.model;

import se.nackademin.blackjack.db.Database;

public class Player {
    private String name;
    private int balance, handValue;

    int dealerHandValue = 0; // temporary
    int playerHandValue = 1; // temporary

    public Player(String name, int balance) {
	this.name = name;
	this.balance = balance;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getBalance() {
	return balance;
    }

    public void setBalance(int balance) {
	this.balance = balance;
    }

    public int getHandValue() {
	return handValue;
    }

    public void setHandValue(int handValue) {
	this.handValue = handValue;
    }

    public void drawCard(int cardAmount) {
	// deck.draw
	// add to player.hand
	// handValue += newcard
    }

    void bust(int betAmount) {
	int bustAmmount = balance - betAmount;
	System.out.println(bustAmmount);
    }

    public void win(int betAmount) {
	int winAmmount = balance + betAmount;
	System.out.println(winAmmount);
    }

    public void playRound(int betAmount, int playerHandValue, int dealerHandValue) {
	if (betAmount <= balance) {
	    if (playerHandValue < dealerHandValue) {
		bust(betAmount);
	    } else if (playerHandValue > dealerHandValue) {
		win(betAmount);
	    } else {
		System.out.println("Draw");
	    }
	}
    }
}