package com.ds;
import java.util.Arrays;

//<T> makes a generic so when it is called they can set the data type there
public class DynamicArray<T> {
//array of data object
Object [] data;
int size;
	
	public DynamicArray() {
	//set size to 1 which is 0
		size = 0;
	//the data is a new instance of OBject with a size of 1
		data = new Object [1];
	}   
	//just gives the size of the aray
	public int getSize() {
		return data.length;
	}
	//to get the specific  element from array
	public T get(int index) {
		//the T just casts the type must be done for the generics as it has not type
		//but that of T in here. 
		return (T) data [index];
	}
	//to add element
	public void put(Object element) {
		//make sure there's enough room to add new element 
		ensureCapacity(size+1);
		data[size++] = element; 
	}
	public void delete () {
		//almost the same as ensure capacity
		//get the size
		int oldCapacity = getSize ();
		//reduce old size by one.  
		int newCapacity = oldCapacity - 1;
		//set new array in to a new one with the new capacity.
		data = Arrays.copyOf (data, newCapacity); 
	}
	public void ensureCapacity (int minCapacity) {
		//get the size first
		int oldCapacity = getSize();
		//if the the minimum is bigger than the old 
		if (minCapacity > oldCapacity) {
			//then increase the size of the new capacity 
			int newCapacity = oldCapacity + 1; 
			//if the new capacity is smaller than minimum capacity
			if (newCapacity<minCapacity) 
				//then the new quals the min
				newCapacity = minCapacity;
			//copy the data of the old array in to a new data array with the size of the new capacity
			data = Arrays.copyOf (data, newCapacity); 
		}
	}
}

//**** some extra notes
//For access it has a big O of 1 like all arrays
//For Search it has a big O of n
//For insert and Delete it has a big O of n
//Access of 1 since you can just enter the index
//search insert and delete is n since you need to loop through it all for those operations
//Arrays are better for Access and searching as it simply can access the index
//lists are better for size memory and for delete and insert as no shifting is needed