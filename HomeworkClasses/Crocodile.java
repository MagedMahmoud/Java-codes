package edu.cuny.cisc3120.homework3;

public class Crocodile extends Reptile
{
	public int getSize() 
	{
		size = 2;
		return this.size;
	}
    public void eat(Animal food)
    {
    	super.eat(food);
    	if (this.size > food.getSize())
    	{
    			System.out.printf("The Croc awaits under the swamp then snaps at the %s.\n", food.getName());
        	} 
    		else if (this.size < food.getSize())
    		{
    			System.out.printf("The Croc squirms back to the swamp away from the %s.\n", food.getName());		
        	}   	
    }
    public void speak()
    {
    	System.out.println("The crocodile just makes some bubbles in the swamp");
    }
}
