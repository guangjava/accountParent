package com.guang.diablo2.frame.skill;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class SkillSpan extends JLabel{

	private static final long serialVersionUID = -5281496460298779501L;
	private boolean f1_down = false;
	private boolean f2_down = false;
	private boolean f3_down = false;
	public SkillSpan(String text) {
		this(text, 15);
	}
	
	public SkillSpan(String text,int size){
		super(text,null,CENTER);
		setFont(new Font("Helvetica", Font.PLAIN, size));
		setForeground(new Color(0xd0, 0xcc, 0xd0));
		setOpaque(false);
	}

	public boolean isF1_down() {
		return f1_down;
	}
	
	public void setF1_down(boolean f1_down) {
		this.f1_down = f1_down;
	}

	public boolean isF2_down() {
		return f2_down;
	}
	
	public void setF2_down(boolean f2_down) {
		this.f2_down = f2_down;
	}
	
	public boolean isF3_down() {
		return f3_down;
	}

	public void setF3_down(boolean f3_down) {
		this.f3_down = f3_down;
	}
	
}
