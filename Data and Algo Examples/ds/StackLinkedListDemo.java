package com.ds;

public class StackLinkedListDemo {

	public static void main(String[] args) {
		//just the demonstration of how to actually use it
		StackLinkedList <String> st=
				new StackLinkedList <String> ();
		st.push("Mike");
		st.push("Jess");
		st.push("Timmy");
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}