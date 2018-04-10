package com.sort;

public class BubbleSorting {
static void BubbleSort (int [] arr) 
	{
	//init your element and store its size
	int n = arr.length;
	//have temp storage for the swap
	int temp = 0;
	//the usual loop
	for (int i = 0; i < n; i++)
		{
		//the loop and swap
		for (int j = 1; j <(n-i);j++)
			{
			//if the prev element is bigger
			if (arr[j-1] > arr [j]) 
				{
				//put the prev element in the temp storage
				temp = arr [j-1];
				//set the prev element to the smaller element
				arr [j-1] = arr [j];
				//set the element after to the temp that has the bigger value
				arr [j] = temp;
				}
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
		BubbleSort(arr);
		//use /n to give it a new line
		System.out.println("\nAfter sort");
		for (int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + "\t");
			}
	}	
}