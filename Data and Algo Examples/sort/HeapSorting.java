package com.sort;

public class HeapSorting {
static int total;
//take array and sort till you get last element out of array
//swappping method
static void  swap (Comparable[] arr, int a, int b) {
	//same as any swap method in other sorts
	//set what you wanna swap to a temp
	//change values of a and b 
	//then set what ever was in the temp back to what was not changed
	Comparable temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
}
//use compbarable array so its easier to compare the elements inside 
//(refer to sorting array of objects for comparable use)
static void heapify (Comparable [] arr, int i) {
	//left node which is the 2k
	int lft = i*2;
	//right node which is the 2K+1
	int rgt = i*2+1;
	//if no change 
	int grt = i;
	//if left or right is bigger than total AND left or right child
	//of array after comparison to parent returns bigger than 0
	//change the parent to left or right accordingly 
	//for reverse set the right side to == -1 as this will take 
	if ( lft <= total && arr[lft].compareTo(arr[grt]) >= 0 ) {
		grt = lft;
	}
	if ( rgt <= total && arr[rgt].compareTo(arr[grt]) >= 0 ) {
		grt = rgt;
	}
	//if there is change to the grt, swap and call heapify again
	if (grt != i) {
		swap (arr, i , grt);
		heapify(arr, grt); 
	}
}
static void sort (Comparable[] arr) {
	//since the last element gets bascially thrown out
	//we shorten the total length
	total = arr.length - 1;
	for (int i = total/2; i >= 0; i --) {
		//take from the middle and heapify it first
		heapify (arr, i);
	}
	for (int i = total; i>0 ; i--) {
		//swap with elements first as it is now largest with i
		swap (arr, 0, i);
		//decrease total
		total --;
		//call heap from the top again
		heapify (arr, 0);
	}
}
public static void main(String[] args) {
	//as we are using type comparable we must use INTEGER not just int.
	Integer [] arr = {1,5,3,1,6,8,10};
	System.out.println("Before sort");
	for (int i = 0; i < arr.length ; i++) {
		//use a \t with print to make horizontal in display
		System.out.print(arr[i] + "\t");
		}
	sort(arr);
	//use /n to give it a new line
	System.out.println("\nAfter sort");
	for (int i = 0; i < arr.length ; i++) {
		System.out.print(arr[i] + "\t");
		}
	}
}