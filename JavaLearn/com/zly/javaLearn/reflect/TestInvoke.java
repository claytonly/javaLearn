package com.zly.javaLearn.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class TestInvoke {
	
	public int add(int param1, int param2){
		return param1+param2;
	}
	public String echo(String msg) {
		return "echo:" + msg;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class classType = TestInvoke.class;
		Object invokerTester = classType.newInstance();
		
		Method addMethod = classType.getMethod("add", new Class[]{
				int.class, int.class});
		Object result =	addMethod.invoke(invokerTester, new Object[]{
				new Integer(100), new Integer(200)});
		System.out.println((Integer) result);
		
		Method echoMethod = classType.getMethod("echo", new Class[] {String.class});
		result = echoMethod.invoke(invokerTester, new Object[]{"hello"});
		
		System.out.println((String) result);
		
//create array
		Class stringClassType = Class.forName("java.lang.String");
		Object array = Array.newInstance(stringClassType, 10);
		Array.set(array, 5, "yes"); 
		String s = (String) Array.get(array, 5);
		
		System.out.println(s);
//multiple dimension array		
		int dims[] = new int[] {5, 10, 15};
		Object array1 = Array.newInstance(Integer.TYPE, dims);
		Object arrayObj = Array.get(array1, 3);
		Class cls = arrayObj.getClass().getComponentType();
		System.out.println(cls);
		arrayObj = Array.get(arrayObj, 5);
		Array.setInt(arrayObj, 10, 37);
		int arrayCast[][][] = (int [][][]) array1;
		System.out.println(arrayCast[3][5][10]);

	}

}
