package com.search;

public class InterpolSearch {
	//interlop is just like binary but different algorithim condition
	//this is best for dictionary
		public static void main(String[] args) {
			DataSet data = new DataSet (99999);
			int Search = 34534;
			Boolean IsFound = false;
			int low = 0;
			int high = data.getSize() - 1;
			int mid = 0;
			
			while (!IsFound) {
				//if lowest ends up higher, it means went through whole 
				//data and found nothing
				if(low>high) {
					System.out.println("number is not found");
					break;
				}
				//the mid finding algo
				mid = low + ((high-low)
						/(data.data[high]-data.data[low])
						*(Search-data.data[low]));
				//increm number of attempts
				data.NumberTry ++;
				//if found 
				if (data.data[mid] == Search) {
					System.out.println ("Number of attempts: "+ data.NumberTry);
					break;
				}
				//if not found and the mid is smaller than what i wanted
				//move up the low to where the mid is and +1
			if (data.data[mid] < Search)
				low = mid + 1;
				//if not found and the mid is higher than what i wanted
				//move up the high to the mid is and -1
			if (data.data[mid] > Search)
				high = mid - 1;
			}
		}
}