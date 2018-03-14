package com.hcz.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestIntrospector {
	// bean的所有属性
	@Test
	public void test1() throws Exception{
		BeanInfo info = Introspector.getBeanInfo(Person.class);// 得到自己+父类的属性
		BeanInfo info1 = Introspector.getBeanInfo(Person.class,Object.class);// 得到自己的属性
		 PropertyDescriptor[] pds = info.getPropertyDescriptors();
		 for(PropertyDescriptor pd : pds){
			 System.out.println(pd.getName());
		 }
	}
	
		// 操作bean的指定属性 
		@Test
		public void test2() throws Exception{
			Person p = new Person();
			PropertyDescriptor pd = new PropertyDescriptor("name", Person.class);
			Method m = pd.getWriteMethod();
			m.invoke(p, "王五");
			m = pd.getReadMethod();
			String name = (String) m.invoke(p);
			System.out.println(name);
		}
		
		// 获取属性的类型
		@Test
		public void test3() throws IntrospectionException{
			Person p = new Person();
			PropertyDescriptor pd = new PropertyDescriptor("height", Person.class);
			System.out.println(pd.getPropertyType());
		}
}
