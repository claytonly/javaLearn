package com.zly.javaLearn.gramma;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author zenglingying
 * @version 创建时间：2013-9-13 上午8:56:00
 * 类说明
 */
public class ExceptionTest {
	
	public static void main(String[] args)
	{
		ExceptionTest test = new ExceptionTest();
		//test.print();
		boolean a = test.print();
		System.out.println(a);
	}
	public static boolean print()
	{
		try{
			File file = new File("ExceptionTest.java");
			FileInputStream in = new FileInputStream(file);
			in.read();
		}catch(IOException e){
			System.out.println("catch running");
			return false;
		}finally{
			System.out.println("finally running");
		}
		return true;
	}

}
