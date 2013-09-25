package com.zly.javaLearn.gramma;
/**
 * @author zenglingying
 * @version 创建时间：2013-9-13 上午8:24:22
 * 类说明
 */
public class TypeConvert {
	public static void main()
	{
		
	}
	public static void main(String[] args)
	{
		byte s = 2, e = 3;
		//byte f = s+e; 错误
		//byte s=s+1; 错误
		s += 1;
		int i = 6;
		s++;
		//System.out.println(i++);
		//System.out.println(i+'0');
		//System.out.println(i);
		//System.out.println(i--);
		int a = 5;
		int b = 3;
		//assert(!(a&&b++));
		System.out.println(a+" "+b);
	}
}
