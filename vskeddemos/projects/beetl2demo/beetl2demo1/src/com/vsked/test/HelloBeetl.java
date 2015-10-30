package com.vsked.test;

import java.io.IOException;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

public class HelloBeetl {

	public static void main(String[] args) throws IOException {
		StringTemplateResourceLoader strl=new StringTemplateResourceLoader();
		Configuration cfg=Configuration.defaultConfiguration();
		String inputStr="Hello ${myName}";
		GroupTemplate gt=new GroupTemplate(strl,cfg);
		Template t=gt.getTemplate(inputStr);
		t.binding("myName", "Lost World vsked is here");
		String outStr=t.render();
		System.out.println(outStr);

	}

}
