package com.guang.diablo2.frame.speed;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class THheader extends JLabel{

	private static final long serialVersionUID = 8950498372053654501L;

	/**
	 * @param text
	 */
	public THheader(String text) {
		super(text);
		setFont(new Font("Helvetica", Font.BOLD, 15));
		setForeground(new Color(0xd0, 0xcc, 0xd0));
		setBackground(new Color(0x45, 0x07, 0x0e));
		setOpaque(true);
	}

}
