package com.zly.javaLearn.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-8-25 ����5:10:13
 * ��˵��
 */
public class NonNum {
	public static void main(String[] args){
		String input = "2343abc";
		Pattern pattern = Pattern.compile("[^0-9]");
		Matcher matcher = pattern.matcher(input);
		while(matcher.find())
			System.out.println(matcher.group());
	}
}
