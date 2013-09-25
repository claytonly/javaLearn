package com.zly.javaLearn.string;

import java.util.regex.*;


/**
 * @author zenglingying
 * @version 创建时间：2013-8-23 下午9:12:56
 * 类说明
 */
public class RegexLearn {
	public static void main(String[] args){
		RegexLearn reg = new RegexLearn();
		String str = "abdc	90233	kB";
		reg.groupPattern(str);
	}
	
	public void basic()
	{
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
	public void groupPattern(String str)
	{
		Pattern pattern = Pattern.compile("([a-zA-Z]*)[ \t]*([0-9]*)[ \t](kB)");
		Matcher mat = pattern.matcher(str);
		int n = 0;
		if(mat.find())
			n = mat.groupCount();
		for(int i = 1 ; i <= n ; i++)
			System.out.println(mat.group(i));
		
	}

}
