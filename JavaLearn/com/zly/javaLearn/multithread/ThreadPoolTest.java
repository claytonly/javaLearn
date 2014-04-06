package com.zly.javaLearn.multithread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zenglingying
 * @version 创建时间：2014-3-22 上午11:16:56
 * 类说明
 */
public class ThreadPoolTest {
	public static void main(String[] args)
	{
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		ScheduledExecutorService threadSchedulerPool = Executors.newScheduledThreadPool(3);
		for(int i = 0; i < 5; i++)
		{
			final int taskId = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
						for (int i = 0; i < 10; i++)
						{
							try {
								Thread.sleep(30);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("taskid "+taskId+" "+new Date().getSeconds()+" "+Thread.currentThread().getName()+" running task "+taskId);
						}
				}
			});
		}
		threadPool.shutdown();
		threadSchedulerPool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("calling at "+System.nanoTime());
				}
			}, 
			10, 
			2, 
			TimeUnit.SECONDS);
		
	}
}
