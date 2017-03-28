package com.vsked.test;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

public class Test1 {

	public static void main(String[] args) throws Exception {
		String words = "首都";  
        String pinyin = null;  
        final String separator = " ";  
          
        pinyin = PinyinHelper.convertToPinyinString(words, separator, PinyinFormat.WITHOUT_TONE);  
        System.out.println(pinyin);

	}

}
