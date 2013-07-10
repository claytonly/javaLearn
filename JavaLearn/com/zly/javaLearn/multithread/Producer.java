/**
 * 
 */
package com.zly.javaLearn.multithread;

public class Producer implements Runnable {
	Q q;
	public Producer(Q q) {
		// TODO Auto-generated constructor stub
		this.q = q;
		new Thread(this,"producer").start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(true)
		{
			q.put(i++);
		}
	}
	
}
