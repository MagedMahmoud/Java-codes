package com.ds;

public class LinkedListDouble <T> {
	NodeDouble head;
	public LinkedListDouble() {
		head = null;
	}
	public void add (Object value) 
	{
		//create an empty note with the value and pointer 
		NodeDouble newNode = new NodeDouble(value, null, null);
		//if there is no head, then this new node is the head
		if (head == null) 
			head = newNode;
		else {
			//set the pointer of new node to the head
			newNode.next = head;
			//set the head of the old node, to the point to the new head
			head.previous = newNode;
			head = newNode;
		}
	}
	public void delete () {
		//simply move the pointer to the next one
		head = head.next;
		//the previous should be null\as there is no longer info there
		head.previous = null;
	}
	public void display() {
		//call the head value to start
		NodeDouble n = head;
		//when the head is not null keep on going
		while (n!=null ) {
			//type cast so you can print whatever the value type is
			System.out.println((T)n.value);
			n = n.next; 
		}
	}
}

//**** some extra notes
//For access it has a big O of n 
//For Search it has a big O of n
//For insert and Delete it has a big O of n
//Linked lists have a big O of n since you usually need to to iterate through the list
//you can not access it mid way with an index as you do with an array.
//Arrays are better for Access and searching as it simply can access the index
//lists are better for size memory and for delete and insert as no shifting is needed
//same as linked list but with an extra pointer, this can be easily turned in to 
//a circular list by sitting the last previous pointer to the front of the first element 