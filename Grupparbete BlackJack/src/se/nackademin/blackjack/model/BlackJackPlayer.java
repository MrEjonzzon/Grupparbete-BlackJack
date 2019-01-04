package se.nackademin.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public abstract class BlackJackPlayer {
    private final String name;
    private final List<Card> currentHand;

    public BlackJackPlayer(String name) {
        this.name = name;
        currentHand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getCurrentHand() {
        return currentHand;
    }

    public int getCurrentPoints() {
        int currentPoints = 0;
        for (Card card : currentHand) {
            currentPoints += card.getValue();
        }
        return currentPoints;
    }

    public boolean hasBusted() {
        return getCurrentPoints() > 21;
    }

    public boolean isBlackJackHand() {
        return getCurrentPoints() == 21;
    }

    public void hitMe(Card card) {
        currentHand.add(card);
    }

    public void clearHand() {
        currentHand.clear();
    }

    public abstract void showHand();

    public String revealHand() {
        String hand = "";
        for (Card card : currentHand) {
            hand += ", " + card;
        }
        return hand;
    }
}
