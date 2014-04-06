package com.zly.javaLearn.multithread;
/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-9-19 ����10:14:43
 * ����2014У԰��Ƹ29�⣨������վ��
 */
public class TestThread {
	
	public static void  main(String[] args){
		//test1
		Thread t1 = new Thread(){
			@Override
			public void run(){
				try{
					int i = 0;
					while(i++ < 100000000){
						
					}
					System.out.println("A1");
				}catch(Exception e){
					System.out.println("B1");
				}
			}
		};
		t1.start();
		t1.interrupt();
		//test2
		Thread t2 = new Thread(){
			@Override
			public void run(){
				try{
					Thread.sleep(5000);
					System.out.println("A2");
				}catch(Exception e){
					System.out.println("B2");
				}
			}
		};
		t2.start();
		t2.interrupt();
		//test3
		Thread t3 = new Thread(){
			@Override
			public void run(){
				try{
					this.wait(50000);
					System.out.println("A3");
				}catch(Exception e){
					System.out.println("B3");
				}
			}
		};
		t3.start();
	}
}
