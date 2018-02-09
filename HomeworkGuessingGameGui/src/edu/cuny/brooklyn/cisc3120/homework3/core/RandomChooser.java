package edu.cuny.brooklyn.cisc3120.homework3.core;

import java.util.Random;

public class RandomChooser implements IChooser {
    private int choice;

    public RandomChooser(Configuration config)
    {
        Random generator = new Random();
        choice = generator.nextInt(config.getMaxNumber()) + 1;
    }

    public IChooser.ComparisonResult checkGuess(int guess)
    {
        if (choice < guess) {
            return IChooser.ComparisonResult.TooHigh;
        } else if (choice > guess) {
            return IChooser.ComparisonResult.TooLow;
        }
        return IChooser.ComparisonResult.Correct;
    }
}

