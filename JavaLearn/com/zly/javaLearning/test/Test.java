package com.zly.javaLearning.test;
import java.io.*;
import java.util.Date;
public class Test {
public static void main(String[] args) throws InterruptedException
{
	//for(int i = 0; i < 10; i++)
		System.out.println(new Date().getTime()/1000);
		Thread.sleep(1000);
		System.out.println(new Date().getTime()/1000);
}
	
}
