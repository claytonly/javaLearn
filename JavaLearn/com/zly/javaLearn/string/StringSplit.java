package com.zly.javaLearn.string;
/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-8-25 ����10:03:56
 * ��˵��
 */
public class StringSplit {
	public  static void main(String[] args){
		String testStr="abc_def";
		System.out.println(testStr.split("_")[1].split("e")[1]);
	}
}
