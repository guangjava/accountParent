package com.guang.diablo2.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ResetLable extends JLabel{

	private static final long serialVersionUID = 3519824614313425072L;
	public ResetLable(int x,int y,int width,int height){
		setSize(width, height);
		setLocation(x, y);
		addMouseListener(new SkillResetListener());
	}
	
	private static class SkillResetListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ResetLable source = (ResetLable) e.getSource();
			if (source.isEnabled()) {
				System.out.println("a");
			}
		}
	}
}
