package com.ds;

import java.util.Arrays;

public class QueueDArray <T> {
	Object [] ArrayQueue;
	int Rear;
	int Front;
	int size;
		//init 
		public QueueDArray(int size) {
			this.size = size;
			ArrayQueue = new Object [this.size];
			//just like the stack when we give a -1 value
			//we also do this for a rear pointer
			//the rear pointer is basically who is next up
			Front = -1;
			Rear = -1;
		}
		public Boolean isFull () {
			//if rear is empty ( -1 ) then the queue is full 
			return (Rear == size -1);
		}
		public Boolean isEmpty () {
			//if the front is empty ( -1 ) or the rear is bigger 
			//since when rear is bigger it means there is no more fronts
			return (Front == -1 || Front > Rear);
		}
		public void Queue (Object newItem) {
			//same as the stack DArray, we use a +2 as we start
			//with -1 
			ensureCapacity(Rear + 2);
			//increase the rear per add to the queue
			//give the value of the new rear to the new item
			Rear = Rear +1;
			ArrayQueue [Rear] = newItem;
			if (Front == -1)
				//init the Front
				Front = 0;
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
				ArrayQueue = Arrays.copyOf (ArrayQueue, newCapacity);
			}
		
		}
		public int getSize () {
			return ArrayQueue.length;
		}
		public T Dequeue () {
			if (isEmpty()) {
				//if the queue is empty nothing to put out
				System.out.println("Queue is empty");
				return null;
			}
			//using generic, put the front out
			T ObjectOut = (T) ArrayQueue [Front];
			//increase the front to move on to the next
			Front = Front + 1;
			return ObjectOut;
		}
}

//**** some extra notes
//This is a queue implemented using Dynamic Arrays, it's basically the same you just add the ensure capacity method 
//and modify some small things
//Queue is just like a stack but its first come first serve. 
//For access it has a big O of n 
//For Search it has a big O of n
//For insert and Delete it has a big O of 1 
//access and search it all depends on the size so it takes n time
//insert and delete you add in just one step and delete in one step 