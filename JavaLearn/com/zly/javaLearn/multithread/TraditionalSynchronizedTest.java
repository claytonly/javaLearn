package com.zly.javaLearn.multithread;
/**
 * @author zenglingying
 * @version 创建时间：2014-3-22 下午12:25:42
 * 类说明
 */
public class TraditionalSynchronizedTest {
	static class Output{
		
		public synchronized static void output(String name){
			for (int i = 0; i < name.length(); i++)
				System.out.print(name.charAt(i));
			System.out.println();
		}
		
		public synchronized void output2(String name){
			for (int i = 0; i < name.length(); i++)
				System.out.print(name.charAt(i));
			System.out.println();
		}
		
		public void output3(String name){
			synchronized (this) {
				for (int i = 0; i < name.length(); i++)
						System.out.print(name.charAt(i));
					System.out.println();
				}
				
		}
		  synchronized public void output4(String name){
				for (int i = 0; i < name.length(); i++)
						System.out.print(name.charAt(i));
					System.out.println();
		}
	}
	private void init()
	{
		final Output output = new Output();;
		new Thread(new  Runnable() {
			public void run() {
				while (true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					output.output("zenglingying");
				}
			}
		}).start();
		new Thread(new  Runnable() {
			public void run() {
				while (true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					output.output4("zhangxiaoxiang");
				}
			}
		}).start();
	}
	
	public static void main(String[] args){
		new TraditionalSynchronizedTest().init();
	}
}
