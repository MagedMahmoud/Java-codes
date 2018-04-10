package com.ds;

import java.util.Arrays;

public class StackDArray <T> {
	//almost identical to the stack array with one exception
	//there is no isFull function it is replaced by the encusre
	//capacity as this stack can grow depending on the needs
	Object [] ArrayStack;
	int size;
	int  top;
		public StackDArray(int size) {
			//init the size and the top is -1 as there is no top 
			//in the beginning 
			this.size = size;
			ArrayStack = new Object[this.size];
			top = -1;
		}
		public void push (Object newItem) {
			//add 2 as we start from -1
			ensureCapacity (top + 2);
			//if not increase the top by 1 and add the
			//new item to the top
			top = top +1;
			ArrayStack [top] = newItem;
		}
		public void ensureCapacity (int minCapacity) {
			//get the size first
			int oldCapacity = getSize();
			//if the the minimum is bigger than the old 
			if (minCapacity > oldCapacity) {
				//then increase the size of the new capacity 
				int newCapacity = oldCapacity + 1; 
				//if the new capacity is smaller than minimum capacity
				if (newCapacity<minCapacity) 
					//then the new quals the min
					newCapacity = minCapacity;
				//copy the data of the old array in to a new data array with the size of the new capacity
				ArrayStack = Arrays.copyOf (ArrayStack, newCapacity); 
			}
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
		public Boolean isEmpty() {
			//if the top is still at -1, return true
			return (top == -1);
		}
		public int getSize() {
			return ArrayStack.length;
		}
}

//**** some extra notes
//This is a queue implemented using Dynamic Arrays, it's basically the same you just add the ensure capacity method 
//and modify some small things
//Stack is just like a Queue but its First in Last out
//For access it has a big O of n 
//For Search it has a big O of n
//For insert and Delete it has a big O of 1 
//access and search it all depends on the size so it takes n time
//insert and delete you add in just one step and delete in one step 