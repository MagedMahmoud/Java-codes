package com.graph;

import java.util.Stack;
//depths first search
public class DFSGraph {
int size;
adjList[] array;

public DFSGraph(int size) {
	//set up size and fill the list
	this.size = size;
	array = new adjList[this.size];
		for (int i = 0 ; i< size; i++) {
		array [i] = new adjList();
		array [i].head = null;
		}
	}

public void add (int src, int dest) {
	//integer at source and destination
	//add new at the dest, null
	//basic like linked list
	Node n = new Node (dest, null);
	n.next = array [src].head;
	array [src].head = n;
}

public void DFSExplore (int StartVertex) {
	//add already visisted nodes in this so you 
	//dont go there again
	Boolean [] visited = new Boolean [size];
	//init the array, any node visited then add false
	//since at start there is nothing
	for (int i = 0; i < size; i++) 
		visited [i] = false;
	Stack <Integer> st = new Stack <Integer> ();
	//setting up and filling the stack to keep track
	st.push (StartVertex);
	while (!st.isEmpty()) {
		//while not empty get n
		int n = st.pop ();
		//put element back in stack
		st.push(n);
		//found and visited set true
		visited [n] = true;
		//the head node is the top of the array
		//take child
		Node head = array[n].head;
		//is done means im done exploring all for this parent
		//so can remove from stack
		Boolean isDone = true;
		
		while (head != null) {
			if (visited [head.value] == false) {
				//if not visited put it to stack
				st.push(head.value);
				//visited head value is now marked
				visited [head.value] = true;
				//set done to false as there is child to visit 
				isDone = false;
				break;
				}else{
				head = head.next;
				}
			}
		//all visited
		if(isDone == true) {
			int out = st.pop();
			System.out.println("Visited node: " + out);
			}
		}
	}
	//add delete and search
}