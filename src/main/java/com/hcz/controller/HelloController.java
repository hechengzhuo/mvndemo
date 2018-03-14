package com.hcz.controller;


import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcz.mvndemo.Person;


@Controller
public class HelloController{
	
	@Test
	public void wrapper1() {
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
    }
	
	/**
	 * 简单的说，如果整型字面量的值在-128到127之间，
	 * 那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，
	 * 所以下面的面试题中f1==f2的结果是true，而f3==f4的结果是false
	 */
	@Test
	public void wrapper2() {
		 Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
	        System.out.println(f1 == f2);
	        System.out.println(f3 == f4);
	        System.out.println((double)(2>>3));
    }
	
	public static void swap(Person p) {
		p.setName("AAA");
	}

	@Test
	public void param() {
		Person p = new Person();
		p.setName("BBB");
		swap (p);
		System.out.println(p.getName());
		}
	
	@Test
	public void test(){
		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program" + "ming";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s1.intern());
	}

	@RequestMapping("/hello")
	public String hello(String name,ModelMap model){
		model.addAttribute("name",name);
		System.out.println(name);
		return "index.jsp";
	}
	
	@RequestMapping("/person")
	public String getPerson(Person p){
		System.out.println(p.toString());
		return "index.jsp";
	}
	
	@RequestMapping("/interceptor")
	public String interceptor(){
		System.out.println("-------处理中、。。-------");
		return "index.jsp";
	}
}
