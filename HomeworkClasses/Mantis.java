package edu.cuny.cisc3120.homework3;

public class Mantis extends Insect {
	public int getSize()
	{
		size = 90;
		return this.size;
	}
    public void eat(Animal food)
    {
    	super.eat(food);
    	if (this.size > food.getSize())
    		{
    			System.out.printf("The mantis leaps and destroys the %s.\n", food.getName());
        	}
    		else if (this.size< food.getSize())
        	{
    			System.out.printf("After a 6 months battle the mantis falls to the %s.\n", food.getName());		
        	}
    		else
    		{
    			System.out.println("After the praying mantis mates, it feeds on the male mantis");
    		}
    	
    		}
    		
    }

