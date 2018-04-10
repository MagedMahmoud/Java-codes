package com.ds;

public class QueueListDemo {

	public static void main(String[] args) {
		//just the demonstration of how to actually use it
		QueueLinkedList <String> q = new 
				QueueLinkedList<String> ();
		q.Queue("Bob");
		q.Queue("Jim");
		q.Queue("Barb");
		q.Queue("Mike");
		for (int i = 0; i < 5; i++) {
		System.out.println(q.Dequeue());
		}
	}
}