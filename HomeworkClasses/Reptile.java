package edu.cuny.cisc3120.homework3;

public abstract class Reptile extends Animal
{
	public Reptile()
	{
		super(2);	
	}
	public int getSize() 
	{
		return this.size;
	}
	public void eat(Animal food)
	{
		System.out.printf("Big reptiles prefer to sneak on their prey here we see a %s.\n", food.getName());
	}
}