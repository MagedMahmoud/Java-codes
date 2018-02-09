package edu.cuny.brooklyn.cisc3120.homework3.cli;

import edu.cuny.brooklyn.cisc3120.homework3.core.*;

public class MainCLI {
    public static void main(String[] args) throws Exception {
        // TODO:  You can just hard code your config for this assignment.
        // Parsing commandline arguments is optional.
        Configuration myConfig = new Configuration(16, 4);

        // Resolve and inject dependencies.
        IClient myClient = new ClientCLI();

        // You can use a random guesser:
        // IGuesser myGuesser = new RandomGuesser(myConfig);

        // Or the command-line guesser.
        IGuesser myGuesser = new GuesserCLI(myConfig);

        IChooser myChooser = new RandomChooser(myConfig);

        Game myGame = new Game(myChooser, myGuesser, myClient, myConfig);
        myGame.play();
    }
}

