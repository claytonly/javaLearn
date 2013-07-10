package com.zly.javaLearn.multithread;

public class Q {
	
	int n;
	boolean valueSet = false;
	
	synchronized int get(){
		if(!valueSet)
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("InterruptedException caught");
			}
		System.out.println("Got: "+n);
		valueSet = false;
		notify();
		
		return n;
	}
	
	synchronized void put(int n){
		if(valueSet)
			try{
				wait();
			}catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println("InterruptException caught");
			}
		this.n = n;
		valueSet = true;
		System.out.println("Put: "+n);
		notify();
	}

}