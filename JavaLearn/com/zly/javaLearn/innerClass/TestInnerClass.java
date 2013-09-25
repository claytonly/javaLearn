package com.zly.javaLearn.innerClass;
/**
 * @author zenglingying
 * @version 创建时间：2013-8-19 下午3:50:34
 * 类说明
 */
public class TestInnerClass {
	private   int testValue;
	private static int staticValue;
	public class InnerClass{
		public int getValue()
		{
			return testValue+staticValue;
		}
	}
	public static class StaticInnerClass{ 
		public int getValue()
		{
			//return testValue;
			return staticValue; 
		}
	}
}
