package com.ds;

public class StackLinkedList<T> {
	Node top;
	public StackLinkedList() {
		top = null;
	}
	public void push (Object value) 
	{
		//create an empty note with the value and pointer 
		Node newNode = new Node(value, null);
		//if there is no head, then this new node is the head
			if (top == null) 
				top = newNode;
			else { 
		//make new node refer to the prev head
				 newNode.next = top; 
		//make the new node as the new head
				 top = newNode;
			}
	}
	public T pop () {
		//simply move the pointer to the next one
		//check if the top is empty
		//change type to generic
		if (top == null) {
			System.out.println("stack is empty");
			return null;
		}
		//get the value and type cast it to make sure its generic
		T value = (T) top.value;
		top = top.next;
		return value;
	}
}

//**** some extra notes
//This is a Stack implemented using LinkedLists
//Stack is just like a Queue but its First in Last out
//For access it has a big O of n 
//For Search it has a big O of n
//For insert and Delete it has a big O of 1 
//access and search it all depends on the size so it takes n time
//insert and delete you add in just one step and delete in one step 