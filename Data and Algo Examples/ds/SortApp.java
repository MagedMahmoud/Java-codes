package com.ds;
import java.util.ArrayList;
import java.util.Collections;

//make the person class
//then make it implement comparable 
//which is what is used for strings, integers, etc other 
//classes already done for us in java
//just modify it to fit the class
class Person implements Comparable <Person> {
	String name;
	int age;
	public Person (String name, int age) {
		this.age = age;
		this.name = name;
	}
	//override as its already written
	@Override
	public int compareTo(Person arg0) {
		//asc order
		//return this.age-arg0.age;
		//dec order
		return arg0.age-this.age;
		//return + when second item is smaller
		//return - when second item is bigger
		//return 0 when two items equal
		//depending on the order you want pick one of the three
	}
}

public class SortApp {

	public static void main(String[] args) {
		ArrayList<Person> listOfNames = new ArrayList<>();
		listOfNames.add(new Person("Jess", 25));
		listOfNames.add(new Person("Mike", 24));
		listOfNames.add(new Person("Jordan", 12));
		listOfNames.add(new Person("Sarah", 14));
		
		System.out.println("Print before sort");
		print (listOfNames);	
		
		Collections.sort(listOfNames);
		
		System.out.println("After before sort");
		print (listOfNames);
		 
		}
			   	
		static void print (ArrayList<Person> listOfNames) {
			for (Person person:listOfNames) {
				System.out.println ("Name: " + person.name);
				System.out.println ("Age: " + person.age);			
				}
			}
}

//////**** THIS IS VERY IMPORTANT FOR JOB INTERVIEWS AND OVER ALL PROGRAMMING ****//////
//Sorting an array of objects is also pretty great for OOP as you tend to have functions that 
//pump out objects with multiple data parameters and you can use this to just make your sorting life easier