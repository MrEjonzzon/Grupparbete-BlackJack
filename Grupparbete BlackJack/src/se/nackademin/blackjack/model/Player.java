package se.nackademin.blackjack.model;

public class Player {
    private String name;
    private int balance, handValue;

    public Player(String name, int balance) {
	setName(name);
	setBalance(balance);
	String Hand[];
	setHandValue(0);
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
	//deck.draw
	//add to player.hand
	//handValue += newcard


    }

    public int bet(int betAmount) {
	int pot;
	pot += betAmount;
    }
