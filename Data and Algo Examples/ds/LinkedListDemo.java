package com.ds;

public class LinkedListDemo {
	//just the demonstration of how to actually use it
	public static void main(String[] args) {
	LinkedListU<String> ls = new LinkedListU<String>();
	ls.add ("Hussein");
	ls.add ("Mike");
	ls.add ("Jess");
	ls.add ("Ali");
	System.out.println("Before delete");
	ls.delete();
	System.out.println("After delete");
	ls.display();
	}
}