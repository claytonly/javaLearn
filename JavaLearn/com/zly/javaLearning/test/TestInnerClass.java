package com.zly.javaLearning.test;

public class TestInnerClass {

	TestInnerClass() {
		super();
		System.out.println("out class constructor");
	}

	private class InnerClass {

		public InnerClass() {
			super();
			System.out.println("inner class constructor");
		}

		private void innerTest() {
			System.out.println("inner class test");
			outTest();
		}
	}
	
	static private class InnerClassStatic{
		public InnerClassStatic() {
			// TODO Auto-generated constructor stub
			System.out.println("static inner class constructor");
		}
		private void innerTest() {
			System.out.println("static inner class test");
			outTestStatic();
		}
	}

	private void outTest() {
		System.out.println("out class test");
	 }
	static private void outTestStatic() {
			System.out.println("out class testStatic ");
	 }

	static public void main(String[] args) {
			TestInnerClass testInnerClass = new TestInnerClass();
			TestInnerClass.InnerClass innerClass = testInnerClass.new InnerClass();
			testInnerClass.outTest();
			innerClass.innerTest();
			TestInnerClass.InnerClassStatic staticInnerClass = new TestInnerClass.InnerClassStatic() ;
			staticInnerClass.innerTest();
	}
}
