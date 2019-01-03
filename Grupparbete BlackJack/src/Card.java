
public class Card {

    private String rank, suit;
    private int value;

    public Card(String rank, String suit, int value) {
	this.rank = rank;
	this.suit = suit;

    }

    public String getSuit() {
	return suit;
    }

    public String getRank() {
	return rank;
    }

    public int getValue() {
	return value;
    }

    public void setValue(int value) {
	this.value = value;
    }

    public String toString() {
	String suitString = this.suit;
	String rankString = this.rank;
	String cardString = rankString + " of " + suitString;
	return cardString;

    }

}
