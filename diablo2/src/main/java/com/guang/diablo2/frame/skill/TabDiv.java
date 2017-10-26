package com.guang.diablo2.frame.skill;

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
	private static final int text_index = 3;
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
		add(new SkillSpan("+"),0);
		plusLevel = new JTextField(2);
		plusLevel.getDocument().addDocumentListener(new PlusLevelListener(index));
		add(plusLevel,1);
		add(new SkillSpan("点"),2);
		add(text,text_index);
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
	
	private static class TabListener extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			TabDiv tab = (TabDiv) e.getSource();
			SkillTree.getInstance().showTab(tab.index);
		}
		
	}
	
	private static class PlusLevelListener implements DocumentListener{
		private static final Logger logger = LoggerFactory.getLogger(PlusLevelListener.class);
		private int id;
		
		public PlusLevelListener(int id) {
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
}
