package se.nackademin.blackjack.model;

import java.util.List;
import se.nackademin.blackjack.model.Card;

public class Deck {
	//variable
	private final List<Card> cards;
	
	public Deck(List<Card> cards){
		//Set variable cards with constructor parameters cards
		this.cards = cards;
	}
	
	public List<Card> getCards() {
		return cards;
	}
}