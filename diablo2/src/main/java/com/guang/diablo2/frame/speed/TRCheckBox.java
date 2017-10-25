package com.guang.diablo2.frame.speed;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;

public class TRCheckBox extends JCheckBox{

	private static final long serialVersionUID = -2308842465698143030L;

	public TRCheckBox(String text) {
		super(text);
		setFont(new Font("Helvetica", Font.PLAIN, 15));
		setForeground(new Color(0xd0, 0xcc, 0xd0));
		setBackground(new Color(0x2e, 0x29, 0x27));
	}

}
