package com.ds;

public class StackDArryDemo {

	public static void main(String[] args) {
		//just the demonstration of how to actually use it
		StackDArray<Integer> st= new StackDArray <Integer> (2);
		st.push(10);
		st.push(4);
		st.push(2);
		System.out.println("Stack Size: " + st.getSize());
		st.push(23);
		st.push(154);
		System.out.println("Stack Size: " + st.getSize());
		st.push(12);	
		while (!st.isEmpty()) {
		System.out.println (st.pop());
		}
	}
}