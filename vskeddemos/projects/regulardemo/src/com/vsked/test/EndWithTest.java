package com.vsked.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EndWithTest {

	public static void main(String[] args) {
//		test1a();
		test1();
		test2();
	}
	
	public static void test1a(){
		String s="abcc123";
		boolean f=s.endsWith("123f");
		System.out.println(f);
	}
	
	public static void test1() {
		Pattern pattern = Pattern.compile("\\.(jpg|png|gif)$", Pattern.CASE_INSENSITIVE);
		String fileName = "agifpngjpgb.GIF";

		long begin = System.currentTimeMillis();
		for (int i = 1000000; i > 0; i--) {
			Matcher matcher = pattern.matcher(fileName);
			matcher.find();
		}
		long end = System.currentTimeMillis();
		System.out.println("regexp: " + (end - begin));
	}

	public static void test2() {
		String[] suffixs = { "jpg", "png", "gif" };
		String fileName = "agifpngjpgb.GIF";
		String temp = null;

		long begin = System.currentTimeMillis();
		for (int i = 1000000; i > 0; i--) {
			temp = fileName.toLowerCase();
			check1(suffixs, temp);
		}
		long end = System.currentTimeMillis();
		System.out.println("endwith: " + (end - begin));
	}

	private static boolean check1(String[] suffixs, String fileName) {
		for (String suffix : suffixs) {
			if (fileName.endsWith(suffix)) {
				return true;
			}
		}
		return false;
	}

}
