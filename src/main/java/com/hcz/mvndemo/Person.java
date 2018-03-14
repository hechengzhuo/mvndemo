package com.hcz.mvndemo;

public class Person {
	private String name;
	private String pwd;
	private String id;
	public void eat(){
		System.out.println("eat！！");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", pwd=" + pwd + ", id=" + id + "]";
	}
}
