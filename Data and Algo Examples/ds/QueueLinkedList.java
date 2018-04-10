package com.ds;

public class QueueLinkedList <T> {
	NodeDouble Rear;
	NodeDouble Front;
	public QueueLinkedList() {
		//init the nodes to null 
		Rear = null;
		Front = null;
	}
	public void Queue (Object value) 
	{
		//create an empty note with the value and pointer 
		NodeDouble newNode = new NodeDouble(value, null, null);
		//if there is no head, then this new node is the head
		//and the front is a new node as well
		if (Rear == null) {
				Rear= newNode;
				Front = newNode;
		} else {
			//since new nodes have nothing after them
			newNode.next = null;
			//new nodes most refer to the previous to chain
			newNode.previous = Rear;
			//set the old to the new one. to the link the new and old
			Rear.next = newNode;
			//set rear pointer to the new formed node. 
			Rear = newNode;
		}	
	}
	public T Dequeue () {
		if (Rear == null || Front == null) {
			//if the queue is empty check
			System.out.println("Queue is empty");
			return null;
		}
		//take value
		T value = (T) Front.value;
		//move the front pointer to the next one;
		Front = Front.next;
		//set the previous pointer to null so no more
		//pointing to where this node is
		//must check if front is null first before deleting
		//other wise the last node will always throw a null pointer
		//as all fronts are now deleted. 
		if (Front != null) 
		Front.previous = null;
		return value;
	}	
}

//**** some extra notes
//This is a queue implemented using Linked lists
//Queue is just like a stack but its first come first serve. 
//For access it has a big O of n 
//For Search it has a big O of n
//For insert and Delete it has a big O of 1 
//access and search it all depends on the size so it takes n time
//insert and delete you add in just one step and delete in one step 