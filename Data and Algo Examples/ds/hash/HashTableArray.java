package com.ds.hash;

public class HashTableArray <T> {
Entry [] arrayHash;
int size;

	public HashTableArray(int size) {
		//size for the new hash array
		this.size = size;
		arrayHash = new Entry [size];
		//init the entries for the hash
		for (int i = 0; i < size ; i++) 
			arrayHash[i] = new Entry ();
	}
	int GetHash (int Key) {
		//for placing the entry, we take their unique
		//Key value and put it through a hashing function
		//to give it an index value associated with it's 
		//unique key. 
		return Key%size;  
	}  
	public void put (int Key, Object value) {
		//Take the key and give back a hashIndex value
		int HashIndex = GetHash (Key);
		//put the entry in the array hash based on its index
		Entry ArrayValue = arrayHash [HashIndex];
		//define the entry
		Entry newItem = new Entry (Key, value);
		//much like a linked list, this is how we finally 
		//put the entry and pair it with the .next
		//pointer to create our chains
		newItem.next = ArrayValue.next;
		ArrayValue.next = newItem;
	}
	public T get (int Key) {
		//in case your key give back an empty
		T value = null;
		int HashIndex = GetHash (Key);
		//take address for first index
		Entry ArrayValue = arrayHash [HashIndex]; 
		//then just go thru the list to find your key
		while (ArrayValue != null) {
			//while the array is not empty
			//if the key is the same as key asked for
			if (ArrayValue.GetKey() == Key) {
				//the value is what you found
				value = (T) ArrayValue.GetValue();
				//stop looking
				break;
			}
			//set the pointer
			ArrayValue = ArrayValue.next;
		}
		return value;
	}
}

//*** some extra notes
//Big O for search, insert, access, and delete is N. since despite "array" you still need to go through your list 
//of index and the elements in it. While finding your index can be the same Big O of an array, going through your 
//list to do the rest is like a linked list hence the big O of n
//hashs are great as they some what pre-sort your data by ordering them by key. This make limits you from 
//from going through your entire structure to find something. So while it is a big O of n, it's still better than
// lists or arrays where you need to go through the ENTIRE structure 