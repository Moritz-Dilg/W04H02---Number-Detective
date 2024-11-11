package pgdp.game;

import pgdp.InputReader;
import pgdp.RandomNumberGenerator;

public class GuessTheNumber {
	private int lives = 3;
	private int points;

	public void guessTheNumber() {
		System.out.println("Hello, Number Detective!");
		System.out.println("You have " + lives + " lives and " + points + " points.");
		printMenu();

		while (true) {
			int choice = InputReader.readInt();
			int randNum = 0;
			int maxAttempts = 0;

			switch (choice) {
				case 1:
					randNum = RandomNumberGenerator.getGenerator().generate(100);
					maxAttempts = 8;
					break;
				case 2:
					randNum = RandomNumberGenerator.getGenerator().generate(500);
					maxAttempts = 10;
					break;
				case 3:
					randNum = RandomNumberGenerator.getGenerator().generate(1000);
					maxAttempts = 10;
					break;
				case 4:
					System.out.println("Goodbye!");
					System.out.println("You are leaving with " + points + " points!");
					return;
				default:
					System.out.println("This was not a valid choice, please try again.");
					continue;
			}

			int attempt;
			for (attempt = 1; attempt <= maxAttempts; attempt++) {
				if (attempt == maxAttempts && points >= 600) {
					System.out.println("LAST ATTEMPT! Do you want to buy a hint for 600 points? (1) yes (2) no");
					while (true) {
						int choiceBuyHint = InputReader.readInt();
						if (choiceBuyHint == 1) {
							points -= 600;
							System.out.println(randNum % 2 == 0 ? "The number is even!" : "The number is odd!");
							break;
						} else if (choiceBuyHint < 1 || choiceBuyHint > 2) {
							System.out.println("This was not a valid choice, please try again.");
						}
					}
				}
				System.out.println("(" + attempt + "/" + maxAttempts + ") Enter your guess:");
				int guess = InputReader.readInt();
				if (guess < randNum && attempt != maxAttempts) System.out.println("The number is higher.");
				else if (guess > randNum && attempt != maxAttempts) System.out.println("The number is lower.");
				else if (guess == randNum) {
					System.out.println("Congrats! You guessed the correct number.");
					switch (choice) {
						case 1:
							points += 200;
							break;
						case 2:
							points += 200;
							lives += 1;
							break;
						case 3:
							points += 500;
							lives += 3;
							break;
					}
					attempt = -1;
					break;
				}
			}

			if (attempt != -1) {
				System.out.println("Sorry, you've used all attempts. The correct number was " + randNum + "."+lives);
				lives--;
			}

			if (lives == 0) {
				System.out.println("Game over! You are out of lives.");
				System.out.println("You are leaving with " + points + " points!");
				return;
			}

			System.out.println("You have " + lives + " lives and " + points + " points.");
			printMenu();
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
