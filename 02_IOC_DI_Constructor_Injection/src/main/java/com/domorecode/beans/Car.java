package com.domorecode.beans;

public class Car {
	private IEngine iEngine;
	public void setIEngine(IEngine iEngine) {
		this.iEngine=iEngine;
	}
	public Car(IEngine iEngine) {
		this.iEngine = iEngine;
	}

	public Car() {
		
	}
	public void drive() {
		int start = iEngine.start();
		if (start == 1) {
			System.out.println("journey started");
		} else {
			System.out.println("failed to started");
		}
	}
}
