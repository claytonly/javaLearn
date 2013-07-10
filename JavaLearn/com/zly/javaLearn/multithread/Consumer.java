package com.zly.javaLearn.multithread;

public class Consumer implements Runnable{
	Q q;
	public Consumer(Q q) {
		// TODO Auto-generated constructor stub
		this.q = q;
		new Thread(this, "consumer").start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(true)
		{
			q.get();
		}
	}

}
