package com.zly.javaLearn.string;

import java.util.regex.*;


/**
 * @author zenglingying
 * @version 创建时间：2013-8-23 下午9:12:56
 * 类说明
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
