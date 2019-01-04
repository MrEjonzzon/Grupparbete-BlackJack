package se.nackademin.blackjack;

import java.util.Scanner;
import se.nackademin.blackjack.db.Database;
import se.nackademin.blackjack.model.Deck;
import se.nackademin.blackjack.model.Player;


public class Game {
    private Database database;
    private Player player;
    
    public static void main(String[] args) {
	boolean loggedIn = false;
	boolean gameOn = true;
	Scanner scanner = new Scanner(System.in);


	System.out.println("Welcome to BlackJack");
	System.out.println("[1] Login");
	System.out.println("[2] Register");
	System.out.print("Enter: ");

	String selection = scanner.next();

	try {
	    int select = Integer.parseInt(selection);
	    switch (select) {
	    case 1:
		database.login();
		loggedIn = true;
		break;

	    case 2:
		database.register();
		if (database.isGoToGame() == true) {
		    loggedIn = true;
		}
		break;

	    default:
		System.out.println("Invalid selection, try again");
		break;

	    }
	} catch (NumberFormatException e) {
	    System.out.println("Something went wrong! \nPlease enter numbers between 1-2");
	}

	while (loggedIn) {
	    Player player = new Player(database.getUserName(), database.getBalance());

	    while (gameOn) {
		// player.draw(2)
		// dealer.draw(2)
		// player.setHandvalue(card1 + card2)
		// dealer.setHandvalue(card1 + card2)
		System.out.println("[1] Hit");
		System.out.println("[2] Stand");
		String gameSelection = scanner.next();
		try {
		    int gameSelect = Integer.parseInt(gameSelection);
		    switch (gameSelect) {
		    case 1:
			// player.draw(1)
			break;
		    case 2:
			gameOn = false;
			break;
		    default:
			System.out.println("Invalid selection");

		    }

		}

		catch (NumberFormatException e) {
		    System.out.println("Something went wrong! \nPlease enter numbers between 1-2");
		}
		// deck.shuffle()

		// syso "dealer has card : + card1.value"
		// syso "press 1 to hit, 2 to stand"

	    }

	}

	scanner.close();

    }

}
