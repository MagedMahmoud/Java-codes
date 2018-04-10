package com.tree;
//simple node class
//init the value and the left and right pointers
public class Node {
int value;
Node left;
Node right;
	public Node(int value, Node left, Node right) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
}