package com.guang.diablo2.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class BackGroundPanel extends JPanel{

	private static final long serialVersionUID = -109731327304084565L;
	private Image image;
	public BackGroundPanel(Image image,LayoutManager layout) {
		super(layout);
		this.image = image;
	}
	
	
	public Image getImage() {
		return image;
	}
	


	public void setImage(Image image) {
		this.image = image;
	}
	


	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);  
	}
	
}
