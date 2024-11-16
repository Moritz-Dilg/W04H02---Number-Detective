package pgdp.game;

import pgdp.InputReader;
import pgdp.RandomNumberGenerator;

public class GuessTheNumber {

    public void guessTheNumber() {
        // TODO
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
