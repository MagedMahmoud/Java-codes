package com.search;

public class LinearSearch {

	public static void main(String[] args) {
		DataSet data = new DataSet (100000);
			int Search = 100000;
			Boolean IsFound = false;
			for (int i = 0; i < data.getSize(); i++ ) {
				data.NumberTry ++;
				if (data.data[i] == Search) {
					System.out.println ("Number of attempts: "+ data.NumberTry);
					IsFound = true;
					break;
				} 
			}
		if (IsFound == false) {
		System.out.println ("Number cannot be found");	
		} 
	}
}
