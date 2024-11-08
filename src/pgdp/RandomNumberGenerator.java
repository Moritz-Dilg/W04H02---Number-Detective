package pgdp;

import java.util.Random;

/*
 * DON'T TOUCH THIS!
 * This is part of the template.
 */
public class RandomNumberGenerator {
    private static RandomNumberGenerator generator;
    private final Random rnd;

    private RandomNumberGenerator() {
        rnd = new Random();
    }

    public static RandomNumberGenerator getGenerator() {
        if (generator == null) {
            generator = new RandomNumberGenerator();
        }
        return generator;
    }

    /**
     * @return a random value between 0 (inclusive) and the upperBound (exclusive)
     */
    public int generate(int upperBound) {
        return rnd.nextInt(upperBound);
    }


    // <======== with seed for testing ========>

    private RandomNumberGenerator(int seed) {
        rnd = new Random(seed);
    }

    public static RandomNumberGenerator getGenerator(int seed) {
        if (generator == null) {
            generator = new RandomNumberGenerator(seed);
        }
        return generator;
    }
}
