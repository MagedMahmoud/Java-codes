package homework1;

import java.util.Random;
import java.util.Scanner;
import org.w3c.dom.ranges.RangeException;
import java.io.*;

public class GuessingGame {
    // Extra Credit!
    // For every positive integer `n` that you pick for `maxInteger` there is
    // a positive integer `m` that you can pick for limit, such that the user
    // will always guess the number if they use the right strategy.
    // What is the smallest integer `m`, given as a function of `n`, with this property?
	// upper ceiling [log base 2 n] + 1 
	static final int limit = 4;
    static final int maxInteger = 16;
 
	public static void main(String[] args) {
	    char tryAgain = ' ' ;
	    Scanner second = new Scanner(System.in);
	    System.out.println("Do you REALLY want to play this? y/n");
        tryAgain = second.next().charAt(0);	  
	    while (tryAgain != 'y' && tryAgain != 'n') {
	        System.out.println("Please use 'y' for yes or 'n' for no.");
	        System.out.println("Play again?..... (y/n)");    
	    }
	    if (tryAgain == 'n') {
	        System.out.println("i honestly do not care!");	       
	     
	    }
	     else if  (tryAgain== 'y') {
	    	System.out.println("like are you sure you want to put me throught this.... (y/n)");
	    	  tryAgain = second.next().charAt(0);
	    	   if (tryAgain == 'n') {
	    		   System.out.println("Great you can go netflix and i can go to ponder my existence or something");
	    		   
	    	   }
	    	   else if (tryAgain=='y') {
	    		   System.out.println("Let's just get this over with!");
	
		int guesses [] = new int [limit];
		
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
     
           int guess = 0;
            
            try {
            	guess = input.nextInt();   	
          } catch (java.util.InputMismatchException ex){
        	System.out.println("I said an integer dummy!");
        	input.nextLine();
        	continue;
            }
          if (guess > maxInteger) {
            System.out.println("on a scale of 1 to 10 your intelligence is null (too high!)");
            attempts++; 
            continue;
            }
          else if (guess < 1) {
        	  System.out.println("Google what a number line looks like (too low!)");
        	  attempts++;
        	  continue;
          }
          
        int[] guesse = new int[3];
  		for ( int i = 0; i <  guesse.length; i++) {
  		       guesse[i] = guess;   
  		}
  		 System.out.println(guesse);
  		 
  		 
          
            System.out.printf("You guessed %d\n", guess);  
         
           if (guess > target) {
        	   System.out.println("Your guess is too high, ughhh just stop");
           }
           else if (guess < target) {
        	   System.out.println("your guess is too low, why do you even try?");
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
        System.out.println("You lose, Go ahead and delete system 32 to start again!");
       
    }	

  /* private static <guesses> boolean checkGuesses (int guess, Class<guesses[]> class1) {  	
	 	int[] guesses;
		for ( int i = 0; i <  guesses.length; i++) {
		if (guesses[i] == guess);      
		return false;
		}   	
   if (!checkGuesses (guess, guesses[].class)) {
	   int attempts;
	guesses[attempts-1] = guess;    
   } else {
	   System.out.println("You already picked this number!!");
	   continue; 
   }
  }*/
	    	  }
	}
}
	    
	
