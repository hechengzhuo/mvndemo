package com.hcz.reflect;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FanXing {
	
	// 编写一个泛型方法，实现指定位置上的数组元素交换
	public <T> void swap(T array[],int p1,int p2){
		T temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}
	
	// 定义一个泛型方法，接收一个数组，并颠倒数组中的所有元素
	public <T> void reverse(T[] array){
		int start = 0;
		int end = array.length-1;
		while(start<=end){
			T temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		for(T a : array){
			System.out.println(a);
		}
	}
	
	@Test
	public void test(){
		String[] str = new String[]{"a","b","c"};
		Integer[] ints = new Integer[]{1,2,3,4};
		Person p1 = new Person("张三");
		Person p2 = new Person("李四");
		Person p3 = new Person("王五");
		Person[] ps = new Person[]{p1,p2,p3};
		/*reverse(str);*/
		reverse(ints);
		/*reverse(ps);*/
	}

}
