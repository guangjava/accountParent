package com.guang.diablo2.frame;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TRone extends JPanel{

	private static final long serialVersionUID = -7414584925087802552L;

	public TRone() {
		setBackground(new Color(0x2e, 0x29, 0x27));
		setAlignmentX(0);
		setBorder(new LineBorder(Color.WHITE));
		setOpaque(true);
	}

	public TRone(int rows,int cols){
		super(new GridLayout(rows, cols));
		setBackground(new Color(0x2e, 0x29, 0x27));
		setAlignmentX(0);
		setBorder(new LineBorder(Color.WHITE));
		setOpaque(true);
	}
}
