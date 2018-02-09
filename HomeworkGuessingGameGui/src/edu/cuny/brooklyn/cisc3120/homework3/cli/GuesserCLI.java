package edu.cuny.brooklyn.cisc3120.homework3.cli;

import java.util.Scanner;
import edu.cuny.brooklyn.cisc3120.homework3.core.*;

class GuesserCLI implements IGuesser {
	Scanner input = new Scanner(System.in);
    Configuration config;

    public GuesserCLI(Configuration config)
    {
        this.config = config;
    }

    public int nextGuess()
    {
        int guess = 0;
        while (true) {
            try {
                // Read input from the command line.
                System.out.printf("Guess a number between 1 and %d:\n", this.config.getMaxNumber());
                guess = input.nextInt();
                return guess;
            } catch (java.util.InputMismatchException ex) {
                System.out.println("You have to enter a number dummy!");
                input.nextLine();
           }
        }
    }
}

