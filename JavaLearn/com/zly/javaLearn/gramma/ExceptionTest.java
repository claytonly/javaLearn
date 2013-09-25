package com.zly.javaLearn.gramma;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-9-13 ����8:56:00
 * ��˵��
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
