package com.mvc;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class Constructor {
	int num;
	
	public Constructor(){	
		System.out.println(num);
	}
	
	public Constructor(int num){
		this.num = num;
		System.out.println(num);
	}
	

	void test() {
		System.out.println("바로 머리에 저장댐");
	}
	
}

class Execute{
	
	public static void main(String[] args) {
		Constructor c = new Constructor(100);
		System.out.println(c.num);
	}
}