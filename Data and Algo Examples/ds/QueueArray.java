package com.ds;

public class QueueArray <T> {
Object [] ArrayQueue;
int Rear;
int Front;
int size;
	//init 
	public QueueArray(int size) {
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
		if (isFull()) {
			//if the queue is full then you cannot add
			System.out.println("Queue is full");
			return;
		}
		//increase the rear per add to the queue
		//give the value of the new rear to the new item
		Rear = Rear +1;
		ArrayQueue [Rear] = newItem;
		if (Front == -1)
			//init the Front
			Front = 0;
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
//This is a queue implemented using arrays
//Queue is just like a stack but its first come first serve. 
//For access it has a big O of n 
//For Search it has a big O of n
//For insert and Delete it has a big O of 1 
//access and search it all depends on the size so it takes n time
//insert and delete you add in just one step and delete in one step 