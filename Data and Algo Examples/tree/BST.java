package com.tree;
//Binary Search Tree
public class BST {
//set up your root
Node root;
//binary search tree is one of the most important DS and Sorts. 
public BST() {
	//set your root to empty
	root = null;		
}
public Node NodeCreate (int value) {
	//a method to create new nodes
	return new Node (value, null, null);
}
public void Add (Node start, Node newNode) {
	//if you have no root, new node becomes the root
	if (root == null) {
		root =  newNode;
		return;
	}
	if (newNode.value > start.value) {
	//if right is empty put it in right, if the right
	//is still bigger keep on checking till the right
	//is empty then put it there. No brackets for the second if
	//not sure why?
	if (start.right == null) 
		start.right = newNode;
		Add (start.right, newNode); 
	}
	if (newNode.value < start.value) {
	//same process but reverse it for the left
	if (start.left == null) 
		start.left = newNode;
		Add (start.left, newNode);	
	}	
}
public void Search (int value, Node start) {
	//hit return to end the search, by either returning 
	//the null if not found or the value of node if found
	//if you go through it all till node is null, then its not in tree
	if (start == null) {
		System.out.println("Node can not be found");
		return;
	}
	//if your start node is same as value, you found it
	if (start.value == value ) {
		System.out.println("Node is found");
		return;
	}
	//go down right if bigger
	if ( value > start.value) {
		Search (value, start.right);
	}
	//go down left if smaller
	if ( value < start.value) {
		Search (value, start.left);
	}
}
// IMPLEMENT A DELETE METHOD!!
}