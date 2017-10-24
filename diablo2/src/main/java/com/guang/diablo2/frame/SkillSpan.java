package com.guang.diablo2.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class SkillSpan extends JLabel{

	private static final long serialVersionUID = -5281496460298779501L;

	public SkillSpan(String text) {
		this(text, 15);
	}
	
	public SkillSpan(String text,int size){
		super(text);
		setFont(new Font("Helvetica", Font.PLAIN, size));
		setForeground(new Color(0xd0, 0xcc, 0xd0));
		setHorizontalAlignment(CENTER);
		setOpaque(false);
	}

}
