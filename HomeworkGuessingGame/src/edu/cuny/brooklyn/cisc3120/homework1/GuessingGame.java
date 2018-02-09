package edu.cuny.brooklyn.cisc3120.homework1;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    // Extra Credit!
    // For every positive integer `n` that you pick for `maxInteger` there is
    // a positive integer `m` that you can pick for limit, such that the user
    // will always guess the number if they use the right strategy.
    // What is the smallest integer `m`, given as a function of `n`, with this property?
	// upper cieling [log base 2 n] + 1 
	static final int limit = 4;
    static final int maxInteger = 16;

	public static void main(String[] args) {
        // This creates a new random number generator
        Random rand = new Random();

        // This generates a random integer.  Note the "+1"!
        int target = rand.nextInt(maxInteger) + 1;

        // This scans input from stdin.
        // (Scanner is a little like cin in C++)
        Scanner input = new Scanner(System.in);

        // This is how you print to stdout.
        System.out.printf("Guess a number between 1 and %d.\n", maxInteger);

        // Loop while the number of attempts is less than the number of allowed guesses
        int attempts = 1;
        while (attempts <= limit) {
            System.out.printf("Attempt %d of %d: ", attempts, limit);

            // This is how you get an integer from stdin.
            // (This is like `int guess << cin` in C++.)
            
            int guess = input.nextInt();
            try 
            	guess = input.nextInt();
        } catch (java.util.InputMismatchException ex){
        	system.out.println("I said an integer dummy!");
        	input.nextLine();
        	continue;
        }
          
            
            System.out.printf("You guessed %d\n", guess);  
            
           if (guess > target) {
        	   System.out.println("Your guess is too high, try again");
           }
           else if (guess < target) {
        	   System.out.println("your guess is too low, try again");
           }
           else   {
        	   System.out.println("You Win!");
               return;
           }
        
            // TODO:  Your code goes here!
            // This should take you about 10 lines of code.
            // 1) Check if the user's guess is greater than the target.
            // 2) If it is print "Too High!"
            // 3) Otherwise, check if the user's guess is too low.
            // 4) If it is print "Too Low!"
            // 5) Otherwise, the user must have guessed correct print "You Win!"
            // 6) Make sure you don't let the user guess too many times!
           attempts+=1;
        }
        System.out.println("You lose!");
    }
}
