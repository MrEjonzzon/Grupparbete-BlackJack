package se.nackademin.blackjack.model;

import se.nackademin.blackjack.db.Database;

public class Player {
    private String name;
    private int balance, handValue;
    Database database = new Database();
    int dealerHandValue = 0; // temporary
    int playerHandValue = 1; // temporary

    public Player(String name, int balance) {
	setName(name);
	setBalance(balance);
	// String Hand[];
	// setHandValue(0);

    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getBalance() {
	return balance;
    }

    public void setBalance(int balance) {
	this.balance = balance;
    }

    public int getHandValue() {
	return handValue;
    }

    public void setHandValue(int handValue) {
	this.handValue = handValue;
    }

    public void drawCard(int cardAmount) {
	// deck.draw
	// add to player.hand
	// handValue += newcard

    }

    void bust(int betAmount) {
	database.setBalance(database.getBalance() - betAmount);
    }

    void win(int betAmount) {
	database.setBalance(database.getBalance() + betAmount);
    }

    public void playRound(int betAmount) {
	if (betAmount <= database.getBalance()) {
	    if (playerHandValue < dealerHandValue) {
		bust(betAmount);
	    } else if (playerHandValue > dealerHandValue) {
		win(betAmount);
	    } else {
		System.out.println("Draw");
	    }
	}
    }
}
