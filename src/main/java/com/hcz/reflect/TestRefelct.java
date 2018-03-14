package com.hcz.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestRefelct {

	/**
	 * 反射 加载类，获取类的字节码的几种方式
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		//1
		Class clazz = Class.forName("com.hcz.reflect.Person");
		//2
		Class clazz1 = new Person().getClass();
		//3
		Class clazz2=Person.class;
		
	}
	
	// 反射构造函数：public Person()
	@Test
	public void test1() throws Exception{
		Class clazz = Class.forName("com.hcz.reflect.Person");
		Constructor<Person> c = clazz.getConstructor(null);
		Person p = c.newInstance(null);
		System.out.println(p.getName());
	}
	
		// 反射构造函数：public Person(String name)
		@Test
		public void test2() throws Exception{
			Class clazz = Class.forName("com.hcz.reflect.Person");
			Constructor<Person> c = clazz.getConstructor(String.class);
			Person p = c.newInstance("张三");
			System.out.println(p.getName());
		}
		
		// 反射构造函数：private Person(String name,int height)
		@Test
		public void test3() throws Exception{
			Class clazz = Class.forName("com.hcz.reflect.Person");
			Constructor<Person> c = clazz.getDeclaredConstructor(String.class,int.class);
			c.setAccessible(true);// 暴力反射
			Person p = c.newInstance("李四",180);
			System.out.println(p.getName()+p.getHeight());
		}
		
		// 反射构造函数:简单方式 无参
		@Test
		public void test4() throws Exception{
			Class clazz = Class.forName("com.hcz.reflect.Person");
			Person p = (Person) clazz.newInstance(); // 无参构造函数
			System.out.println(p.getName()+p.getHeight());
		}
		
		// 反射方法:public void eat(){
		@Test
		public void test5() throws Exception{
			Class clazz = Class.forName("com.hcz.reflect.Person");
			Person p = (Person) clazz.newInstance();
			Method m = clazz.getMethod("eat");
			m.invoke(p);
		}
		
		// 反射方法:public String eat(String food){
		@Test
		public void test6() throws Exception{
			Class clazz = Class.forName("com.hcz.reflect.Person");
			Person p = (Person) clazz.newInstance();
			Method m = clazz.getMethod("eat", String.class);
			System.out.println((String) m.invoke(p, "apple"));
		}
		
		// 反射方法:private void pee(){
		@Test
		public void test7() throws Exception{
			Class clazz = Class.forName("com.hcz.reflect.Person");
			Person p = (Person) clazz.newInstance();
			Method m = clazz.getDeclaredMethod("pee");
			m.setAccessible(true);
			m.invoke(p);
		}
		
		// 反射方法:public static void sleep(){
		@Test
		public void test8() throws Exception{
			Class clazz = Class.forName("com.hcz.reflect.Person");
			Method m = clazz.getDeclaredMethod("sleep");
			m.invoke(null);// 静态方法不需要对象，当然传了对象也是可以的
		}
		
		// 反射调用main方法
		@Test
		public void test9() throws Exception{
			Class clazz = Class.forName("com.hcz.reflect.Person");
			Method m = clazz.getMethod("main",String[].class);
			m.invoke(null, (Object)new String[]{"1"});
		}
		
		// 反射字段
		@Test
		public void test10() throws Exception{
			Class clazz = Class.forName("com.hcz.reflect.Person");
			Person p = (Person) clazz.newInstance();
			Field f = clazz.getDeclaredField("name");
			f.setAccessible(true);
			Class type = f.getType();// 获取字段的类型
			if(type.equals(String.class)){
				String name = (String) f.get(p);
				System.out.println(f.get(p));
			}
		}

}
