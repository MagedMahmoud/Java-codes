package edu.cuny.brooklyn.cisc3120.homework3.core;

public interface IClient {
    void win();
    void lose();
    void tooLow(int guess);
    void tooHigh(int guess);
}
