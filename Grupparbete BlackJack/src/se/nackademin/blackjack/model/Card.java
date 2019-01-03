public class Card{
	private String suit;
	private String label;
	private int rank;
	
	public Card (String suit, String label, int rank ) {
		this.suit = suit;
		this.label = label;
		this.rank = rank;
	}
	
	public String getsuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getlabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", label=" + label + ", rank=" + rank + "]";
	}
	
	
}