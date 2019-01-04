package se.nackademin.blackjack.model;

import se.nackademin.blackjack.model.Deck.Rank;
import se.nackademin.blackjack.model.Deck.Suit;

public class Card {

    Rank rank;
    private Suit suit;
    
    public Card(Rank r, Suit s) {
	this.rank = r;
	this.suit = s;

    }

    public Rank getRank() {
	return rank;
    }

    public void setRank(Rank rank) {
	this.rank = rank;
    }

    public Suit getSuit() {
	return suit;
    }

    public void setSuit(Suit suit) {
	this.suit = suit;
    }



    public String toString() {
	Suit suitString = this.suit;
	Rank rankString = this.rank;
	String cardString = "[" + rankString + " of " + suitString + "]";
	return cardString;

    }


}
