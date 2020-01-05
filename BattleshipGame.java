package battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipGame {

	/**
	 * Main class for a Human vs. Computer version of Battleships.
	 * Creates a single instance of Ocean. Gets user input(row and column)
	 * for interacting with and playing against the Computer.
	 * @author Shuxin He &amp; Xuanzhou Du
	 */
	public static void main(String[] args) {
		new BattleshipGame().run();
	}

	/**
	 * Prints a welcome message, then calls methods to perform each of the following
	 * actions: place ship in the ocean, prompt the user to enter row and column, display hit and miss,
	 * sank ship, end game, display user's final score, and ask if user want to play again
	 */
	public void run() {
		boolean playAgain = false;

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(i + "");
		}

		System.out.println("Welcome to Battleship!\n" + "\n" + "Rules:\n"
				+ "Ten ships are placed in the ocean (none are immediately adjacent to each other).\n"
				+ "You do not know where the ships are.\n"
				+ "Try hitting the ships by indicating a specific row and column number.\n"
				+ "Try to sink the fleet with as few shots as possible; the best possible score would be 20.\n");

		while (playAgain == false) {
			Ocean ocean = new Ocean();
			
			Scanner scanner = new Scanner(System.in);

			ocean.placeAllShipsRandomly();
			ocean.print();

			while (ocean.isGameOver() == false) {
				
				int row;
				int column;

				while (true) {
					System.out.println("Please enter row number (0 to 9):");
					String humanInputR = scanner.next();
					if (list.contains(humanInputR)) {
						row = Integer.parseInt(humanInputR);
						break;
					}
				}

				while (true) {
					System.out.println("Please enter column number (0 to 9):");
					String humanInputC = scanner.next();
					if (list.contains(humanInputC)) {
						column = Integer.parseInt(humanInputC);
						break;
					}
				}

				ocean.printHitOrMiss(row, column);
				ocean.tellShipSunk(ocean.getShipArray()[row][column]);
				ocean.print();

			}
			System.out.println("GAME OVER");
			System.out.println("Your total shots: " + ocean.getShotsFired());
			boolean askAgain = true;
			while (askAgain == true) {
				System.out.println("Play again? Please type \"y\" or \"n\".");
				String answer = scanner.next();
				if (answer.equals("n")|| answer .equals("N")) {
					System.out.println("Bye!");
					playAgain = true;
					//break;
					askAgain = false;
				} 
				
				if (answer.equals("y") || answer.equals("Y")) {
					System.out.println("Another round!");
					//break;
					askAgain = false;
				} 
			}
			scanner.close();
		}
	}
}
