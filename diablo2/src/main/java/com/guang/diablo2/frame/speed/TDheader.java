package com.guang.diablo2.frame.speed;

import java.awt.Color;
import java.awt.Font;

public class TDheader extends TRoneTD{

	private static final long serialVersionUID = 8396741788985291247L;

	/**
	 * @param text
	 */
	public TDheader(String text) {
		super(text);
		setFont(new Font("Helvetica", Font.BOLD, 15));
		setBackground(new Color(0x45, 0x07, 0x0e));
		setOpaque(true);
	}

	public TDheader(String text, int width,int height){
		this(text);
		setSize(width, height);
	}
}
