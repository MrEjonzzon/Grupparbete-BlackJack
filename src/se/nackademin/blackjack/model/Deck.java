package se.nackademin.blackjack.model;

import java.util.List;

public class Deck {
	//variable
	private final List<Card> cards;
	
	//Deck constructor
	public Deck(List<Card> cards){
		//Set variable cards with constructor parameters cards
		this.cards = cards;
	}
	
	public List<Card> getCards() {
		return cards;
	}
}