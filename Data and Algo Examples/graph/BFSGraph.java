package com.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//breadth first search
public class BFSGraph {
	int size;
	adjList[] array;

	public BFSGraph(int size) {
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

	public void BFSExplore (int StartVertex) {
		//add already visisted nodes in this so you 
		//dont go there again
		Boolean [] visited = new Boolean [size];
		//init the array, any node visited then add false
		//since at start there is nothing
		for (int i = 0; i < size; i++) 
			visited [i] = false;
		Queue <Integer> q = new LinkedList <Integer> ();
		//setting up and filling the stack to keep track
		q.add (StartVertex);
		while (!q.isEmpty()) {
			//while not empty get n
			int n = q.poll ();	
			System.out.println("Visited node: " + n);
			//found and visited set true
			visited [n] = true;
			//the head node is the top of the array
			//take child
			Node head = array[n].head;
			//while head not null
			while (head != null) {
				if (visited [head.value] == false) {
					//if not visited put it to stack
					q.add(head.value);
					//visited head value is now marked
					visited [head.value] = true;		
					}else{
					head = head.next;
					}
				}
			}
		}
		//add delete and search
}