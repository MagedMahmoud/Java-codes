 package com.sort;

public class QuickSorting {
	//define low and high points
	static void QuickSort (int [] arr, int low, int high) {
		//if your high is less than your low, it means you reached the end
		if (low > high) return;
		//find the mid
		int mid = low + (high - low)/2;
		//set your pivot to the middle
		int pivot = arr [mid];
		int i = low;
		int j = high;
		while (i <= j) {
			//continue from low if nothing is bigger than pivot.
			while (arr[i] < pivot)
				i++;
			//continue from high if nothing is smaller than pivot. 
			while (arr [j] > pivot)
				j--;
			//make the swap if i is indeed smaller than j
			if (i <= j) {
				int temp = arr[i];
				arr [i] = arr[j];
				arr [j] = temp;
				//move up one from each side as they have been swapped. 
				i++; 
				j--;
			}
		}
		//implement recursion 
		//when low is less than j which is the high
		//make sure low goes in for the low and j goes in for the high
		if (low < j) 
			QuickSort (arr, low, j);
		//when the high is bigger than i which is the low
		//make sure again the low is i and high is the high index
		if (high > i)
			QuickSort (arr, i, high);
	}
	
	public static void main(String[] args) {
		int [] arr = {1,4,6,3,2,5,8};
		System.out.println("Before sort");
		for (int i = 0; i < arr.length ; i++) {
			//use a \t with print to make horizontal in display
			System.out.print(arr[i] + "\t");
			}
		QuickSort(arr, 0, arr.length - 1);
		//use /n to give it a new line
		System.out.println("\nAfter sort");
		for (int i = 0; i < arr.length ; i++) {
		System.out.print(arr[i] + "\t");	
	}
}
}