package com.guang.yingxiongsha.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Form extends JFrame{
	private static final long serialVersionUID = 7249980540350307262L;
	private static final String PATH = "yingxiongsha.properties";
	public static Properties properties;
	static {
		properties = new Properties();
		try {
			properties.load(new InputStreamReader(ClassLoader.getSystemResourceAsStream(PATH), "UTF-8"));
		} catch (IOException e) {
		}

	}
	private static JLabel cardCount = new JLabel();
	private GridDiv[][] divTable;
	static int[][] cardTable;
	private String[] cardArray; 
	private int[] colorCount;
	public Form() {
		initData();
		//主框架
		JPanel mainPanel = new JPanel(new BorderLayout());
		add(mainPanel);
		/***********标题栏**********************/
		setSize(1250, 530);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(properties.getProperty("title"));
		JPanel top = new JPanel();
		top.add(cardCount);
		cardCount.setText("<html><body><h2>总牌数：52</h2> ♠：13 <span color=red>♥：13</span> ♣：13 <span color=red>♦：13</span></body></html>");
		JButton reset = new JButton("洗牌");
		top.add(reset);
		mainPanel.add(top, "North");
		JPanel body = new JPanel(new GridLayout(4,13));
		JScrollPane scrollPane = new JScrollPane(body);
		mainPanel.add(scrollPane, "Center");
		divTable = new GridDiv[4][13];
		for(int i=0; i<4; i++){
			for(int j=0; j< 13; j++){
				divTable[i][j] = new GridDiv(i, j, cardArray[j*4+i]);
				body.add(divTable[i][j]);
			}
		}
		setVisible(true);
	}
	private void initData() {
		String cardNameStr = properties.getProperty("table");
		cardArray = cardNameStr.split(",");
		cardTable = new int[4][13];
		for(int i=0; i<4; i++){
			for(int j=0; j<13; j++){
				cardTable[i][j] = 1;
			}
		}
		
	}

	public static void main(String[] args) {
		new Form();
	}
	public static void recount(int color, int i) {
		// TODO Auto-generated method stub
		
	}
}
