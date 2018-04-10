package com.ds;

public class OneDArray {

public static void main(String[] args) {
	//just the demonstration of how to actually use it
int[] numbers = new int [5] ;
	numbers [0] = 20;
	numbers [1] = 5;
	numbers [2] = 10;
	numbers [3] = 6;
	numbers [4] = 11;
	
	for (int i = 0 ; i < numbers.length; i++)
		System.out.println(numbers[i]);
	
	Student [] students = new Student [4];
	students [0] = new Student ("Maged"  , 24);
	students [1] = new Student ("Mike"  , 24);
	students [2] = new Student ("Ana"  , 24);
	students [3] = new Student ("Jasmine"  , 24);
	
	for (Student student: students) {
		System.out.println ("name: " + student.name + " age: " + student.age);
	}
	}
}
