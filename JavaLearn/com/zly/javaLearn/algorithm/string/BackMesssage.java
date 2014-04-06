package com.zly.javaLearn.algorithm.string;
/**
 * @author zenglingying
 * @version 创建时间：2013-9-26 上午4:44:08
 * 回文相关的问题
 */
public class BackMesssage {
//最长回文字符串问题
	/**
	 * manacher算法
	 * 参考http://www.felix021.com/blog/read.php?2040
	 * @return p[i]-1为以i为中心的最长回文半径
	 * 注意p为inputStr增加特殊字符后的结果
	 */
	static public int[] manacherMethod(char[] inputStr)
	{
		char[] input = addSpecChar(inputStr);
		int length = input.length;
		int[] p = new int[length];//p[i]为以input[i]为中心的最长回文半径
		int mx = 0;//最大半径
		int id = 0;//上一次访问的中心节点
		for(int i = 0; i < length; i++)
		{
			p[i]= mx > i ? Math.min(p[2*id-i], mx-i):1;
			while(i > 0 && i+p[i] < length && p[i] <= i && input[i+p[i]] == input[i-p[i]]){
				p[i]++;
			}
			if(i+p[i] > mx){
				mx = id + p[i];
				id=i;
			}
		}
		return p;
	}
	/**
	 * 在inputStr[i]增加‘#’,例如abc变成#a#b#c#
	 * @param inputStr
	 * @return
	 */
	static private char[] addSpecChar(char[] inputStr)
	{
		int inpuStrLength = inputStr.length;
		int newStrLength = 2*inpuStrLength+1;
		char[] newStr = new char[newStrLength];
		int j;
		for(int i = 0; i < inpuStrLength; i++)
		{
			j = 2*i;
			newStr[j]='#';
			if(i < inpuStrLength)
				newStr[j+1] = inputStr[i];
		}
		newStr[newStrLength-1]='#';
		System.out.println(newStr);
		return newStr;
	}
	
	static public void main(String[] args)
	{
		String input = "abba";
		int[] result = manacherMethod(input.toCharArray());
		
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i]);
	}
}
