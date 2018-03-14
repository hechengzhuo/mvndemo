package com.hcz.reflect;

public class Person {
	private String name = "hcz";
	private int height;

	public Person() {
	}
	
	public Person(String name){
		this.name = name;
	}
	
	private Person(String name,int height){
		this.name = name;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void eat(){
		System.out.println("eating");
	}
	
	public String eat(String food){
		return "eat-->"+food;
	}
	
	private void pee(){
		System.out.println("尿尿");
	}
	
	public static void sleep(){
		System.out.println("睡觉");
	}
	
	public static void main(String[] args) {
		System.out.println("main");
	}
}
