package com.zly.javaLearn.multithread;
/**
 * @author zenglingying
 * @version 创建时间：2014-3-29 下午8:43:57
 * 类说明
 */
public class MultiThreadShareData {
		 static DataShared data = new DataShared();
         public static class incData implements Runnable
         {
                public void run()
                {
			         while(true)
			        	 data.inc();
                }
         }
         public static class decData implements Runnable
		 {
		    public void run()
		    {
		         while(true)
		        	 data.dec();
		    }	
		 } 
         public static void main(String[] args)
         {
                   
         }
    }
class DataShared{
	private static int j = 0;
	public synchronized  void inc()
	{
	     j++;
	}
	public synchronized  void dec()
	{
	     j--;
	}
}
