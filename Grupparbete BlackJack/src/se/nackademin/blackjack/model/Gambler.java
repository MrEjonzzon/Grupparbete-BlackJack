package se.nackademin.blackjack.model;

public class Gambler extends BlackJackPlayer {

    public Gambler(String name) {
        super(name);
    }

    @Override
    public void showHand() {
        System.out.println("---- Current Points: " + getCurrentPoints() + " ----");
        for (Card card : getCurrentHand()) {
            System.out.println(card.toString());
        }
    }
}
