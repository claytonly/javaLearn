package com.zly.javaLearn.string;

import java.util.regex.*;


/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-8-23 ����9:12:56
 * ��˵��
 */
public class RegexLearn {
	public static void main(String[] args){
		String regex="[0-9]*";
		String input="12a34b56c78";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(input);
		//while(match.find())
		/*	System.out.println("Match start "+
					+match.start()+" content "+match.group()
					+" end "+match.end());*/
			
		System.out.println(Pattern.matches("[0-9]", "jiel345"));
	}

}
