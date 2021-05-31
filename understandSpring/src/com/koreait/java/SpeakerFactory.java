package com.koreait.java;

import com.koreait.spring.AppleSpeaker;
import com.koreait.spring.SonySpeaker;
import com.koreait.spring.Speaker;

public class SpeakerFactory {
	public static Speaker choiceSpeaker(String brand) {
		switch(brand) {
		case "apple":
			return new AppleSpeaker(30);
		case "sony":
			return new SonySpeaker(40);
		}
		return null;
	}
}
