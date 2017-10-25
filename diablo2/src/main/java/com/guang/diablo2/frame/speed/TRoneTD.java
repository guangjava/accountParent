package com.guang.diablo2.frame.speed;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TRoneTD extends JLabel{

	private static final long serialVersionUID = 8770221250574168675L;

	/**
	 * @param text
	 */
	public TRoneTD(String text) {
		super(text);
		setFont(new Font("Helvetica", Font.PLAIN, 15));
		setForeground(new Color(0xd0, 0xcc, 0xd0));
		setBackground(new Color(0x2e, 0x29, 0x27));
		setHorizontalAlignment(LEFT);
		setOpaque(true);
	}

	public TRoneTD(String text,Color color){
		this(text);
		setForeground(color);
	}
}
