package com.zly.javaLearn.jobWant.algorithm;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zenglingying
 * @version 创建时间：2013-8-30 上午11:30:04
 * 类说明
 */
public class IFGramma {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		scanner.close();
		if(inputStr.equals(""))
			return;
		Pattern pattern = Pattern.compile("^if|^IF");
		Matcher matcher = pattern.matcher(inputStr);
		if(matcher.find() == false)
			return;
		System.out.println(inputStr);
		if(inputStr.equals("") == false)
			grammerJudge(inputStr);
		else
			return;
	}

	private static void grammerJudge(String inputStr) {
		// TODO Auto-generated method stub
		Stack<String> assistStack = new Stack();
		String str;
		int leftNum = 0;
		int rightNum = 0;
		int i;
		for( i = 0; i < inputStr.length(); i++)
		{
			str = inputStr.substring(i,i+1);
			System.out.println(str);
			if(str.equals("(")){
				leftNum++;
				assistStack.add(str);
				continue;
			}
			if(str.equals(")")){
				rightNum++;
				if(assistStack.size() > 1){
					assistStack.pop();
					continue;
				}else{
					assistStack.add(str);
					break;
				}
			}
		}
		System.out.println("size "+assistStack.size());
		if(i == inputStr.length()-1){
			if(assistStack.size() == 2 && assistStack.pop().equals(")") && assistStack.pop().equals("("))
			{
				System.out.println("RIGHT "+leftNum+" "+rightNum);
			}
		}
		else{ 
			i=i+1;
			for(;i < inputStr.length(); i++)
			{
				str = inputStr.substring(i,i+1);
				if(str.equals("("))
					leftNum++;
				if(str.equals(")"))
					rightNum++;
			}
			System.out.println("WRONG "+leftNum+" "+rightNum);
		}
			
	}
	
}
