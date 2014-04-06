package com.zly.javaLearn.linux.memory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zenglingying
 * @version 创建时间：2013-10-14 上午10:41:07
 * 类说明
 */
public class MyLinuxResourceReader {
	
	final String MEMORY_FILE="/proc/meminfo";
	final String MEMTOTAL_STRING="MemTotal";
	final String MEMFREE_STRING="MemFree";
	final String SWAPTOTAL_STRING="SwapTotal";
	final String SWAPFREE_STRING="SwapFree";
	
	long totalPhysicalRam;
	long availablePhysicalRam;
	long totalSwap;
	long availableSwap;
	
	Pattern pattern_memory=Pattern.compile("^([a-zA-Z]*):([ \t]*)([0-9]*)[ \t](kB)");
	BufferedReader in = null;
	
	public MyLinuxResourceReader() {
		// TODO Auto-generated constructor stub
		try {
			in = new BufferedReader(new FileReader(new File(MEMORY_FILE)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String readMemory()
	{
		String str = null;
		try {
			str = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public void getMemory()
	{
		String line;
		Matcher mat;
		while((line=readMemory()) != null)
		{
			mat = pattern_memory.matcher(line);
			if(mat.find())
			{
				if(mat.group(1).equals(MEMTOTAL_STRING))
				{
					totalPhysicalRam = Long.parseLong(mat.group(2));
				}else if(mat.group(1).equals(MEMFREE_STRING)){
					availablePhysicalRam = Long.parseLong(mat.group(2));
				}else if(mat.group(1).equals(SWAPTOTAL_STRING)){
					totalSwap = Long.parseLong(mat.group(2));
				}else if(mat.group(1).equals(SWAPFREE_STRING)){
					availableSwap = Long.parseLong(mat.group(2));
				}
			}
		}
	}
	public void outputMemory()
	{
		System.out.println(MEMTOTAL_STRING+" "+totalPhysicalRam+" "+MEMFREE_STRING+" "+availablePhysicalRam);
		System.out.println(SWAPTOTAL_STRING+" "+totalSwap+" "+SWAPTOTAL_STRING+" "+availableSwap);
	}
	public static void main(String[] args)
	{
		MyLinuxResourceReader resourceReader = new MyLinuxResourceReader();
		resourceReader.readMemory();
		
	}
	
}
