package se.nackademin.blackjack.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    
    
    public int value;
    
    
    
    public enum Rank {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), Jack(10), Queen(10), King(10), Ace(11);
	private final int value;
	Rank(int value) {
		this.value = value;
	    }
	
	public int getValue() {
	    return value;
	}
    }
    
    public void valueof2() {
	System.out.println(Rank.TWO.value);
    }
    
    public enum Suit {
	CLUBS, DIAMONDS, HEARTS, SPADES;
    }
    
    public Card[] deck = new Card[52];
    
    public void createDeck () {
	int currentCard = 0;
	for (Rank r : Rank.values()) {
	    for (Suit s : Suit.values()) {
		Card card = new Card(r,s);
		deck[currentCard] = card;
		currentCard++;
	    }
	}
    }

    
    
    public Card[] getDeck() {
	createDeck();
	List <Card> cards = Arrays.asList(deck);
	Collections.shuffle(cards);
	return deck;
    }
    
    
    public String toString() {
	String deckString = "";
	for (int i = 0; i < deck.length-1; i++) {
	    deckString += deck[i];
	}
	return deckString;
    }
   
    

    

}

