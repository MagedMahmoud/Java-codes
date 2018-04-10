package com.ds.hash;

public class BestFRepeat {
//for repeating elements usually a hash works betters, as it can give keys
//to distinguish between the identical
	public static void main(String[] args) {
		HashTableArray<Integer> hm= new HashTableArray<Integer> (10);
		hm.put(1, 0);
		hm.put(2, 0);
		hm.put(3, 0);
		hm.put(4, 1);
		hm.put(5, 8);
		hm.put(6, 5);
		hm.put(7, 0);
		hm.put(8, 9);
		hm.put(9, 2);
		hm.put(10, 2);
	}
}