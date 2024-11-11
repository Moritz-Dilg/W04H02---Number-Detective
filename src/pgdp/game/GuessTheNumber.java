package pgdp.game;

import pgdp.InputReader;
import pgdp.RandomNumberGenerator;

public class GuessTheNumber {
	private int lives;
	private int points;

	public void guessTheNumber() {
		System.out.println("Hello, Number Detective!");
		System.out.println("You have " + lives + " lives and " + points + " points.");

		while (true) {
			printMenu();
			int choice = InputReader.readInt();

			switch (choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					System.out.println("Goodbye!");
					System.out.println("You are leaving with " + points + " points!");
					return;
				default:
					System.out.println("This was not a valid choice, please try again.");
					continue;
			}
		}
	}


	// <==================================== HELPER METHODS ====================================>

	private void printMenu() {
		System.out.println("Choose difficulty level to start a new game:\n" +
				"(1) Easy   [0;100)   8 Attempts, Reward: +200 Points\n" +
				"(2) Medium [0;500)  10 Attempts, Reward: +200 Points +1 Life\n" +
				"(3) Hard   [0;1000) 10 Attempts, Reward: +500 Points +3 Lives\n" +
				"(4) Exit");
	}

	public static void main(String[] args) {
		new GuessTheNumber().guessTheNumber();
	}

}
