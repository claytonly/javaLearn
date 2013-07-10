package com.zly.javaLearn.multithread;

public class PCTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("press control-c stop.");
	}

}
