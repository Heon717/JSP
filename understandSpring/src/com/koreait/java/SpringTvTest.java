package com.koreait.java;

import com.koreait.spring.LgTv;
import com.koreait.spring.SamsungTv;
import com.koreait.spring.Speaker;
import com.koreait.spring.Tv;

public class SpringTvTest {
	
	// 메인 메소드 - 프로젝트의 시작점
	public static void main(String[] args) {
		Speaker s1 = SpeakerFactory.choiceSpeaker(args[0]);
		Speaker s2 = SpeakerFactory.choiceSpeaker(args[1]);
		
		Tv lgtv = new LgTv(s1);
		Tv samtv = new SamsungTv(s2);
		
		
//		System.out.println(lgtv.toString());
//		System.out.println(samtv.toString());
		
		for(int i=0; i<55; i++) {
			lgtv.VolumeUp();
			samtv.VolumeUp();
		}	
	}
}
