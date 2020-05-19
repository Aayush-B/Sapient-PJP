package com.aayush.SpringAssignment;

public class Mobile {
	private Camera camera ;
	private Speaker speaker ;
	private Screen screen ;
	
	public Mobile(Speaker speaker, Screen screen) {
		super();
		this.speaker = speaker;
		this.screen = screen;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	public Speaker getSpeaker() {
		return speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public Screen getScreen() {
		return screen;
	}
	
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
}
