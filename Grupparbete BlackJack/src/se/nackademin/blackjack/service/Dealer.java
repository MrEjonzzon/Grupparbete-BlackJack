package se.nackademin.blackjack.service;
import java.util.ArrayList;
import java.util.List;

import se.nackademin.blackjack.model.Card;

import java.util.Collections;

public class Dealer {
	
	public List<Card> createNewDeck() {
		List<Card> deck = new ArrayList<Card>();
		
		//Card card1 = new Card("Ace", "Clubs", 1);
		//deck.add(card1);
		Card card2 = new Card("2", "Clubs", 2);
		deck.add(card2);
		Card card3 = new Card("3", "Clubs", 3);
		deck.add(card3);
		Card card4 = new Card("4", "Clubs" , 4);
		deck.add(card4);
		Card card5 = new Card("5", "clubs", 5);
		deck.add(card5);
		Card card6 = new Card("6", "Clubs", 6);
		deck.add(card6);
		Card card7 = new Card("7", "Clubs", 7);
		deck.add(card7);
		Card card8 = new Card("8", "Clubs", 8);
		deck.add(card8);
		Card card9 = new Card("9", "Clubs", 9);
		deck.add(card9);
		Card card10 = new Card("10", "Clubs", 10);
		deck.add(card10);
		Card card11 = new Card("Jack", "Clubs", 10);
		deck.add(card11);
		Card card12 = new Card("Queen", "Clubs", 10);
		deck.add(card12);
		Card card13 = new Card("King", "Clubs", 10);
		deck.add(card13);
		Card card14 = new Card("Ace", "Clubs", 11);
		deck.add(card14);
		//Card card15 = new Card("Ace", "Hearts", 1);
		//deck.add(card15);
		Card card16 = new Card("2", "Hearts", 2);
		deck.add(card16);
		Card card17 = new Card("3", "Hearts", 3);
		deck.add(card17);
		Card card18 = new Card("4", "Hearts", 4);
		deck.add(card18);
		Card card19 = new Card("5", "Hearts", 5);
		deck.add(card19);
		Card card20 = new Card("6", "Hearts", 6);
		deck.add(card20);
		Card card21 = new Card("7", "Hearts", 7);
		deck.add(card21);
		Card card22 = new Card("8", "Hearts", 8);
		deck.add(card22);
		Card card23 = new Card("9", "Hearts", 9);
		deck.add(card23);
		Card card24 = new Card("10", "Hearts", 10);
		deck.add(card24);
		Card card25 = new Card("Jack", "Hearts", 10);
		deck.add(card25);
		Card card26 = new Card("Queen", "Hearts", 10);
		deck.add(card26);
		Card card27 = new Card("King", "Hearts", 10);
		deck.add(card27);
		Card card28 = new Card("Ace", "Hearts", 11);
		deck.add(card28);
		//Card card29 = new Card("Ace", "Diamonds", 1);
		//deck.add(card29);
		Card card30 = new Card("2", "Diamonds", 2);
		deck.add(card30);
		Card card31 = new Card("3", "Diamonds", 3);
		deck.add(card31);
		Card card32 = new Card("4", "Diamonds", 4);
		deck.add(card32);
		Card card33 = new Card("5", "Diamonds", 5);
		deck.add(card33);
		Card card34 = new Card("6", "Diamonds", 6);
		deck.add(card34);
		Card card35= new Card("7", "Diamonds", 7);
		deck.add(card35);
		Card card36 = new Card("8", "Diamonds", 8);
		deck.add(card36);
		Card card37 = new Card("9", "Diamonds", 9);
		deck.add(card37);
		Card card38 = new Card("10", "Diamonds", 10);
		deck.add(card38);
		Card card39 = new Card("Jack", "Diamonds", 10);
		deck.add(card39);
		Card card40 = new Card("Queen", "Diamonds", 10);
		deck.add(card40);
		Card card41 = new Card("King", "Diamonds", 10);
		deck.add(card41);
		Card card42 = new Card("Ace", "Diamonds", 11);
		deck.add(card42);
		//Card card43 = new Card("Ace", "Spades", 1);
		//deck.add(card43);
		Card card44 = new Card("2", "Spades", 2);
		deck.add(card44);
		Card card45 = new Card("3", "Spades", 3);
		deck.add(card45);
		Card card46 = new Card("4", "Spades", 4);
		deck.add(card46);
		Card card47 = new Card("5", "Spades", 5);
		deck.add(card47);
		Card card48 = new Card("6", "Spades", 6);
		deck.add(card48);
		Card card49= new Card("7", "Spades", 7);
		deck.add(card49);
		Card card50 = new Card("8", "Spades", 8);
		deck.add(card50);
		Card card51 = new Card("9", "Spades", 9);
		deck.add(card51);
		Card card52 = new Card("10", "Spades", 10);
		deck.add(card52);
		Card card53 = new Card("Jack", "Spades", 10);
		deck.add(card53);
		Card card54 = new Card("Queen", "Spades", 10);
		deck.add(card54);
		Card card55 = new Card("King", "Spades", 10);
		deck.add(card55);
		Card card56 = new Card("Ace", "Spades", 11);
		deck.add(card56);
		
		return deck;
	}
	
	public List<Card> shuffle(List<Card> cards ) {
		Collections.shuffle(cards);
		return cards;
	}
}