package com.ds;

public class LinkedListDoubleDemo {
	//just the demonstration of how to actually use it
	public static void main(String[] args) {
		LinkedListDouble<String> ls = new LinkedListDouble<String>();
		ls.add ("Hussein");
		ls.add ("Mike");
		ls.add ("Jess");
		ls.add ("Ali");
		System.out.println("Before delete");
		ls.display ();
		ls.delete();
		System.out.println("After delete");
		ls.display();
	}
}