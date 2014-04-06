package com.zly.javaLearn.string;
/**
 * @author zenglingying
 * @version 创建时间：2013-8-25 下午10:03:56
 * 类说明
 */
public class StringSplit {
	public  static void main(String[] args){
		String testStr="abc_def";
		System.out.println(testStr.split("_")[1].split("e")[1]);
	}
}
