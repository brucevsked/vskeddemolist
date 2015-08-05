package com.vsked.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) {
//		testHashSet();
		testTreeSet();
	}

	public static void testHashSet() {
		HashSet h = new HashSet();
		h.add("1st");
		h.add("2nd");
		h.add(new Integer(3));
		h.add(new Double(4.0));
		h.add("2nd"); // 重复元素，未被添加
		h.add(new Integer(3)); // 重复元素，未被添加
		h.add(new Date());
		System.out.println("开始：size=" + h.size());
		Iterator it = h.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println(o);

		}
		h.remove("2nd");
		System.out.println("移除元素后：size=" + h.size());
		System.out.println(h);
	}

	public static void testTreeSet() {
		TreeSet ts = new TreeSet();
		ts.add("Aug 5");
		ts.add("Aug 6");
		ts.add("Aug 7");
		ts.add("Aug 8");
		Iterator it = ts.iterator();
		while (it.hasNext()) {
			String fruit = (String) it.next();
			System.out.println(fruit);
		}
		for(int i=ts.size();i>0;i--){
			Object x=ts.pollLast();
			System.out.println(x);
			ts.remove(x);
		}
	}

}
