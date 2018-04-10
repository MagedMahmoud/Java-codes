package com.tree;

public class BTSDemo {
	//just the implementation.
	public static void main(String[] args) {
		BST bt = new BST ();
		bt.Add(bt.root, bt.NodeCreate(10));
		bt.Add(bt.root, bt.NodeCreate(12));
		bt.Add(bt.root, bt.NodeCreate(11));
		bt.Add(bt.root, bt.NodeCreate(13));
		bt.Add(bt.root, bt.NodeCreate(6));
		bt.Search(13, bt.root);
	}
}