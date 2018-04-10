package com.ds;

public class QueueDArrayDemo {

	public static void main(String[] args) {
		//just the demonstration of how to actually use it
		QueueDArray<Integer> q = new QueueDArray <Integer>(1);
		q.Queue(5);
		q.Queue(2);
		System.out.println("Queue size: "+ q.getSize());
		q.Queue(4);
		q.Queue(43);
		q.Queue(23);
		System.out.println("Queue size: "+ q.getSize());
		q.Queue(231);
		System.out.println("Dequeue: " + q.Dequeue());
		System.out.println("Dequeue: " + q.Dequeue());	
	}
}