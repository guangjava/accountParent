package com.guang.diablo2.frame;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkillTree extends JFrame{

	private static final long serialVersionUID = 2988132438910113286L;
	private static Logger logger = LoggerFactory.getLogger(SkillTree.class);
	private static final int data_panel_index = 0;
	private static final int tree_panel_index = 1;
	private static final int data_span_index = 0;
	private static final int tab1_index = 0;
	private static SkillTree instance;
	private static Map<Integer, Image[]> treeBackGroudMap = null;
	public static SkillTree getInstance() {
		try {
			if (instance == null) {
				treeBackGroudMap = new HashMap<>();
				Image[] amaList = new Image[3];
				amaList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.amaBackGround.path")+"1.jpg"));
				amaList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.amaBackGround.path")+"2.jpg"));
				amaList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.amaBackGround.path")+"3.jpg"));
				treeBackGroudMap.put(0, amaList);
				Image[] assList = new Image[3];
				assList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.assBackGround.path")+"1.jpg"));
				assList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.assBackGround.path")+"2.jpg"));
				assList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.assBackGround.path")+"3.jpg"));
				treeBackGroudMap.put(6, assList);
				Image[] barList = new Image[3];
				barList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.barBackGround.path")+"1.jpg"));
				barList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.barBackGround.path")+"2.jpg"));
				barList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.barBackGround.path")+"3.jpg"));
				treeBackGroudMap.put(1, barList);
				Image[] druList = new Image[3];
				druList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.druBackGround.path")+"1.jpg"));
				druList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.druBackGround.path")+"2.jpg"));
				druList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.druBackGround.path")+"3.jpg"));
				treeBackGroudMap.put(5, druList);
				Image[] necList = new Image[3];
				necList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.necBackGround.path")+"1.jpg"));
				necList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.necBackGround.path")+"2.jpg"));
				necList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.necBackGround.path")+"3.jpg"));
				treeBackGroudMap.put(2, necList);
				Image[] palList = new Image[3];
				palList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.palBackGround.path")+"1.jpg"));
				palList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.palBackGround.path")+"2.jpg"));
				palList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.palBackGround.path")+"3.jpg"));
				treeBackGroudMap.put(3, palList);
				Image[] sorList = new Image[3];
				sorList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.sorBackGround.path")+"1.jpg"));
				sorList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.sorBackGround.path")+"2.jpg"));
				sorList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.sorBackGround.path")+"3.jpg"));
				treeBackGroudMap.put(4, sorList);
				instance = new SkillTree();
			}
			instance.setVisible(true);
			return instance;
		} catch (IOException e) {
			logger.error("",e);
			return instance;
		}
	}
	private SkillTree()  {
		try {
			setSize(655, 475);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			addWindowListener(new CloseListener());
			JPanel mainPanel = new JPanel(null);
			setContentPane(mainPanel);
			Image dataBackGround = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.dataBackGround.path")));
			BackGroundPanel dataPanel = new BackGroundPanel(dataBackGround, new FlowLayout());
			mainPanel.add(dataPanel, data_panel_index);
			String text = "<html> <span color:#ff4040> <span color:#00ff00>火焰箭<br></span>在箭矢或弓弹上附带了魔法火焰，<br> 并在打击时增加了火焰的伤害<br> <br> <span color:#00ff00><span color:black>40: </span>火焰箭 由以下技能得到额外加成:<br></span><span color:black>63: </span>爆裂箭: +12% 火焰伤害每一技能等级<br></span></html>";
			SkillSpan dataSpan = new SkillSpan(text); 
			dataPanel.setSize(320, 432);
			dataPanel.add(dataSpan,data_span_index);
			BackGroundPanel skillTreePanel = new BackGroundPanel(null, null);
			mainPanel.add(skillTreePanel, tree_panel_index);
			skillTreePanel.setSize(320, 432);
			skillTreePanel.setLocation(320, 0);
			JPanel tab1 = new JPanel();
			skillTreePanel.add(tab1, tab1_index);
			tab1.setOpaque(false);
			tab1.setSize(85, 96);
			tab1.setLocation(230, 329);
			tab1.add(new SkillSpan("+"));
			tab1.add(new JTextField(2));
			tab1.add(new SkillSpan("点"));
			String tabText1 = "<html>弓和<br>十字弓<br>技能<br>0</html>";
			tab1.add(new SkillSpan(tabText1,12));
			setVisible(true);
		} catch (IOException e) {
			logger.error("",e);
		}
	}
	
	public void init(Option option) {
		setTitle(option.getLable()+"技能树");
		Image[] images = treeBackGroudMap.get(option.getValue());
		if (images!=null && images.length==3) {
			getTreePanel().setImage(images[0]);
		}
	}
	
	public SkillSpan getDataSpan() {
		BackGroundPanel dataPanel = (BackGroundPanel) getContentPane().getComponent(data_panel_index);
		return (SkillSpan) dataPanel.getComponent(data_span_index);
	}
	
	public BackGroundPanel getTreePanel() {
		return (BackGroundPanel) getContentPane().getComponent(tree_panel_index);
	}
	
	private static class CloseListener extends WindowAdapter{

		@Override
		public void windowClosed(WindowEvent e) {
			Form form = Form.getInstance();
			form.setEnable(form.getBody(), true);
			form.getCalc().setEnabled(true);
		}
		
		
	}
}
