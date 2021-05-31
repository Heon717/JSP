package com.koreait.spring;

public class TvTest {
	
	// 메인 메소드 - 프로젝트의 시작점
	public static void main(String[] args) {
		
		Tv lgtv = new LgTv(new AppleSpeaker(40));
		Tv samtv = new SamsungTv(new SonySpeaker(30));
		
		
//		System.out.println(lgtv.toString());
//		System.out.println(samtv.toString());
		
		for(int i=0; i<55; i++) {
			lgtv.VolumeUp();
		}	
	}
}
