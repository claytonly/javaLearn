package com.zly.javaLearn.multithread;

public class AccountTest {
	static class Account {
		String name;
		float amount;

		public Account(String name, float amount) {
			this.name = name;
			this.amount = amount;
		}

		public synchronized void deposit(float amt) {
			float tmp = amount;
			tmp += amt;
			amount = tmp;
		}

		public synchronized void withdraw(float amt) {
			float tmp = amount;
			tmp -= amt;
			amount = tmp;
		}

		public float getBalance() {
			return amount;
		}
	}
	private static int NUM_OF_THREAD = 1000;
	static Thread[] threads = new Thread[NUM_OF_THREAD];

	public static void main(String[] args) {
		final Account acc = new Account("John", 1000);
		for (int i = 0; i < NUM_OF_THREAD; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					acc.deposit(100.0f);
					acc.withdraw(100.0f);
				}
			});
			threads[i].start();
		}

		for (int i = 0; i < NUM_OF_THREAD; i++) {
			try {
				threads[i].join(); // 等待所有线程运行结束
			} catch (InterruptedException e) {
				// ignore
			}
		}
		System.out.println("Finally, John's balance is:" + acc.getBalance());
	}
}
