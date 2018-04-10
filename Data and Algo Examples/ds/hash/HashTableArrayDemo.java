package com.ds.hash;

public class HashTableArrayDemo {

	public static void main(String[] args) {
		HashTableArray<String> hm= new HashTableArray<String> (10); 
		
		hm.put(11, "mike");
		hm.put(12, "Ali");
		hm.put(20, "joe");
		hm.put(100, "laya");
		hm.put(40, "tim");
		
		System.out.println(hm.get(11));
		System.out.println(hm.get(12));
		System.out.println(hm.get(20));
		System.out.println(hm.get(100));
		System.out.println(hm.get(40));
	}
}