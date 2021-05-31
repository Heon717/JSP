package com.koreait.spring;

	// 메소드
public abstract class Tv {
	private Speaker speaker;
	private String brand;
	private int inch;
	private int maxChannel;
	private int maxVolume;
	private int currentChannel;
	private int currentVolume;

	// super. 는 부모클래스의 멤버변수를 참조할때 사용. (부모의 기본생성자 호출)
	// this. 는 현재클래스의 멤버변수를 지정할때 사용. 사용방법은 똑같음 () 괄호가 들어가면 무조건 생성자
	// super() 부모클래스의 생성자 호출   this. 현재클래스의 다른생성자 호출
	
	// 생성자 ( 메소드와 다른점 ) 
	// 1. 리턴타입이 없다.	 2. 클래스명과 이름이 같다
	// 생성자는 오버로딩 가능
	// 생성자가 하나도 없을때 컴파일러가 자동으로 만들어줌.
	protected Tv(Speaker speaker, String brand, int inch, int maxChannel, int maxVolume) {
		super();
		this.speaker = speaker;
		this.brand = brand;
		this.inch = inch;
		this.maxChannel = maxChannel;
		this.maxVolume = maxVolume;
		this.currentChannel = 1;
	}

	public String getBrand() {
		return brand;
	}

	public int getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	public int getInch() {
		return inch;
	}

	public int getMaxChannel() {
		return maxChannel;
	}

	public int getMaxVolume() {
		return maxVolume;
	}
	
	public void ChannleUp() {
		if(this.currentChannel == this.maxChannel) {
			this.currentChannel = 1;
		} else {
			currentChannel +=1;
		}	
		System.out.println("currentChannel : " + currentChannel);
	}
	
	public void ChannleDown() {
		if(this.currentChannel == 1) {
			this.currentChannel = this.maxChannel;
		} else {
			currentChannel -=1; 
		}
		System.out.println("currentChannel : " + currentChannel);
	}
	
	public void VolumeUp() {
		if(currentVolume < maxVolume) {
			currentVolume++;
			speaker.volumeUp();
		}
		System.out.println("currentVolume : " + currentVolume);
	}
	
	public void VolumeDown() {
		if(currentVolume > 0) {
			currentVolume--;
			speaker.volumeDown();
		}
		System.out.println("currentVolume : " + currentVolume);
	}
	
	public String toString() {
		return String.format("%s, %d인치, %d채널, %d볼륨", brand,inch,maxChannel,maxVolume);
	}
	
	
}
