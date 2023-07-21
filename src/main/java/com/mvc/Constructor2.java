package com.mvc;

class Test{
	public String name;
	public int a;
	
	public Test(String name,int a) {
		this.name = name;
		this.a = a;
	}
	
	public void printName() {
		System.out.println("아빠 : " + name + "나이 : " +a);
	}
}

public class Constructor2 extends Test {
	
	public Constructor2(String name){
		super(name,2);
	}
	public void printName() {
		
		super.printName();
		System.out.println("아들 : " + name + "나이 : " +a);
	}
}
 
class Excute{
	public static void main(String[] args) {
		Constructor2 cotr2 = new Constructor2("ddd");
		cotr2.printName();
	}
}
