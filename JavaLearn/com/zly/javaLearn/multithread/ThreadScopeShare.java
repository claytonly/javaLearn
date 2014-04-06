package com.zly.javaLearn.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * �߳��ڵ����ݹ���
 * @author zenglingying
 * @version ����ʱ�䣺2014-3-22 ����1:05:35
 * ��˵��
 */
public class ThreadScopeShare {
	static Map<Thread, Integer> shareDataMap = new HashMap<Thread, Integer>();
	static class A{
		public void get()
		{
			System.out.println("A from "+Thread.currentThread().getName()+" get data"+shareDataMap.get(Thread.currentThread()));
		}
	}
	
	static class B{
		public void get()
		{
			System.out.println("B from "+Thread.currentThread().getName()+" get data"+shareDataMap.get(Thread.currentThread()));
		}
	}
	public static void main(String[] args)
	{
		for(int i = 0; i < 2; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					shareDataMap.put(Thread.currentThread(), new Random().nextInt());
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
}
