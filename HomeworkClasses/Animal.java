package edu.cuny.cisc3120.homework3;

public abstract class Animal {
    protected int size;
	public Animal(int size)
    {
        this.size = size;
    }
	public int getSize() {	
		return size;
	}
    // All animals eat.
    abstract public void eat(Animal food); 
    {   
    }
    // All animals can speak.
    abstract public void speak();    
	// TODO Auto-generated method stub
	// I implemented this for you.  It returns the name of the class without the package.
    public String getName()
    {
        // This implementation gives us the name of the class.
        // This gets us a "Class" object which describes the class of "this".
        java.lang.Class cls = this.getClass();
        // This gets us the class name of "this".
        String className = cls.getName();
        // The class name has the package in it, so for example it is:
        // edu.cuny/cisc3120.homework2.model.Iguana
        //
        // This code "splits" the string on the "." character into an array containing the segments that were separated by the "."
        String[] segments = className.split("\\.");
        // Take the last segment, which is the name of this class.
        String name = segments[segments.length - 1];
        // Convert to lower case.
        name = name.toLowerCase();
        return name;
    }    
}
 
