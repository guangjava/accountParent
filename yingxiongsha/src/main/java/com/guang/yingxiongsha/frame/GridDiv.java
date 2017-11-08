package com.guang.yingxiongsha.frame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
	JLabel lable;
	JCheckBox box;
	GridDiv(int color, int number,String text) {
		super(new GridLayout(2, 1));
		setBorder(new LineBorder(Color.black));
		this.color = color;
		this.number = number;
		lable = new JLabel(text);
		lable.addMouseListener(new ClickListener());
		add(lable);
		box = new JCheckBox("在场上");
		box.addItemListener(new BoxListener());
		add(box);
	}
	
	private static class ClickListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel lable = (JLabel) e.getSource();
			GridDiv div = (GridDiv) lable.getParent();
			if (e.isMetaDown()) {
				if (Form.cardTable[div.color][div.number] <= 0) {
					Form.cardTable[div.color][div.number] = 1;
					div.lable.setForeground(Color.black);
					div.box.setEnabled(true);
					div.box.setSelected(false);
					Form.recount(div.color,lable.getText(),1);
				}
			}else {
				if (Form.cardTable[div.color][div.number] == 1) {
					Form.cardTable[div.color][div.number] = 0;
					div.lable.setForeground(Color.red);
					div.box.setEnabled(false);
					div.box.setSelected(false);
					Form.recount(div.color,lable.getText(),-1);
				}else if (Form.cardTable[div.color][div.number] == -1) {
					Form.cardTable[div.color][div.number] = 0;
					div.lable.setForeground(Color.red);
					div.box.setEnabled(false);
					div.box.setSelected(false);
				}
			}
		}
		
	}
	
	private static class BoxListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox box = (JCheckBox) e.getSource();
			GridDiv div = (GridDiv) box.getParent();
			if (box.isEnabled() && box.isSelected()) {
				if (Form.cardTable[div.color][div.number] == 1) {
					box.setForeground(Color.blue);
					Form.cardTable[div.color][div.number] = -1;
					Form.recount(div.color,div.lable.getText(),-1);
				}
			}else if (!box.isSelected()) {
				box.setForeground(Color.black);
				if (Form.cardTable[div.color][div.number] == -1) {
					Form.cardTable[div.color][div.number] = 0;
					div.lable.setForeground(Color.red);
					div.box.setEnabled(false);
				}
			}
		}
		
	}

}
