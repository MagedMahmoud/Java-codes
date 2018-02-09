package edu.cuny.cisc3120.homework3;

public class Honeybadger extends Mammal
{	
	public int getSize()
	{
		size = 99;
		return this.size;
	}	
    public void eat(Animal food)
    {
    	super.eat(food);
    	if (this.size > food.getSize())
    		{
    			System.out.printf("The honey badger jumps and goes to flavor town on the %s.\n", food.getName());
        	}
    		else 
        	{
    			System.out.printf("honeybadger can not fight another %s in arms.", food.getName());		
        	} 	
    }
    public void speak()
    {   	 	
    	System.out.println("The Honeybadger ponders upon it's greatness");
    }
}