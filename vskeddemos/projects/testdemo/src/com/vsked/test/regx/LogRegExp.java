package com.vsked.test.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRegExp {

	  public static void main(String argv[]) {
		  int NUM_FIELDS = 9;
	    String logEntryLine = "123.45.67.89 - - [27/Oct/2000:09:27:09 -0400] \"GET /java/javaResources.html HTTP/1.0\" 200 10450 \"-\" \"Mozilla/4.6 [en] (X11; U; OpenBSD 2.8 i386; Nav)\"";

	    String logEntryPattern = "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+) \"([^\"]+)\" \"([^\"]+)\"";

	    System.out.println("Using RE Pattern:");
	    System.out.println(logEntryPattern);

	    System.out.println("Input line is:");
	    System.out.println(logEntryLine);

	    Pattern p = Pattern.compile(logEntryPattern);
	    Matcher matcher = p.matcher(logEntryLine);
	    if (!matcher.matches() || 
	      NUM_FIELDS != matcher.groupCount()) {
	      System.err.println("Bad log entry (or problem with RE?):");
	      System.err.println(logEntryLine);
	      return;
	    }
	    System.out.println("IP Address: " + matcher.group(1));
	    System.out.println("Date&Time: " + matcher.group(4));
	    System.out.println("Request: " + matcher.group(5));
	    System.out.println("Response: " + matcher.group(6));
	    System.out.println("Bytes Sent: " + matcher.group(7));
	    if (!matcher.group(8).equals("-"))
	      System.out.println("Referer: " + matcher.group(8));
	    System.out.println("Browser: " + matcher.group(9));
	  }
	}

