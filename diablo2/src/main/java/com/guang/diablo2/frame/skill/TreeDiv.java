package com.guang.diablo2.frame.skill;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.guang.diablo2.entity.skill.AbstractSkill;

public class TreeDiv extends JPanel{
	private static final long serialVersionUID = 353863627090748640L;
	private int skillIndex;
	private Input blvl;
	private Input ilvl;
	public TreeDiv(int i, int j) {
		super(null);
		int x = 0;
		int y = 0;
		switch (i) {
		case 0:
			y = 15;
			break;
		case 1:
			y = 83;
			break;
		case 2:
			y = 151;
			break;
		case 3:
			y = 219;
			break;
		case 4:
			y = 287;
			break;
		case 5:
			y = 355;
			break;
		default:
			break;
		}
		switch (j) {
		case 0:
			x = 15;
			break;
		case 1:
			x = 84;
			break;
		case 2:
			x = 153;
			break;
		default:
			break;
		}
		setOpaque(false);
		setLocation(x, y);
		setSize(67, 67);
		JLabel label = new JLabel();
		add(label);
		label.setOpaque(false);
		label.setSize(48, 48);
		label.addMouseListener(new lableListener());
		blvl = new Input("0",49, 44,Color.white);
		ilvl = new Input("0", 49, 20,Color.green);
		add(blvl);
		add(ilvl);
	}

	public int getSkillIndex() {
		return skillIndex;
	}
	

	public void setSkillIndex(int skillIndex) {
		this.skillIndex = skillIndex;
	}
	

	private static class Input extends JTextField{

		private static final long serialVersionUID = -974840347874498560L;

		private Input(String text,int x,int y,Color color) {
			super(text);
			setBounds(x, y, 18, 20);
			setOpaque(false);
			setBorder(new EmptyBorder(0, 0, 0, 0));
			setForeground(color);
		}
		
	}

	private static class lableListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel lable = (JLabel) e.getSource();
			TreeDiv parent = (TreeDiv) lable.getParent();
			System.out.println("click "+parent.getSkillIndex());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JLabel lable = (JLabel) e.getSource();
			TreeDiv parent = (TreeDiv) lable.getParent();
			SkillTree skillTree = SkillTree.getInstance();
			AbstractSkill skill = skillTree.getSkillCalculator().getSkill(parent.getSkillIndex());
			String text = "<html> <span color=#ff4040> <h2 color=#00ff00>"+skill.getName_zh()+"("+skill.getName_en()+")"+"<br></h2>"+skill.getDescribe()+" </span></html>";
			skillTree.getDataSpan().setText(text);
		}
		
	}
}
