package com.guang.yingxiongsha.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Form extends JFrame{
	private static final long serialVersionUID = 7249980540350307262L;
	private static final String PATH = "yingxiongsha.properties";
	public static Properties properties;
	private static Map<String, Integer> typeCount;
	static {
		properties = new Properties();
		try {
			properties.load(new InputStreamReader(ClassLoader.getSystemResourceAsStream(PATH), "UTF-8"));
		} catch (IOException e) {
		}

	}
	private static JLabel cardCount = new JLabel();
	private static JLabel[] typeLabel;
	private static GridDiv[][] divTable;
	static int[][] cardTable;
	private String[] cardArray; 
	private static String[] typeArray;
	private static int[] colorCount;
	public Form() {
		try {
			initData();
			//主框架
			JPanel mainPanel = new JPanel(new BorderLayout());
			add(mainPanel);
			/***********标题栏**********************/
			setSize(1250, 530);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle(properties.getProperty("title"));
			//设置图标
			Image icon = ImageIO.read(ClassLoader.getSystemResourceAsStream(properties.getProperty("icon.path")));
			setIconImage(icon);
			//花色统计面板
			JPanel top = new JPanel();
			top.add(cardCount);
			cardCount.setText(getColorCountStr());
			JButton reset = new JButton("洗牌");
			reset.addMouseListener(new ResetListener());
			top.add(reset);
			mainPanel.add(top, "North");
			//类型统计面板
			JPanel typePanel = new JPanel(new GridLayout(typeArray.length, 1));
			JScrollPane left = new JScrollPane(typePanel);
			typeLabel = new JLabel[typeArray.length];
			for(int i=0; i<typeArray.length; i++){
				Integer count = typeCount.get(typeArray[i]);
				String text = typeArray[i] + ":" + count;
				typeLabel[i] = new JLabel(text);
				typePanel.add(typeLabel[i]);
			}
			mainPanel.add(left,"West");
			//手牌详情面板
			JPanel body = new JPanel(new GridLayout(4,13));
			JScrollPane scrollPane = new JScrollPane(body);
			mainPanel.add(scrollPane, "Center");
			divTable = new GridDiv[4][13];
			for(int i=0; i<4; i++){
				for(int j=0; j< 13; j++){
					divTable[i][j] = new GridDiv(i, j, cardArray[j*4+i]);
					body.add(divTable[i][j]);
					recount(i, cardArray[j*4+i], 1);
				}
			}
			setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getColorCountStr() {
		return "<html><body><h2>总牌数："+(colorCount[0]+colorCount[1]+colorCount[2]+colorCount[3])+"</h2> ♠："+colorCount[0]+" <span color=red>♥："+colorCount[1]+"</span> ♣："+colorCount[2]+" <span color=red>♦："+colorCount[3]+"</span></body></html>";
	}
	private void initData() {
		colorCount = new int[4];
		for(int i=0; i<4; i++){
			colorCount[i] = 0;
		}
		String cardNameStr = properties.getProperty("table");
		cardArray = cardNameStr.split(",");
		cardTable = new int[4][13];
		for(int i=0; i<4; i++){
			for(int j=0; j<13; j++){
				cardTable[i][j] = 1;
			}
		}
		String typeStr = properties.getProperty("type");
		typeArray = typeStr.split(",");
		typeCount = new HashMap<>();
		for(String type : typeArray){
			typeCount.put(type, 0);
		}
	}

	public static void main(String[] args) {
		new Form();
	}
	public static void recount(int color, String name, int num) {
		colorCount[color]+=num;
		cardCount.setText(getColorCountStr());
		for(int i=0; i<typeArray.length; i++){
			if (name.contains(typeArray[i])) {
				Integer count = typeCount.get(typeArray[i]);
				count+=num;
				typeCount.put(typeArray[i],count);
				String text = typeArray[i] + ":" + count;
				typeLabel[i].setText(text);
				if (count == 0) {
					typeLabel[i].setForeground(Color.red);
				}else {
					typeLabel[i].setForeground(Color.black);
				}
				return;
			}
		}
	}
	
	private static class ResetListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			for(int i=0; i<4; i++){
				for(int j=0; j<13; j++){
					if(Form.cardTable[i][j] == 0){
						Form.cardTable[i][j] = 1;
						GridDiv div = Form.divTable[i][j];
						div.lable.setForeground(Color.black);
						div.box.setEnabled(true);
						div.box.setSelected(false);
						Form.recount(i,div.lable.getText(),1);
					}
				}
			}
		}
		
	}
}
