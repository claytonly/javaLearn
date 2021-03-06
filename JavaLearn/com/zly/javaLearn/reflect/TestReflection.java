package com.zly.javaLearn.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {

	static public Object copy(Object object) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class classType = object.getClass();
		System.out.println("Class: "+classType.getCanonicalName());
		
		Object objectCopy = classType.getConstructor(new Class[]{}).newInstance(new Object[] {});
		
		Field fields[] = classType.getDeclaredFields();
		for (int i = 0; i < fields.length; i++){
			Field field = fields[i];
			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0,1).toUpperCase();
			
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			
			Method getMethod = classType.getMethod(getMethodName, new Class[]{});
			Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});
			
			Object value = getMethod.invoke(object, new Object[] {});
			System.out.println(fieldName + " "+ value);
			setMethod.invoke(objectCopy, new Object[] {value});
			
			
		}
		return objectCopy;
		
		
	}
	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Customer customer = new Customer("tom",21);
		customer.setId(new Long(2));
		Customer customerCopy = (Customer) TestReflection.copy(customer);
		System.out.println("Copy information:" + customerCopy.getName() +
				" "+ customer.getName());
	}

}

class Customer{
	private Long id;
	private String name;
	private int age;
	
	public Customer() {     
    }

	Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
