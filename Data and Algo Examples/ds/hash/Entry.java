package com.ds.hash;

public class Entry {
int Key;
Object value;
Entry next;

	public Entry(int key, Object value)
	{
		//init the key for index, value inside, next for pointer 
		//to the next index
		this.Key = key;
		this.value = value;
		next = null;
	}
	public Entry () 
	{
		//Init making sure all the values in the array hash
		//are set to null
		next = null;
	}
	public int GetKey () {
		//fetch the key
		return Key;
	}
	public Object GetValue () {
		//fetch the value
		return value;
	}
}