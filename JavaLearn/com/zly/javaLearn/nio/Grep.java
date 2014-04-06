package com.zly.javaLearn.nio;

import java.io.File;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author zenglingying
 * @version 创建时间：2013-9-26 上午12:57:15
 * 类说明
 */
public class Grep {
	private static Charset charset = Charset.forName("ISO-8859-15");
	private static CharsetDecoder decoder = charset.newDecoder();
	
	private static Pattern linePattern = Pattern.compile(".*\r?\n");
	
	private static Pattern pattern;
	
	private static void compile(String pat)
	{
		try{
			pattern = Pattern.compile(pat);
		}catch(PatternSyntaxException x){
			System.err.println(x.getMessage());
			System.exit(1);
		}
	}
	private static void grep(File f, CharBuffer cb){
		Matcher lm = linePattern.matcher(cb);
		Matcher pm = null;
		int lines = 0;
		while(lm.find()){
			lines++;
			CharSequence cs = lm.group();
			if(pm == null)
				pm = pattern.matcher(cs);
			else
				pm.reset(cs);
			if(pm.find())
				System.out.print(f+":"+lines+":"+cs);
			if(lm.end() == cb.limit())
				break;
		}
	}
}
