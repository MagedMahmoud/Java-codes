package edu.cuny.cisc3120.homework3;

public class Lion extends Mammal
{
	public int getSize() 
	{
		size = 5;
		//The one that attacks first gets advantage, since apparently a python can also eat a lion if caught by surprise and vice versa. 
		return this.size++;
	}    
    public void eat(Animal food)
    {
    	super.eat(food);	
    	if (this.size > food.getSize())
    		{
    			System.out.printf("The Lion dashes in and claws in to the %s.\n", food.getName());
        	} 
    		else if (this.size < food.getSize()) 
        	{      		
    			System.out.printf("the king has fallen to the %s.\n", food.getName());		
        	}	
    }
    public void speak()
    {
    	System.out.println("Simba remembers who he is");   	
    }
}


