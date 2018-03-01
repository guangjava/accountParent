package com.guang.diablo2;

import com.guang.diablo2.frame.speed.Form;

public class Main {
	public static void main(String[] args) {
		Runnable run = new Runnable() {
			public void run() {
				Form.getInstance();
			}
		};
		new Thread(run).start();
	}
}
