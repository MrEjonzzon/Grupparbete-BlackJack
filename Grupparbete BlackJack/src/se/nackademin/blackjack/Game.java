package se.nackademin.blackjack;
import java.util.List;
import java.util.Scanner;

import se.nackademin.blackjack.db.Database;
import se.nackademin.blackjack.model.Card;
import se.nackademin.blackjack.model.Deck;
import se.nackademin.blackjack.service.Dealer;

public class Game {

	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		List<Card> cards = dealer.createNewDeck();
		System.out.println(cards);
		System.out.println(dealer.shuffle(cards));
		boolean loggedIn = false;
		Scanner scanner = new Scanner(System.in);
		int money, bet;
		// Card card = new Card();
		Database database = new Database();
		// Player dealer = new Player();
		// Player player = new Player();

		//System.out.println(deck.toString());

		System.out.println("Welcome to BlackJack");
		System.out.println("[1] Login");
		System.out.println("[2] Register");
		System.out.print("Enter: ");
		
		String selection = scanner.next();
		try 
		{
			int select = Integer.parseInt(selection);
			
			switch (select) {
			case 1:
				System.out.print("Enter username: ");
				String loggInName = scanner.next();
				System.out.print("Enter password: ");
				String loggInpassword = scanner.next();
				database.login(loggInName, loggInpassword);
				loggedIn = true;
				break;
				
			case 2:
				System.out.print("Enter username: ");
				String registerName = scanner.next();
				System.out.print("Enter password: ");
				String registerPassword = scanner.next();
				database.register(registerName, registerPassword);
				break;
				
			default:
				System.out.println("Invalid selection, try again");
				break;

			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Something went wrong! \nPlease enter numbers between 1-2");
		}


		while (loggedIn) {
			// deck.shuffle()
			// player.draw(2)
			// dealer.draw(2)
			// syso "dealer has card : + card1.value"
			// syso "press 1 to hit, 2 to stand"

		}

		scanner.close();

	}
}
