package com.zly.javaLearn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRole {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
/*		Class cls1 = Role.class;
		//Class cls2 = Class.forName("yui.Role");
		Constructor con = cls1.getDeclaredConstructor(new Class[]{String.class});
		con.setAccessible(true);
		Object obj = con.newInstance(new Object[] {"lingying"});
		System.out.println(obj);
		
		Constructor<?>[] con1 = cls1.getDeclaredConstructors();
		con1[1].setAccessible(true);
		con1[1].newInstance(new Object[] {"tom"});
		System.out.println("obj1");
		
		cls1.newInstance();*/ 
		        // 加载并初始化命令行参数指定的类     
		        Class classType = Class.forName("com.zly.javaLearn.reflect.Role");     
		        // 获得类的所有方法    
		        Constructor cons[] = classType.getDeclaredConstructors();
		        Method methods[] = classType.getDeclaredMethods();     
		        for (int i = 0; i < methods.length; i++){     
		            System.out.println(methods[i].toString());     
		            
		        }
		        for (int i = 0; i < cons.length; i++)
		        System.out.println(cons[i].toString());
		
	}

}
