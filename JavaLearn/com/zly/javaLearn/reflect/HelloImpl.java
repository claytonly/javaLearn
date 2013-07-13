package com.zly.javaLearn.reflect;

public class HelloImpl implements IHello{

	@Override
	public void sayHello(String to) {
		// TODO Auto-generated method stub
		System.out.println("Say hello to " + to);
		
	}

	@Override
	public void print(String p) {
		// TODO Auto-generated method stub
		System.out.println("Say hello to" + p);
	}
	
}
