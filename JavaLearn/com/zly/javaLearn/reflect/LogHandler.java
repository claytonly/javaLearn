package com.zly.javaLearn.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler{
	private Object  obj;
	
	public LogHandler(Object obj){
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		doBefore();
		Object result = method.invoke(obj, args);
		after();
		return null;
	}

	private void after() {
		// TODO Auto-generated method stub
		System.out.println("after...................");
		
	}

	private void doBefore() {
		// TODO Auto-generated method stub
		System.out.println("before ..............");
	}
	
}
