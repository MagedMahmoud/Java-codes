package com.sort;

public class SelectionSorting {
static void SelectionSort (int [] arr) {
	for (int i = 0; i < arr.length - 1; i++) {
		//run through set index to i to know the indexes
		int index = i;
		//run through again while replacing
		//you run with comparing to the next one
		for (int j = i + 1; j <arr.length; j++) {
			//if the is less than the index looked at
			//whenever you find a smaller, replace. 
			if(arr [j] < arr [index])
				index = j;
		}
		//if a change happened to index init value
		//then you swap it
		//this is done AFTER the loop finishes, as this will
		//give the latest and smallest value in the array
		if (index != i) {
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}		
	}
}
	public static void main(String[] args) {
		int [] arr = {34,50,30,10,60,80};
		System.out.println("Before sort");
		for (int i = 0; i < arr.length ; i++) {
			//use a \t with print to make horizontal in display
			System.out.print(arr[i] + "\t");
			}
		SelectionSort(arr);
		//use /n to give it a new line
		System.out.println("\nAfter sort");
		for (int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + "\t");
			}
	}
}