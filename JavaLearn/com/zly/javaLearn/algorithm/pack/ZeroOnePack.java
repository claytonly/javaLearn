package com.zly.javaLearn.algorithm.pack;
/**
 * @author zenglingying
 * @version 创建时间：2013-8-31 下午12:58:46
 * 01背包问题
 */
public class ZeroOnePack {
	static public void main(String[] args)
	{
		int volume = 100;
		int[] value= new int[] {1,3,5};
		int[] weight = new int[] {12,14,16};
		
		packFullLessSpace(value, weight, volume);
//		packFull(value, weight, volume);
	}
	public static void packFull(int[] value, int[] weight, int volume)
	{
		int length = value.length;
		int[][] array = new int[length][volume+1];
		boolean[] pack = new boolean[length];
		for(int i = 0; i < length; i++){
			for(int j = 0; j < volume; j++)
					array[i][j] = 0;
		}
		for(int i = 0; i < length; i++)//第i个物品
			for(int j = 0; j <= volume; j++){
					if(i == 0){
						array[i][j]=value[i];	
						continue;
					}
					if( j >= weight[i] )
						array[i][j]=Math.max(array[i-1][j], array[i-1][j-weight[i]]+value[i]);
					else
						array[i][j]=array[i-1][j];
			}
		System.out.println(array[length-1][volume]);
	}
	public static void packFullLessSpace(int[] value, int[] weight, int volume)
	{
		int length = value.length;
		int[] array = new int[volume+1];
		boolean[] pack = new boolean[length];
		
		array[0]=value[0];
		for(int j = 0; j <= volume; j++)
		{
			array[j] = 0;
		}
		int bound = 0;
		int k;
		for(int i = 0; i < length; i++){
	/*		for(k = 0;k < i; k++ )
				bound += weight[k];
			bound = Math.max(volume-bound, weight[i]);*/
//			for(int j = bound; j <= volume ; j++)
			for(int j = volume; j >= weight[i]; j--)
			{
				System.out.println("j "+j+" weight "+weight[i]);
				array[j]=Math.max(array[j], array[j-weight[i]]+value[i]);
			}
		}
		System.out.println(array[volume]);
	}
}
