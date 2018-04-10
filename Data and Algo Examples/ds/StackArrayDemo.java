package com.ds;

public class StackArrayDemo {

	public static void main(String[] args) {
		//just the demonstration of how to actually use it
		StackArray<Integer> st= new StackArray <Integer> (5);
		st.push(10);
		st.push(4);
		st.push(2);
		st.push(23);
		st.push(154);
		st.push(12);		
		while (!st.isEmpty()) {
		System.out.println (st.pop());
		}
	}
}