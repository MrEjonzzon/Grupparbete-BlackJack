import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import se.nackademin.blackjack.db.Database;
import se.nackademin.blackjack.model.Deck;
import se.nackademin.blackjack.model.Gambler;
import se.nackademin.blackjack.service.Dealer;

public class test {

    @Test
    public void testDB() {
	Database database = new Database();
	int beforeUpdate = database.getBalance();
	database.setBalance(beforeUpdate + 100);
	int updatedBalance = database.getBalance();
	assertEquals("Balance shouldbe 600", updatedBalance, beforeUpdate + 100);
    }
    
    @Test
    public void nameCheck() {
	Database database = new Database();
	assertEquals("Name should be null", null, database.getUserName());
    }
    
    @Test
    public void deckCount() {
	Dealer dealer = new Dealer();
	Deck deck = dealer.createNewDeck();
	assertEquals("Deck should have 52 cards", deck.getCards().size(), 52);
    }
}

