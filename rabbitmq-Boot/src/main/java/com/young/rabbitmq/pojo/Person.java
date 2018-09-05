package com.young.rabbitmq.pojo;


/**
 * 
 * @author 		  Young
 * @description   模拟风控返回信息
 * @date          2018年4月21日 下午11:54:20 
 *
 */
public class Person {

	/**
	 * 
	 */
	
	private String name;
	
	private String age;
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAge() {
		
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
