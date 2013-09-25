package com.zly.javaLearn.innerClass;
/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-8-19 ����3:50:34
 * ��˵��
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
