package se.nackademin.blackjack.model;
public class Card{
	private String rank;
	private String suit;
	private int value;
	
	//Constructor of Card class
	public Card (String rank, String suit, int value ) {
		this.rank = rank;
		this.suit = suit;
		this.value = value;
	}
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	private String getSuiteChar() {
		String symb = "";
		if (suit.equals("Clubs")) {
			symb = "Clubs";
			return symb;
		} else if (suit.equals("Diamonds")) {
			symb = "Diamonds";
			return symb;
		} else if (suit.equals("Hearts")) {
			symb = "Hearts";
			return symb;
		} else if (suit.equals("Spades")) {
			symb = "Spades";
			return symb;
		}
		return symb;
	}

	@Override
	public String toString() {
		return rank + " of " + getSuiteChar();
	}
}


    
