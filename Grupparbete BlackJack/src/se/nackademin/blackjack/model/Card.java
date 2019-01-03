package se.nackademin.blackjack.model;
public class Card{
	private String suit;
	private String rank;
	private int value;
	
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

	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + ", value=" + value + "]";
	}
}