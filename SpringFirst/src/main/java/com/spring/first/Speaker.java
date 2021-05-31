package com.spring.first;

public class Speaker {
	private String brand;
	private int maxVoluem;
	private int currentVolume;
	
	public Speaker(String brand, int maxVoluem) {
		super();
		this.brand = brand;
		this.maxVoluem = maxVoluem;
		System.out.printf("-- %s 스피커 생성 --",this.brand);
	}
	
	public String getBrand() {
		return brand;
	}

	public int getMaxVoluem() {
		return maxVoluem;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void volumeUp() {
		if(currentVolume < maxVoluem) {
			currentVolume++;
		}
		System.out.printf("%s - speaker : %d\n",brand,currentVolume);
	}
	
	public void volumeDown() {
		if(currentVolume > 0) {
			currentVolume--;
		}
		System.out.printf("%s - speaker : %d\n",brand,currentVolume);
	}
}
