package com.ds;

public class LinkedListU <T> {
Node head;
	public LinkedListU() {
		head = null;
	}
	public void add (Object value) 
	{
		//create an empty note with the value and pointer 
		Node newNode = new Node(value, null);
		//if there is no head, then this new node is the head
			if (head == null) 
				head = newNode;
			else { 
		//make new node refer to the prev head
				 newNode.next = head; 
		//make the new node as the new head
				 head = newNode;
			}
	}
	public void delete () {
		//simply move the pointer to the next one
		head = head.next;
	}
	public void display() {
		//call the head value to start
		Node n = head;
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