package com.guang.diablo2.frame;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TabDiv extends JPanel{

	private static final long serialVersionUID = -7722053309299949731L;
	private static final int text_index = 3;
	private SkillSpan text = new SkillSpan(null, 12);
	/**
	 * @param y 纵坐标
	 */
	public TabDiv(int x,int y,int width,int height) {
		setOpaque(false);
		setSize(width, height);
		setLocation(x, y);
		add(new SkillSpan("+"),0);
		add(new JTextField(2),1);
		add(new SkillSpan("点"),2);
		add(text,text_index);
	}
	public String getText() {
		return text.getText();
	}
	public void setStr(String text) {
		this.text.setText(text);
	}
}
