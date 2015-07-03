package com.vsked.test;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList0 {

	public static void main(String[] args) {
		List<Integer> l=new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		//System.out.println(l.size());
		System.out.println(l.get(0));
		l.remove(0);
		System.out.println(l.get(0));
		l.remove(0);
		System.out.println(l.get(0));
		l.remove(0);
		System.out.println(l.get(0));
		l.remove(0);
	}

}
