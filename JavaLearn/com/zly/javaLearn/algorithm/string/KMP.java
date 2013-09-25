package com.zly.javaLearn.algorithm.string;
/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-9-24 ����11:12:33
 * kmp�㷨ʵ��
 */
public class KMP {
	public static int[] getNext(char[] pattern)
	{
		int length = pattern.length;
		int[] next = new int[length];
		next[0] = -1;
		int i = 0;//���ڱ������α�
		int j = -1;//�Ѿ�ƥ����α�
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

		int i = 0; //str���α�
		int j = 0; //pattern���α�
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
