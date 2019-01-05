package se.nackademin.blackjack.service;
import se.nackademin.blackjack.model.BlackJackPlayer;
import se.nackademin.blackjack.model.Deck;
import java.util.ArrayList;
import java.util.List;

import se.nackademin.blackjack.model.Card;

import java.util.Collections;


public class Dealer extends BlackJackPlayer {
	private final String[] rank = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	private final String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private final int [] value = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

	public Dealer() {
		super("Dealer", 0);
	}

	/**
	 * This method creates a new deck.
	 * @return A new deck with 52 sorted card in it.
	 */
	public Deck createNewDeck() {
		List<Card> cards = new ArrayList<>();
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < suit.length; j++) {
				Card card = new Card(rank[i], suit[j], value[i]);
				cards.add(card);
			}
		}
		Deck deck = new Deck(cards);
		return deck;
	}
	
	/**
	 * This method shuffles the cards in a deck.
	 * @param deck Deck to shuffle the cards in it.
	 * @return deck with shuffled cards.
	 */
	public Deck shuffle(Deck deck) {
		Collections.shuffle(deck.getCards());
		return deck;
	}

	public void hit(Deck deck, BlackJackPlayer player) {
		Card card = deck.getCards().get(0);
		deck.getCards().remove(card);
		player.hitMe(card);
	}

	@Override
	public void showHand() {
		System.out.println("---- Visible Points: " + getCurrentHand().get(1).getValue() + " ----");
		System.out.println(getCurrentHand().get(1));
	}
}