package com.zly.javaLearn.algorithm.sort;


/**
 * @author zenglingying
 * @version 创建时间：2013-8-11 上午9:39:13
 * 类说明
 */
//排序类，默认从小到大
public class Sort {
	//冒泡排序
	public static <T extends Num>  void bubbleSort(T[] array)
	{
		int length;
		length = array.length-1;
		for(int i = length-1; i >= 0; i--)//冒泡的终点
		{
			int minIndex = i;
			for(int j = 0; j <= i; j++)//冒泡
			{
				if(compare(array[j],array[j+1]))
					swap(array, j, j+1);
			}
		}
	}
	//选择排序
	public static void selectSort(int[] array)
	{
		int length;
		int maxIndex;
		length = array.length-1;
		for(int i = 0 ; i >= length-1; i++){
			maxIndex = i;
			for(int j = i+1; j < length; i++)
			{
				if(array[j] < array[maxIndex])
					maxIndex = j; 
			}
			swap(array, i, maxIndex);
		}
	}
	//插入排序
	public static void insertSort(int[] array)
	{
		int length;
		length = array.length;
		for(int i = 1; i < length; i++)//待插入数字
		{
			int j=i-1;
			int tmp=array[i];
			while(j >= 0 && tmp < array[j])//与已排序数组比较
				{ 
					array[j+1] = array[j];
					j--;
				}
			array[j+1] = tmp;
		}
			
	}
	//shell排序
	public static void shellSort(int[] array)
	{
		
		int length = array.length;
		if(length < 2)
			return;
		int step = length/2;
		
		while(step >= 1){
			for(int i = 0 ; i < step; i++)//各个组的起始元素
			{
				for(int j = i+step; j < length; j = j+step){//组与组之间进行插入排序
					int k = j - step;
					int tmp = array[j];
					while(k >= 0 && tmp < array[k])//插入排序
					{
							array[k+step] = array[k];
							k -= step;
					}
					array[k+step]=tmp;
				}
			}
			step /= 2;
		}
		
	}
	//快速排序
	public static void quickSort(int[] array,int start,int end)
	{	
		if(array == null)
			return;
		if(start == end)
			return;
		int partIndex = partition(array, start, end);
		if(start < partIndex-1)
			quickSort(array,start,partIndex-1);
		if(partIndex+1 < end)
			quickSort(array,partIndex+1,end);
		for(int i = start; i < end; i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	public static int partition(int[] array, int startIndex, int endIndex)
	{
		if(array == null)
		{
			System.out.println("array is null");
			return -1;
		}
		int baseIndex = (startIndex+endIndex)/2;
		swap(array, baseIndex, endIndex);
		int start = startIndex;
		int end = endIndex-1;
		while(start < end)
		{
			while(array[start] <= array[endIndex])
				start++;
			while(array[end] > array[endIndex])
				end--;
			if(start < end){
				swap(array, start, end);
			}
		}
		swap(array,start,endIndex);
		return start;
	}
	public static void mergeSort(int[] array, int start, int end)
	{
		if(start < end)
		{
			int mid = (start+end)/2;
			mergeSort(array, start, mid);
			mergeSort(array, mid+1, end);
			merge(array, start, mid, end);
			
		}
	}
	public static void merge(int[] array,int start, int mid, int end)
	{
		int i = start;
		int j = mid+1;
		int k = 0;
		int[] temp = new int[array.length];
		while(i <= mid && j <= end)
		{
			if(array[i] <= array[j])
				temp[k++] = array[i++];
			else
				temp[k++] = array[j++];
		}
		while(i <= mid)
			temp[k++] = array[i++];
		while(j <= end)
			temp[k++]=array[j++];
		int tempIndex = 0;
		for(int arrayIndex = start; arrayIndex <= end; arrayIndex++){
			array[arrayIndex] = temp[tempIndex++];
		}
	}
	//计数排序
	public static void countSort(int[] array, int maxValue)
	{
		int[] countArray = new int[maxValue+1];
		int[] arrayCopy = new int[array.length];
		
		for(int i = 0; i < maxValue; i++)
		{
			countArray[i] = 0;
		}
		for(int i = 0; i < array.length; i++)
		{
			countArray[array[i]]++;
			arrayCopy[i] = array[i];
		}
		for(int i = 0; i < countArray.length-1; i++)
		{
			countArray[i+1] += countArray[i];
		}
		int t;
		for(int i = 0; i < array.length-1; i++)
		{
			t = arrayCopy[i];
			array[countArray[t]-1]=t; 
			countArray[t]--;
		}
	}
	public static void heapSort(int[] array)
	{
		
	}
	public static void radixSort(int[] array)
	{
		
	}
	public static void baseSort(int[] array)
	{
		
	}
	public static void bucketSort(int[] array)
	{
		
	}
	/**
	 * @param args
	 */
	//交换数据
	public static <T> void swap(T[] array, int i, int j)
	{
		if(array == null){
			System.out.println("array is null");
			return ;
		}
		if( i > array.length || j > array.length )
		{
			System.out.println("i "+i+" j"+j+"Length "+array.length);
			return;
		}
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public <T> boolean compare(T number1, T number2)
	{
		if(T.comare(number1, number2))
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]={1,3,10,5,7,6,9,2};
		bubbleSort(array);
		System.out.println(array.length);
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i]+" ");
	}

}
