package com.guang.yingxiongsha.frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GridDiv extends JPanel{

	private static final long serialVersionUID = 1911861568101754690L;
	private int color;
	private int number;
	private JLabel lable;
	private JCheckBox box;
	GridDiv(int color, int number,String text) {
		super(new GridLayout(2, 1));
		setBorder(new LineBorder(Color.black));
		this.color = color;
		this.number = number;
		lable = new JLabel(text);
		add(lable);
		box = new JCheckBox("在场上");
		add(box);
	}
	
	private static class ClickListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel lable = (JLabel) e.getSource();
			GridDiv div = (GridDiv) lable.getParent();
			if (e.isMetaDown()) {
				if (Form.cardTable[div.color][div.number] == 1) {
					Form.cardTable[div.color][div.number] = 0;
					div.lable.setForeground(Color.red);
					Form.recount(div.color,-1);
				}
			}else {
				if (Form.cardTable[div.color][div.number] == 0) {
					Form.cardTable[div.color][div.number] = 1;
					div.lable.setForeground(Color.black);
					Form.recount(div.color,1);
				}
			}
		}
		
	}

}
