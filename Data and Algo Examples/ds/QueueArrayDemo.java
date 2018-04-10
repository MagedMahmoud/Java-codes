package com.ds;

public class QueueArrayDemo {

	public static void main (String []args) {
		//just the demonstration of how to actually use it
		QueueArray<Integer> q = new QueueArray <Integer>(5);
		q.Queue(5);
		q.Queue(2);
		q.Queue(4);
		q.Queue(43);
		q.Queue(23);
		System.out.println("Dequeue: " + q.Dequeue());
		System.out.println("Dequeue: " + q.Dequeue());
	}
}