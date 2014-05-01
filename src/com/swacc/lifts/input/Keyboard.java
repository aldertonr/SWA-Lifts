package com.swacc.lifts.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	public void keyTyped(KeyEvent Keys) {
		System.out.println("KEY: " + Keys);
	}

	public void keyPressed(KeyEvent Keys) {
		System.out.println("KEY: " + Keys);
	}

	public void keyReleased(KeyEvent Keys) {
		System.out.println("KEY: " + Keys);
	}

	
	
}
