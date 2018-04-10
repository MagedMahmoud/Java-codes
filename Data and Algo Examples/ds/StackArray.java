package com.ds;

public class StackArray <T> {
Object [] ArrayStack;
int size;
int  top;
	public StackArray(int size) {
		//init the size and the top is -1 as there is no top 
		//in the beginning 
		this.size = size;
		ArrayStack = new Object[this.size];
		top = -1;
	}
	public void push (Object newItem) {
		//check if stack is full 
		if (isFull()) {
			System.out.println("stack is full");
			return;
		}
		//if not increase the top by 1 and add the
		//new item to the top
		top = top +1;
		ArrayStack [top] = newItem;
	}
	public T pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return null;
		}
		//take last element from the top
		T item = (T) ArrayStack[top];
		//reduece top by 1
		top = top -1;
		return item;
	}
	public Boolean isFull () {
		//if the the stack is full return true
		//if top equals the size
		return (top == size -1);
	}
	public Boolean isEmpty() {
		//if the top is still at -1, return true
		return (top == -1);
	}
}

//**** some extra notes
//This is a Stack implemented using arrays
//Stack is just like a Queue but its First in Last out
//For access it has a big O of n 
//For Search it has a big O of n
//For insert and Delete it has a big O of 1 
//access and search it all depends on the size so it takes n time
//insert and delete you add in just one step and delete in one step 