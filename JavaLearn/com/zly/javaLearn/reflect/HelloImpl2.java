package com.zly.javaLearn.reflect;

public class HelloImpl2 implements IHello{

	@Override
	public void sayHello(String to) {
		// TODO Auto-generated method stub
		System.out.println("Another implement Say Hello to " + to);
	}

	@Override
	public void print(String p) {
		// TODO Auto-generated method stub
		System.out.println("Another implement print " + p);
		
	}

}
