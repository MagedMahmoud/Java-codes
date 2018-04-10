package com.ds;

public class NodeDouble {
//linked list double note has an extra pointer for previous
	Object value;
	NodeDouble next;
	NodeDouble previous;		
	
	public NodeDouble(Object value, NodeDouble next, NodeDouble previous) {
		this.value = value;
		this.next = next; 
		this.previous = previous;
	}

}