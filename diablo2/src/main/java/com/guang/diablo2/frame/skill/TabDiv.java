package com.guang.diablo2.frame.skill;

import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guang.diablo2.entity.base.Character;
import com.guang.diablo2.frame.speed.Form;

public class TabDiv extends JPanel{

	private static final long serialVersionUID = -7722053309299949731L;
	private int index;
	private String name = "";
	private int skillSum = 0;
	private SkillSpan text = new SkillSpan(null, 12);
	private JTextField plusLevel;
	/**
	 * @param y 纵坐标
	 */
	public TabDiv(int index,int x,int y,int width,int height) {
		this.index = index;
		if (index < 3) {
			addMouseListener(new TabListener());
		}
		setOpaque(false);
		setSize(width, height);
		setLocation(x, y);
		SkillSpan span = new SkillSpan("+");
		span.addMouseListener(new PlusLevelClickListener());
		span.addKeyListener(new PlusLevelKeyListener());
		add(span);
		plusLevel = new JTextField(2);
		plusLevel.getDocument().addDocumentListener(new PlusLevelInputListener(index));
		add(plusLevel);
		add(new SkillSpan("点"));
		add(text);
	}
	public String getText() {
		return text.getText();
	}
	
	public TabDiv setTabName(String tabName) {
		this.name = tabName;
		text.setText("<html>" + tabName + "<br>"+skillSum+"</html>");
		return this;
	}
	
	public TabDiv setSkillSum(int skillSum){
		this.skillSum = skillSum;
		text.setText("<html>" + name + "<br>"+skillSum+"</html>");
		return this;
	}
	
	public void setSkillPlus(int skillPlus) {
		plusLevel.setText(skillPlus+"");
	}
	
	private static class TabListener extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			TabDiv tab = (TabDiv) e.getSource();
			SkillTree.getInstance().showTab(tab.index);
		}
		
	}
	
	private static class PlusLevelInputListener implements DocumentListener{
		private static final Logger logger = LoggerFactory.getLogger(PlusLevelInputListener.class);
		private int id;
		
		public PlusLevelInputListener(int id) {
			super();
			this.id = id;
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
				if (id == 3) {
					character.setCharPlusSKillLevel(value);
				}else {
					character.setTabPlusSkillLevel(id, value);
				}
			} catch (Exception e1) {
				logger.error("",e1);
			}
		}
	}
	
	private static class PlusLevelClickListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			SkillSpan span = (SkillSpan) e.getSource();
			if (span.isF1_down()) {//不起作用
				plus(e, 0);
			}else if (span.isF2_down()) {
				plus(e, 1);
			}else if (span.isF3_down()) {
				plus(e, 2);
			}else {
				Character character = Form.getInstance().getSpeedCalculator().getCharacter();
				int plusSkillLevel = character.getCharPlusSKillLevel();
				TabDiv tabDiv = (TabDiv) span.getParent();
				//左键
				if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
					tabDiv.setSkillPlus(plusSkillLevel+1);
				}
				//右键
				if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
					if (plusSkillLevel > 0) {
						tabDiv.setSkillPlus(plusSkillLevel-1);
					}
				}
			}
		}

		private void plus(MouseEvent e,int n) {
			Character character = Form.getInstance().getSpeedCalculator().getCharacter();
			SkillTree skillTree = SkillTree.getInstance();
			int tabPlusSkillLevel = character.getTabPlusSkillLevel(n);
			TabDiv tabDiv = (TabDiv) skillTree.getTab(0);
			//左键
			if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
				tabDiv.setSkillPlus(tabPlusSkillLevel+1);
			}
			//右键
			if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
				if (tabPlusSkillLevel > 0) {
					tabDiv.setSkillPlus(tabPlusSkillLevel-1);
				}
			}
		}
		
	}
	
	private static class PlusLevelKeyListener extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			SkillSpan span = (SkillSpan) e.getSource();
			switch (e.getKeyCode()) {
			case KeyEvent.VK_F1:
				span.setF1_down(true);
				System.out.println("f1");
				break;
			case KeyEvent.VK_F2:
				span.setF2_down(true);
				System.out.println("f2");
				break;
			case KeyEvent.VK_F3:
				span.setF3_down(true);
				System.out.println("f3");
				break;
			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			SkillSpan span = (SkillSpan) e.getSource();
			switch (e.getKeyCode()) {
			case KeyEvent.VK_F1:
				span.setF1_down(false);
				System.out.println(false);
				break;
			case KeyEvent.VK_F2:
				span.setF2_down(false);
				System.out.println(false);
				break;
			case KeyEvent.VK_F3:
				span.setF3_down(false);
				System.out.println(false);
				break;
			default:
				break;
			}
		}
		
	}
}
