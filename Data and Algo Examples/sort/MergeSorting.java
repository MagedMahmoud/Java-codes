package com.sort;

public class MergeSorting {
int[] array;
int[] TempArray;
	void PrepareForSort(int[] arr) {
		//get ready to sort
		//set your temp sort array to be same as length
		//of main array, so when merge happens the elements
		//fit
		this.array = arr;
		this.TempArray = new int[arr.length];
		doMergeSort (0, arr.length-1);
	}
	void doMergeSort (int LowerIndex, int HigherIndex) {
		//if the smaller number element is smaller
		//find middle, cut it in half, recursion of mergesort on each side
		if (LowerIndex < HigherIndex) {
			//take the middle
			int middle = LowerIndex + (HigherIndex - LowerIndex)/2;
			//call mergesort again (recursion) using the middle for
			//the higher index this time (1-5) i.e in array of 1 - 10
			doMergeSort(LowerIndex, middle); 
			//call it again using the number after the middle, this is
			//splitting the the array in 2 (6-10) i.e in an array of 1-10
			doMergeSort(middle +1, HigherIndex);
			//call merge part to bring it all together
			MergePart(LowerIndex, middle, HigherIndex);
		}
	}
	void MergePart(int LowerIndex, int middle, int HigherIndex) {
		//from the smallest index, so long as is equal than or smaller than
		//the largest, keep on doing
		for (int i = LowerIndex; i <= HigherIndex; i++)
			//move array in to the temp array
			TempArray [i] = array [i];
		int i = LowerIndex;
		int j = middle +1;
		int k = LowerIndex;
		//when i is smaller than or equal to middle
		//and j is smaller than or equal to higher
		while (i <= middle && j<= HigherIndex) {
			//if lower index element less than element after the middle
			if (TempArray[i] <= TempArray [j]) {
				//put it in the array at the lower index position
				array [k] = TempArray [i];
				//increment the lower index i
				i++;
			} else {
				//other wise
				//set the lower position as the value of the middle +1
				array [k] = TempArray [j];
				//increment the middle 
				j++;
			}
			//increment the lower index k
			k++;
		}
		//in case both sides less or equal 
		while (i<middle) {
			array [k] = TempArray [i];
			k++;
			i++;
		}
	}
	public static void main(String[] args) {
		int [] arr = {34,50,30,10,60,80};
		System.out.println("Before sort");
		for (int i = 0; i < arr.length ; i++) {
			//use a \t with print to make horizontal in display
			System.out.print(arr[i] + "\t");
			}
		new MergeSorting().PrepareForSort(arr);
		//use /n to give it a new line
		System.out.println("\nAfter sort");
		for (int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + "\t");
			}
	}
}