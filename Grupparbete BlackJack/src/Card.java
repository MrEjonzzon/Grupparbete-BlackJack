
public class Card {

    private String rank, suit;

    public Card(String rank, String suit) {
	this.rank = rank;
	this.suit = suit;

    }

    public String getSuit() {
	return suit;
    }

    public String getRank() {
	return rank;
    }

    public String toString() {
	getRank();
	getSuit();
	String cardString = getRank() + " of " + getSuit() + " ";
	return cardString;

    }

}
