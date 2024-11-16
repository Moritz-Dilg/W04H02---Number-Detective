package pgdp.game;

import pgdp.InputReader;
import pgdp.RandomNumberGenerator;

public class GuessTheNumber {

	public void guessTheNumber() {
		int lives = 3;
		int points = 0;
		RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.getGenerator(1304);
		System.out.println("Hello, Number Detective!");

		while (true) {
			System.out.println("You have " + lives + " lives and " + points + " points.");
			printMenu();

			int difficultyLevel;
			int randNum = 0;
			int maxNAttempts = 0;
			do {
				difficultyLevel = InputReader.readInt();
				switch (difficultyLevel) {
					case 1:
						randNum = randomNumberGenerator.generate(100);
						maxNAttempts = 8;
						break;
					case 2:
						randNum = randomNumberGenerator.generate(500);
						maxNAttempts = 10;
						break;
					case 3:
						randNum = randomNumberGenerator.generate(1000);
						maxNAttempts = 10;
						break;
					case 4:
						System.out.println("Goodbye!");
						System.out.println("You are leaving with " + points + " points!");
						return;
					default:
						System.out.println("This was not a valid choice, please try again.");
				}
			} while (difficultyLevel < 1 || difficultyLevel > 4);

			int nAttempts;
			for (nAttempts = 1; nAttempts <= maxNAttempts; nAttempts++) {
				if (nAttempts == maxNAttempts && points >= 600) {
					System.out.println("LAST ATTEMPT! Do you want to buy a hint for 600 points? (1) yes (2) no");
					int hintChoice;
					while (true) {
						hintChoice = InputReader.readInt();
						if (hintChoice == 1) {
							System.out.println(randNum % 2 == 0 ? "The number is even!" : "The number is odd!");
							points -= 600;
							break;
						} else if (hintChoice == 2) {
							break;
						} else {
							System.out.println("This was not a valid choice, please try again.");
						}
					}
				}
				System.out.println("(" + nAttempts + "/" + maxNAttempts + ") Enter your guess:");
				int guess = InputReader.readInt();
				if (guess == randNum) {
					System.out.println("Congrats! You guessed the correct number.");
					switch (difficultyLevel) {
						case 1:
							points += 200;
							break;
						case 2:
							points += 200;
							lives++;
							break;
						case 3:
							points += 500;
							lives += 3;
							break;
					}
					break;
				} else if (guess < randNum && nAttempts < maxNAttempts) {
					System.out.println("The number is higher.");
				} else if (guess > randNum && nAttempts < maxNAttempts) {
					System.out.println("The number is lower.");
				}
			}

			if (nAttempts > maxNAttempts) {
				System.out.println("Sorry, you've used all attempts. The correct number was " + randNum + ".");
				lives--;
				if (lives == 0) {
					System.out.println("Game over! You are out of lives.");
					System.out.println("You are leaving with " + points + " points!");
					return;
				}
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
