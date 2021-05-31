package com.koreait.spring;

// 클래스가 클래스를 상속받을때는 extends   ( class class명 extends class명 )
// 클래스가 인터페이스를 상속받을때는 implements ( class class명 implements interface명) 
public class LgTv extends Tv{
	public LgTv(Speaker speaker) {
		super(speaker,"LG",100,40,50);
	}
}
