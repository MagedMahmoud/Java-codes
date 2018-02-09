package edu.cuny.brooklyn.cisc3120.homework3.core;

public class Game
{
    private IClient client;
    private IChooser chooser;
    private IGuesser guesser;
    private Configuration config;

    public Game(IChooser chooser, IGuesser guesser, IClient client, Configuration config)
    {
        this.config = config;
        this.client = client;
        this.guesser = guesser;
        this.chooser = chooser;
    }

    public void play()
    {
        for (int attempt = 0; attempt < this.config.getAllowedGuesses(); attempt++) {
            int guess = this.guesser.nextGuess();
            IChooser.ComparisonResult result = chooser.checkGuess(guess);
            if (result == IChooser.ComparisonResult.Correct) {
                client.win();
                return;
            } else if (result == IChooser.ComparisonResult.TooHigh) {
                client.tooHigh(guess);
            } else if (result == IChooser.ComparisonResult.TooLow) {
                client.tooLow(guess);
            }
        }
        client.lose();
    }
}

