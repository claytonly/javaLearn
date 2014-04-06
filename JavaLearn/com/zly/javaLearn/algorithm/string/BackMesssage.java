package com.zly.javaLearn.algorithm.string;
/**
 * @author zenglingying
 * @version ����ʱ�䣺2013-9-26 ����4:44:08
 * ������ص�����
 */
public class BackMesssage {
//������ַ�������
	/**
	 * manacher�㷨
	 * �ο�http://www.felix021.com/blog/read.php?2040
	 * @return p[i]-1Ϊ��iΪ���ĵ�����İ뾶
	 * ע��pΪinputStr���������ַ���Ľ��
	 */
	static public int[] manacherMethod(char[] inputStr)
	{
		char[] input = addSpecChar(inputStr);
		int length = input.length;
		int[] p = new int[length];//p[i]Ϊ��input[i]Ϊ���ĵ�����İ뾶
		int mx = 0;//���뾶
		int id = 0;//��һ�η��ʵ����Ľڵ�
		for(int i = 0; i < length; i++)
		{
			p[i]= mx > i ? Math.min(p[2*id-i], mx-i):1;
			while(i > 0 && i+p[i] < length && p[i] <= i && input[i+p[i]] == input[i-p[i]]){
				p[i]++;
			}
			if(i+p[i] > mx){
				mx = id + p[i];
				id=i;
			}
		}
		return p;
	}
	/**
	 * ��inputStr[i]���ӡ�#��,����abc���#a#b#c#
	 * @param inputStr
	 * @return
	 */
	static private char[] addSpecChar(char[] inputStr)
	{
		int inpuStrLength = inputStr.length;
		int newStrLength = 2*inpuStrLength+1;
		char[] newStr = new char[newStrLength];
		int j;
		for(int i = 0; i < inpuStrLength; i++)
		{
			j = 2*i;
			newStr[j]='#';
			if(i < inpuStrLength)
				newStr[j+1] = inputStr[i];
		}
		newStr[newStrLength-1]='#';
		System.out.println(newStr);
		return newStr;
	}
	
	static public void main(String[] args)
	{
		String input = "abba";
		int[] result = manacherMethod(input.toCharArray());
		
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i]);
	}
}
