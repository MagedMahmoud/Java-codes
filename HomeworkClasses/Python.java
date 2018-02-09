package edu.cuny.cisc3120.homework3;

public class Python extends Reptile
{
	public int getSize()
	{
		size = 5;
		return this.size++;
	}
    public void eat(Animal food)
    {
    	super.eat(food);
    	if (this.size > food.getSize())
    		{
    			System.out.printf("The python ambushes his prey then tangles and swallows the %s.\n", food.getName());
        	} 
    		else if (this.size < food.getSize())
        	{
        		System.out.printf("The python leaps at his prey but is now snake jerky for the %s.\n", food.getName());		
        	} 	
    }
    public void speak()
    {
    	System.out.println("ssssssssssssssssspectacular");
    }   
}
