package com.zly.javaLearn.algorithm.string;
/**
 * @author zenglingying
 * @version 创建时间：2013-9-24 下午11:12:33
 * kmp算法实现
 */
public class KMP {
	public static int[] getNext(char[] pattern)
	{
		int length = pattern.length;
		int[] next = new int[length];
		next[0] = -1;
		int i = 0;//正在遍历的游标
		int j = -1;//已经匹配的游标
/*		for(int i = 0; i < length; i++)
		{
			while(k > 0 && pattern.charAt(k+1) != pattern.charAt(i))
			{
				k = next[k];
			}
			if(pattern.charAt(k+1) == pattern.charAt(i))
				k = k+1;
			next[i]=k;
		}*/
		while(i < length -1)
			if(j == -1 || pattern[i] == pattern[j])
			{
				i++;
				j++;
				if(pattern[i] != pattern[j])
					next[i] = j;
				else
					next[i] = next[j];
			}
			else
				j = next[j];
		for(i = 0; i < length; i++)
			System.out.println(i+" "+next[i]);
		return next;
	}
	public static boolean kmp(char[] str, char[] pattern)
	{
		int[] next = getNext(pattern);
		int strLength = str.length;
		int patLength = pattern.length;

		int i = 0; //str的游标
		int j = 0; //pattern的游标
		while(i < strLength && j < patLength)
		{
			if(j == -1 || str[i] == pattern[j])
			{
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		if(j < patLength){
			return false;
		}else{
			return true;
		}
		
	}
	public static void main(String[] args)
	{
		String str="abbabbbbcab";
		String pat="babb";
		System.out.println(kmp(str.toCharArray(), pat.toCharArray()));
	}
}
