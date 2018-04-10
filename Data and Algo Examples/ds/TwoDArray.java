package com.ds;

public class TwoDArray {

public static void main(String[] args) {
	//just the demonstration of how to actually use it
	//think of x and y chart
	int [][] data = new int  [3] [3];
	data [0][0] = 1;
	data [0][1] = 2;		
	data [0][2] = 5;
	data [1][0] = 5;
	data [1][1] = 8;
	data [1][2] = 12;
	data [2][0] = 0;
	data [2][1] = 0;
	data [2][0] = 0;
	
	//for getting all elements diagonally set x and y to equal
	//for anything under the diagonal line set x to be smaller than y 
	//opposite for vice versa 
	for (int i = 0; i < 3 ; i++) {
		for (int j = 0; j <3 ; j ++ ) {
			if (data [i] == data [j])
			{
				System.out.print (data[i][j]);
			}
		}
		System.out.print("\n");
		}
	}
}