package edu.cuny.brooklyn.cisc3120.homework3.core;

public final class Configuration {
    private int maxNumber;
    private int allowedGuesses;

    public Configuration(int maxNumber, int allowedGuesses) throws Exception
    {
        if (maxNumber <= 0) {
            throw new Exception("maxNumber must be above 0.");
        }
        if (allowedGuesses <= 0) {
            throw new Exception("allowedGuesses must be above 0.");
        }
        this.maxNumber = maxNumber;
        this.allowedGuesses = allowedGuesses;
    }

    public int getMaxNumber()
    {
        return this.maxNumber;
    }

    public int getAllowedGuesses()
    {
        return this.allowedGuesses;
    }
}
