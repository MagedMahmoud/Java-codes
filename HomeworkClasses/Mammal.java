package edu.cuny.cisc3120.homework3;

abstract class Mammal extends Animal 
{
	public Mammal()
	{	
		super(3);
	}
	public int getSize() 
	{
		return this.size;
	}
	public void eat(Animal food)
	{
		System.out.printf("A cornivore mammal will eat most animals that it can hunt, for example a %s.\n", food.getName());
	}
}
