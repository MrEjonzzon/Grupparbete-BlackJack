import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
	boolean loggedIn = false;
	Scanner scanner = new Scanner(System.in);
	int money, bet;
	//Card card = new Card();
	//Database database = new Database();
	//Player dealer = new Player();
	//Player player = new Player();
	//Deck deck = new deck();
	

	System.out.println("Welcome to BlackJack");
	System.out.println("Press 1 to Login");
	System.out.println("Press 2 to Register");
	int selection = scanner.nextInt();
	switch (selection) {
	case 1:
	    // Database.login() or something
	    // if(userName == userName in Database
	    System.out.println("You have been logged in");
	    loggedIn = true;
	    // else
	    // syso "wrong username";
	    break;
	case 2:
	    // Database.register() or something
	    System.out.println("You have been registered");
	    break;
	default:
	    System.out.println("Invalid selection, try again");
	    break;

	}
	
	while(loggedIn) {
	    //deck.shuffle()
	    //player.draw(2)
	    //dealer.draw(2)
	    //syso "dealer has card : + card1.value"
	    //syso "press 1 to hit, 2 to stand"
	    
	}
	
	scanner.close();

    }
    


}
