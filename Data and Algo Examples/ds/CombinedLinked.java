package com.ds;

public class CombinedLinked {
	//take two lists
	// merge them so that the elements alternate between the first and the second 
	//and the second one is reversed 
	public static void main(String[] args) {
		//1- create two link lists and populate
		LinkedListU<Integer> ls1 = new LinkedListU<Integer>();
		LinkedListU<Integer> ls2 = new LinkedListU<Integer>();
		ls1.add (20);
		ls1.add (15);
		ls1.add (10);
		ls1.add (5);
		ls1.add (1);
		
		ls2.add (14);
		ls2.add (13);
		ls2.add (12);
		ls2.add (11);
		ls2.add (5);

		//new list where it all goes
		LinkedListU<Integer> ls3 = new LinkedListU<Integer>();
		
		//2- put the the second Link list on to a stack
		StackArray<Integer> st= new StackArray <Integer> (5);
		//3- for the size then repeat. 
		for (int i = 0; i < 5; i++)
		{
			st.push(ls2.head.value);
			//delete from list after you push the values
			ls2.delete();
		}		
		for (int i = 0; i < 5; i++)
		{
			ls3.add(ls1.head.value);
			//delete from list after you add values
			ls1.delete();
			ls3.add(st.pop());	
		}
		ls3.display();
	}	
}		