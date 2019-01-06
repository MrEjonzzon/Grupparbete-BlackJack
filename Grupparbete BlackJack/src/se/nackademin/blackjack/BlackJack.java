package se.nackademin.blackjack;

import se.nackademin.blackjack.db.Database;
import se.nackademin.blackjack.model.Gambler;
import se.nackademin.blackjack.service.BlackJackTable;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		boolean loggedIn = false;
		Scanner scanner = new Scanner(System.in);
		Database database = new Database(scanner);
		BlackJackTable table = new BlackJackTable(scanner, database);
		while (loggedIn == false) {
			System.out.println("Welcome to Black Jack!");
			System.out.print("[1] Login\n[2] Register\nEnter: ");
			String loginMeny = scanner.next();
			try {
				int userChoice = Integer.parseInt(loginMeny);
				switch (userChoice) {
				case 1:
					database.login();
					if (database.isGoToGame() == true) {
						loggedIn = true;
					}
					break;
				case 2:
					database.register();
					if (database.isGoToGame() == false) {
						database.login();
					}
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Enter only numbers");
			}
			while (loggedIn) {
				Gambler gambler = new Gambler(database.getUserName(), database.getBalance());
				System.out.print("[1] Play\n[2] Check Balance\n[3] Deposit \n[4] Logout ");
				String startMenu = scanner.next();
				boolean gameSwitch = table.canBeginNewRound();
				try {
					int userChoice = Integer.parseInt(startMenu);
					switch (userChoice) {
					case 1:
						while (gameSwitch && gambler.getBalance() > 0) {
							System.out.println("How much would you like to bet?");
							int bet = scanner.nextInt();
							if (bet >= 0) {
								table.startRound(gambler);
								table.showHands(gambler);
								table.play(gambler);
								table.finishRound(gambler);
								table.updateBalance(bet, gambler);
								gameSwitch = false;
							} else {
								System.out.println("Your balance is lower than bet");
							}
						}
					case 2:
						System.out.println("Your balance is:" + gambler.getBalance());
						break;
					case 3:
						System.out.println("How much do you want to deposit? ");
						int deposit = scanner.nextInt();
						database.setBalance(gambler.getBalance() + deposit);
						break;
					case 4:
						loggedIn = false;
					default:
						break;
					}
				} catch (Exception e) {
					System.out.println("Invalid Selection");
				}
			}
		}
		scanner.close();
	}
}