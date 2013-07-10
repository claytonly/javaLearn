package com.zly.javaLearning.test;
import java.io.*;

//for graduate thesis utility
public class TimeToSecond {

	public static void strToInt(String[] time,int[] t)
	{
		for (int i = 0; i < time.length; i++)
		{
			t[i]=new Integer(time[i]).intValue();
		}
	}
	public static void main(String[] args) throws IOException
	{
		String line;
		String [] time;
		int[] t={0,0,0,0,0,0};
		String dir="F:\\文档\\毕业论文\\实验\\任务类型\\sort\\6G";
		File[] files=new File(dir+"\\time").listFiles();
		System.out.println("Files "+files.length);
		BufferedReader read;
		BufferedWriter writer;
		int begin,end;
		for (int i = 0; i < files.length; i++)
		{
			read=new BufferedReader(new InputStreamReader(new FileInputStream(files[i])));
			writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(dir+"\\draw\\"+files[i].getName()+".result"))));
			long count=0;
			System.out.println(files[i].getName());
			while(( line = read.readLine()) != null)
			{
				time=line.split(" ");
				strToInt(time,t);
				begin=t[0]*3600+t[1]*60+t[2];
				end=t[3]*3600+t[4]*60+t[5];
				writer.write(begin+","+end+","+count+"\r\n");
				count++;
			}
			writer.flush();
			writer.close();
			read.close();
		}
		System.out.println("finish");
		
	}
	

}
