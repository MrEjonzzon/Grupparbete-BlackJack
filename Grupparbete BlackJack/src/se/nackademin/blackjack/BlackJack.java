package se.nackademin.blackjack;

import se.nackademin.blackjack.model.Gambler;
import se.nackademin.blackjack.service.BlackJackTable;

import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        System.out.println('\u2663');
        Scanner scanner = new Scanner(System.in);
        BlackJackTable table = new BlackJackTable(scanner);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        Gambler gambler = new Gambler(name);
        while (table.canBeginNewRound()) {
            table.startRound(gambler);
            table.showHands(gambler);
            table.play(gambler);
            table.finishRound(gambler);
        }
        scanner.close();
    }
}
