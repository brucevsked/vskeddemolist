package com.vsked.test;

import java.util.HashMap;
import java.util.Map;

public class TestSet {

	public static void main(String[] args) {
		Map tm=new HashMap();
		tm.put("x", 1);
		tm.put("y", 2);
		System.out.println(tm.containsValue(3));
	}

}
