package com.zly.javaLearn.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * 线程内的数据共享,ThreadLocal实现
 * @author zenglingying
 * @version 创建时间：2014-3-22 下午1:05:35
 * 类说明
 */
public class ThreadLocalTest {
	
	//线程内共享数据
	static class ThreadShareData{
		
		private static ThreadLocal<ThreadShareData> map = new ThreadLocal<ThreadShareData>();
		private String name;
		private int age;
		
		private ThreadShareData(){};
		public static ThreadShareData getInstance()
		{	
			ThreadShareData instance = map.get();
			if( instance == null){
				instance = new ThreadShareData();
				map.set(instance);
			}
			return instance;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}
	static class A{
		public void get()
		{
			System.out.println("A from "+Thread.currentThread().getName()+" get age"+ThreadShareData.getInstance().getAge());
			System.out.println("A from "+Thread.currentThread().getName()+" get name"+ThreadShareData.getInstance().getName());
		}
	}
	
	static class B{
		public void get()
		{
			System.out.println("B from "+Thread.currentThread().getName()+" get age"+ThreadShareData.getInstance().getAge());
			System.out.println("B from "+Thread.currentThread().getName()+" get name"+ThreadShareData.getInstance().getName());
		}
	}
	public static void main(String[] args)
	{
		for(int i = 0; i < 2; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					ThreadShareData data = ThreadShareData.getInstance();
					data.setAge(new Random().nextInt());
					data.setName("name"+new Random().nextInt());
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
}
