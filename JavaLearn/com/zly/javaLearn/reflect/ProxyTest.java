package com.zly.javaLearn.reflect;

import java.lang.reflect.Proxy;

public class ProxyTest {
	
	public static void main(String[] args){
		
		HelloImpl impl = new HelloImpl();
		HelloImpl2 impl2 = new HelloImpl2();
		LogHandler handler = new LogHandler(impl);
		
		IHello hello = (IHello) Proxy.newProxyInstance(impl.getClass().getClassLoader(),impl.getClass().getInterfaces(), handler);
		IHello hello2 = (IHello) Proxy.newProxyInstance(impl2.getClass().getClassLoader(), impl2.getClass().getInterfaces(), handler);
//		hello.print(" All the test");
//		hello.sayHello(" Denny");
		hello2.sayHello("Hello2");
		hello2.sayHello("very good");
				
	}
}
