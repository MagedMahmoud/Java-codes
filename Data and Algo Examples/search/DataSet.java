package com.search;

public class DataSet {
int[] data;
int NumberTry;
	public DataSet(int size) 
	{  //takes size given we make data for it
		//loop and fill it up
		data = new int[size];
		for (int i = 1; i <= size; i++) 
			{
				data [i - 1] = i;
				NumberTry = 0;
			}
	}
	public int getSize () {
		return data.length;
	}
}