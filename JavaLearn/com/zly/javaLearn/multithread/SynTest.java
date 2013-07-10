package com.zly.javaLearn.multithread;

import java.util.Date;
import java.text.SimpleDateFormat;

public class SynTest {
	static Test1 test1;
	static Test2 test2;
	
	public SynTest() {
		test1 = new Test1();
		test2 = new Test2();
	}

	static class Test1 {
		Test1() {
		}

		void test() {
			for (int i = 0; i < 100000000; i++)
				;
			System.out.println(new Date().getTime()+ " test1");
		}
	}

	static class Test2 {
		Test2() {
		}

		void test() {
			for (int i = 0; i < 100000000; i++)
				;
			System.out.println(new Date().getTime()+ " test2");
		}
	}

	static class MyThread implements Runnable {
		
		Thread t;
		SimpleDateFormat df;//设置日期格式
		
		MyThread(String test) {
			super();
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			t = new Thread(this,test);
			t.start();
		}

		public void run() {
			
			synchronized (test1) {
				System.out.println(new Date().getTime()+" test1: thread name "+ t.getName());
				test1.test();
			}
			synchronized (test2) {
				System.out.println(new Date().getTime()+" test2: thread name "+ t.getName());
				test2.test();
			}
		}
	}

	public static void main(String[] args) {
		test1 = new Test1();
		test2 = new Test2();
		MyThread a = new MyThread("test1");
		MyThread b = new MyThread("test2");
	}

}
