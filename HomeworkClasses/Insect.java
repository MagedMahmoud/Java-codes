package edu.cuny.cisc3120.homework3;

public abstract class Insect extends Animal {
	public Insect()
    {
		// Insects are all very small!
        super(1);
    }
	public int getSize() 
	{
		return this.size;
	}
    public void eat(Animal food)
    {
    	//System.out.printf("Insects will eat anything, even a %s.\n", food.getName());
    }
    // All animals can speak.
    public void speak()
    {
    	System.out.println("BUZZZZZZZ!.......maybe?");
    	System.out.println("Insects will eat anything");
    }
}
