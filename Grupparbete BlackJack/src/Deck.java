
public class Deck {

    private String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
    private String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    private Card[] deck = new Card[52];

    public void createDeck() {
	int currentCard = 0;
	for (int i = 0; i < ranks.length; i++) {
	    for (int j = 0; j < suits.length; j++) {
		//Card card = new Card(ranks[i], suits[j]);
		//deck[currentCard] = card;
		currentCard++;
	    }
	}
    }

    public Card[] getDeck() {
	return deck;
    }

    public String toString() {
	String deckString = "";
	for (int i = 0; i < deck.length; i++) {
	    deckString += deck[i];
	}
	return deckString;
    }

}
