package com.koreait.spring;

public class Speaker {
	private String brand;
	private int maxVoluem;
	private int currentVolume;
	
	public Speaker(String brand, int maxVoluem) {
		super();
		this.brand = brand;
		this.maxVoluem = maxVoluem;
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
