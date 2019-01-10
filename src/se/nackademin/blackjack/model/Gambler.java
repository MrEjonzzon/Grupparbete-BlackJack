package se.nackademin.blackjack.model;

public class Gambler extends BlackJackPlayer {

    public Gambler(String name, int balance) {
        super(name, balance);
        
    }

    @Override
    public void showHand() {
        System.out.println("---- Current Points: " + getCurrentPoints() + " ----");
        for (Card card : getCurrentHand()) {
            System.out.println(card.toString());
        }
    }
}
