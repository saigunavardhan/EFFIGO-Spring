package com.java.learnSpringFramework.game;

import org.springframework.stereotype.Component;

@Component
public class SupercontraGame implements GamingConsole {

	public void up() {
		System.out.println("S move up");
	}
	
	public void down() {
		System.out.println("S move down");
	}
	
	public void left() {
		System.out.println("S move left");
	}
	
	public void right() {
		System.out.println("S move right");
	}

}
