package com.guang.diablo2.frame.skill;

import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guang.diablo2.calculator.SkillCalculator;
import com.guang.diablo2.entity.base.Character;
import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.frame.speed.Form;

public class TreeDiv extends JPanel{
	private static final long serialVersionUID = 353863627090748640L;
	private static LableListener lablelListener = new LableListener();
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
		label.addMouseListener(lablelListener);
		blvl = new Input("0",49, 44,Color.white);
		DocumentListener blvlListener = new InputListener(InputListener.blvl_id, i,j);
		blvl.getDocument().addDocumentListener(blvlListener);
		ilvl = new Input("0", 49, 20,Color.green);
		DocumentListener ilvlListener = new InputListener(InputListener.ilvl_id, i,j);
		ilvl.getDocument().addDocumentListener(ilvlListener);
		add(blvl);
		add(ilvl);
	}
	
	public void refresh() {
		Character character = Form.getInstance().getSpeedCalculator().getCharacter();
		int basicSkillLevel = character.getBasicSkillLevel(skillIndex);
		int plusSkillLevel = character.getPlusSkillLevel(skillIndex);
		blvl.setText(basicSkillLevel+"");
		ilvl.setText(plusSkillLevel+"");
	}

	public int getSkillIndex() {
		return skillIndex;
	}

	public void setSkillIndex(int skillIndex) {
		this.skillIndex = skillIndex;
	}

	public Input getBlvl() {
		return blvl;
	}

	public Input getIlvl() {
		return ilvl;
	}
	
	public void setBlvlText(String text) {
		blvl.setText(text);
	}
	
	public void setIlvlText(String text) {
		ilvl.setText(text);
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

	private static class LableListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel lable = (JLabel) e.getSource();
			TreeDiv parent = (TreeDiv) lable.getParent();
			Character character = Form.getInstance().getSpeedCalculator().getCharacter();
			int basicSkillLevel = character.getBasicSkillLevel(parent.getSkillIndex());
			int plusSkillLevel = character.getPlusSkillLevel(parent.getSkillIndex());
			//左键
			if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
				if (e.isAltDown()) {
					parent.getIlvl().setText(plusSkillLevel+1+"");
				}else if (e.isShiftDown()) {
					parent.getBlvl().setText(basicSkillLevel+5+"");
				}else {
					parent.getBlvl().setText(basicSkillLevel+1+"");
				}
			}
			//右键
			if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
				
				if (basicSkillLevel > 0) {
					 if (e.isShiftDown()) {
						parent.getBlvl().setText(basicSkillLevel - 5 + "");
					}else {
						parent.getBlvl().setText(basicSkillLevel - 1 + "");
					}
				}
				if (plusSkillLevel>0 && e.isAltDown()) {
					parent.getIlvl().setText(plusSkillLevel-1+"");
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JLabel lable = (JLabel) e.getSource();
			TreeDiv parent = (TreeDiv) lable.getParent();
			SkillTree skillTree = SkillTree.getInstance();
			int skillId = parent.getSkillIndex();
			skillTree.showData(skillId);
		}
		
	}
	
	private static class InputListener implements DocumentListener{
		private static final Logger logger = LoggerFactory.getLogger(InputListener.class);
		static final int blvl_id = 0;
		static final int ilvl_id = 1;
		private int id;
		private int x;
		private int y;
		
		/**
		 * @param id 0-blvl 1-ilvl
		 * @param x 表格横坐标
		 */
		private InputListener(int id,int x,int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			update(e);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			update(e);
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			update(e);
			
		}

		private void update(DocumentEvent e) {
			try {
				//获取内容
				Character character = Form.getInstance().getSpeedCalculator().getCharacter();
				Document document = e.getDocument();
				String text = document.getText(0, document.getLength());
				int value = 0;
				if (text!=null && !text.trim().equals("")) {
					value = Integer.parseInt(text);
				}
				//更新数据
				final SkillTree skillTree = SkillTree.getInstance();
				Integer[] treeDivTable = skillTree.getTabTreeDiv();
				int skillId = treeDivTable[x*3+y]; 
				if (id == blvl_id) {
					boolean result = character.setBasicSkillLevel(skillId, value);
					if (!result) {
						showError( skillId);
						return;
					}
				}else if (id == ilvl_id) {
					character.setPlusSkillLevel(skillId, value);
				}
				//进行展示 
				skillTree.showData(skillId);
				//数据求和
				int tabIndex = skillTree.getTabIndex();
				int tabSum = character.getBasicSkillLevelTabSum(tabIndex);
				skillTree.getTab(tabIndex).setSkillSum(tabSum);
				int basicSkillLevelSum = character.getBasicSkillLevelSum();
				skillTree.getTab4().setSkillSum(basicSkillLevelSum);
			} catch (Exception e1) {
				logger.error("",e1);
			}
		}

		private void showError( int skillId) {
			SkillTree skillTree = SkillTree.getInstance();
			StringBuilder sb = new StringBuilder();
			AbstractSkill skill = SkillCalculator.getSkill(skillId);
			sb.append("<html><span>").append(skill.getName_zh()).append("(")
			.append(skill.getName_en()).append(")升级失败<br>")
			.append("需要先学习以下技能:<br>");
			int[] requiredSkills = skill.getRequiredSkill();
			for (int required : requiredSkills) {
				if (required > 0) {
					AbstractSkill requiredskill = SkillCalculator.getSkill(required);
					sb.append("<li>").append(requiredskill.getName_zh()).append("(")
					.append(requiredskill.getName_en()).append(")</li>");
				}
			}
			sb.append("</span></html>");
			new ErrorDialog(skillTree, "技能升级失败",sb.toString(), true);
		}

	}
}
