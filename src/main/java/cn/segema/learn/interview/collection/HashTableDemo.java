package cn.segema.learn.interview.collection;

import java.util.Hashtable;

public class HashTableDemo {
	public static void main(String[] args) {
		Hashtable hashtable =new Hashtable();
		hashtable.put("key1", "value1");
		int hash = "key1".hashCode();
		System.out.println(hash);
	}
}
