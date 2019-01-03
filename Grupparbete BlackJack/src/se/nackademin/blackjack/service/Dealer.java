package se.nackademin.blackjack.service;
import se.nackademin.blackjack.model.Deck;
import java.util.ArrayList;
import java.util.List;

import se.nackademin.blackjack.model.Card;

import java.util.Collections;


public class Dealer {
	private final String[] rank = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	private final String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private final int [] value = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

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
	
	public Deck shuffle(Deck deck) {
		Collections.shuffle(deck.getCards());
		return deck;
	}
}