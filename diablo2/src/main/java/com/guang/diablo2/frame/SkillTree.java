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
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guang.diablo2.entity.Character;
import com.guang.diablo2.frame.base.Util;

public class SkillTree extends JFrame{

	private static final long serialVersionUID = 2988132438910113286L;
	private static Logger logger = LoggerFactory.getLogger(SkillTree.class);
	private static final int data_panel_index = 0;
	private static final int tree_panel_index = 1;
	private static final int data_span_index = 0;
	private static final int tab1_index = 0;
	private static final int tab2_index = 1;
	private static final int tab3_index = 2;
	private static SkillTree instance;
	private static Map<Integer, Image[]> treeBackGroudMap = null;
	private static Map<Integer, String[]> tabNameMap = null;
	private static Map<Integer, Integer[]> tabCloseMap = null;
	private static Map<Integer, Integer[][]> treeDivMap = null;
	public static SkillTree getInstance() {
		try {
			if (instance == null) {
				initTreeBackGroundMap();
				initTabNameMap();
				initTabCloseMap();
				initTreeDivMap();
				instance = new SkillTree();
			}
			instance.setVisible(true);
			return instance;
		} catch (IOException e) {
			logger.error("",e);
			return instance;
		}
	}

	private static void initTreeBackGroundMap() throws IOException {
		treeBackGroudMap = new HashMap<>();
		Image[] amaList = new Image[3];
		amaList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.amaBackGround.path")+"1.jpg"));
		amaList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.amaBackGround.path")+"2.jpg"));
		amaList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.amaBackGround.path")+"3.jpg"));
		treeBackGroudMap.put(Character.CHAR_AMA, amaList);
		Image[] assList = new Image[3];
		assList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.assBackGround.path")+"1.jpg"));
		assList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.assBackGround.path")+"2.jpg"));
		assList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.assBackGround.path")+"3.jpg"));
		treeBackGroudMap.put(Character.CHAR_ASN, assList);
		Image[] barList = new Image[3];
		barList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.barBackGround.path")+"1.jpg"));
		barList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.barBackGround.path")+"2.jpg"));
		barList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.barBackGround.path")+"3.jpg"));
		treeBackGroudMap.put(Character.CHAR_BAR, barList);
		Image[] druList = new Image[3];
		druList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.druBackGround.path")+"1.jpg"));
		druList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.druBackGround.path")+"2.jpg"));
		druList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.druBackGround.path")+"3.jpg"));
		treeBackGroudMap.put(Character.CHAR_DRU, druList);
		Image[] necList = new Image[3];
		necList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.necBackGround.path")+"1.jpg"));
		necList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.necBackGround.path")+"2.jpg"));
		necList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.necBackGround.path")+"3.jpg"));
		treeBackGroudMap.put(Character.CHAR_NEC, necList);
		Image[] palList = new Image[3];
		palList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.palBackGround.path")+"1.jpg"));
		palList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.palBackGround.path")+"2.jpg"));
		palList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.palBackGround.path")+"3.jpg"));
		treeBackGroudMap.put(Character.CHAR_PAL, palList);
		Image[] sorList = new Image[3];
		sorList[0] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.sorBackGround.path")+"1.jpg"));
		sorList[1] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.sorBackGround.path")+"2.jpg"));
		sorList[2] = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.sorBackGround.path")+"3.jpg"));
		treeBackGroudMap.put(Character.CHAR_SOR, sorList);
	}
	
	private static void initTabNameMap() {
		tabNameMap = new HashMap<Integer, String[]>();
		String[] amaList = new String[4];
		amaList[0] = Form.properties.getProperty("skillTree.ama.tab1.name");
		amaList[1] = Form.properties.getProperty("skillTree.ama.tab2.name");
		amaList[2] = Form.properties.getProperty("skillTree.ama.tab3.name");
		amaList[3] = Form.properties.getProperty("skillTree.ama.tab4.name");
		tabNameMap.put(Character.CHAR_AMA, amaList);
		String[] assList = new String[4];
		assList[0] = Form.properties.getProperty("skillTree.ass.tab1.name");
		assList[1] = Form.properties.getProperty("skillTree.ass.tab2.name");
		assList[2] = Form.properties.getProperty("skillTree.ass.tab3.name");
		assList[3] = Form.properties.getProperty("skillTree.ass.tab4.name");
		tabNameMap.put(Character.CHAR_ASN, assList);
		String[] barList = new String[4];
		barList[0] = Form.properties.getProperty("skillTree.bar.tab1.name");
		barList[1] = Form.properties.getProperty("skillTree.bar.tab2.name");
		barList[2] = Form.properties.getProperty("skillTree.bar.tab3.name");
		barList[3] = Form.properties.getProperty("skillTree.bar.tab4.name");
		tabNameMap.put(Character.CHAR_BAR, barList);
		String[] druList = new String[4];
		druList[0] = Form.properties.getProperty("skillTree.dru.tab1.name");
		druList[1] = Form.properties.getProperty("skillTree.dru.tab2.name");
		druList[2] = Form.properties.getProperty("skillTree.dru.tab3.name");
		druList[3] = Form.properties.getProperty("skillTree.dru.tab4.name");
		tabNameMap.put(Character.CHAR_DRU, druList);
		String[] necList = new String[4];
		necList[0] = Form.properties.getProperty("skillTree.nec.tab1.name");
		necList[1] = Form.properties.getProperty("skillTree.nec.tab2.name");
		necList[2] = Form.properties.getProperty("skillTree.nec.tab3.name");
		necList[3] = Form.properties.getProperty("skillTree.nec.tab4.name");
		tabNameMap.put(Character.CHAR_NEC, necList);
		String[] palList = new String[4];
		palList[0] = Form.properties.getProperty("skillTree.pal.tab1.name");
		palList[1] = Form.properties.getProperty("skillTree.pal.tab2.name");
		palList[2] = Form.properties.getProperty("skillTree.pal.tab3.name");
		palList[3] = Form.properties.getProperty("skillTree.pal.tab4.name");
		tabNameMap.put(Character.CHAR_PAL, palList);
		String[] sorList = new String[4];
		sorList[0] = Form.properties.getProperty("skillTree.sor.tab1.name");
		sorList[1] = Form.properties.getProperty("skillTree.sor.tab2.name");
		sorList[2] = Form.properties.getProperty("skillTree.sor.tab3.name");
		sorList[3] = Form.properties.getProperty("skillTree.sor.tab4.name");
		tabNameMap.put(Character.CHAR_SOR, sorList);
	}
	
	private static void initTabCloseMap() {
		tabCloseMap = new HashMap<Integer, Integer[]>();
		String[] amaList = new String[3];
		Integer[] amaIntegers = new Integer[3];
		String amaClose = Form.properties.getProperty("skillTree.ama.tab.close");
		amaList = amaClose.split(",");
		amaIntegers[0] = Integer.parseInt(amaList[0]);
		amaIntegers[1] = Integer.parseInt(amaList[1]);
		amaIntegers[2] = Integer.parseInt(amaList[2]);
		tabCloseMap.put(Character.CHAR_AMA, amaIntegers);
		String[] assList = new String[3];
		Integer[] assIntegers = new Integer[3];
		assList = Form.properties.getProperty("skillTree.ass.tab.close").split(",");
		assIntegers[0] = Integer.parseInt(assList[0]);
		assIntegers[1] = Integer.parseInt(assList[1]);
		assIntegers[2] = Integer.parseInt(assList[2]);
		tabCloseMap.put(Character.CHAR_ASN, assIntegers);
		String[] barList = new String[3];
		Integer[] barIntegers = new Integer[3];
		barList = Form.properties.getProperty("skillTree.bar.tab.close").split(",");
		barIntegers[0] = Integer.parseInt(barList[0]);
		barIntegers[1] = Integer.parseInt(barList[1]);
		barIntegers[2] = Integer.parseInt(barList[2]);
		tabCloseMap.put(Character.CHAR_BAR, barIntegers);
		String[] druList = new String[3];
		Integer[] druIntegers = new Integer[3];
		druList = Form.properties.getProperty("skillTree.dru.tab.close").split(",");
		druIntegers[0] = Integer.parseInt(druList[0]);
		druIntegers[1] = Integer.parseInt(druList[1]);
		druIntegers[2] = Integer.parseInt(druList[2]);
		tabCloseMap.put(Character.CHAR_DRU, druIntegers);
		String[] necList = new String[3];
		Integer[] necIntegers = new Integer[3];
		necList = Form.properties.getProperty("skillTree.nec.tab.close").split(",");
		necIntegers[0] = Integer.parseInt(necList[0]);
		necIntegers[1] = Integer.parseInt(necList[1]);
		necIntegers[2] = Integer.parseInt(necList[2]);
		tabCloseMap.put(Character.CHAR_NEC, necIntegers);
		String[] palList = new String[3];
		Integer[] palIntegers = new Integer[3];
		palList = Form.properties.getProperty("skillTree.pal.tab.close").split(",");
		palIntegers[0] = Integer.parseInt(palList[0]);
		palIntegers[1] = Integer.parseInt(palList[1]);
		palIntegers[2] = Integer.parseInt(palList[2]);
		tabCloseMap.put(Character.CHAR_PAL, palIntegers);
		String[] sorList = new String[3];
		Integer[] sorIntegers = new Integer[3];
		sorList = Form.properties.getProperty("skillTree.sor.tab.close").split(",");
		sorIntegers[0] = Integer.parseInt(sorList[0]);
		sorIntegers[1] = Integer.parseInt(sorList[1]);
		sorIntegers[2] = Integer.parseInt(sorList[2]);
		tabCloseMap.put(Character.CHAR_SOR, sorIntegers);
	}
	
	private static void initTreeDivMap() {
		treeDivMap = new HashMap<Integer, Integer[][]>();
		String[] amaList = new String[3];
		Integer[][] amaIntegers = new Integer[3][18];
		amaList[0] = Form.properties.getProperty("skillTree.ama.tab1.map");
		amaList[1] = Form.properties.getProperty("skillTree.ama.tab2.map");
		amaList[2] = Form.properties.getProperty("skillTree.ama.tab3.map");
		for(int i=0; i<3; i++){
			String[] skillPositionList = amaList[i].split(",");
			for(int j=0; j<18; j++){
				amaIntegers[i][j] = Integer.parseInt(skillPositionList[j].trim());
			}
		}
		treeDivMap.put(Character.CHAR_AMA, amaIntegers);
		String[] assList = new String[3];
		Integer[][] assIntegers = new Integer[3][18];
		assList[0] = Form.properties.getProperty("skillTree.ass.tab1.map");
		assList[1] = Form.properties.getProperty("skillTree.ass.tab2.map");
		assList[2] = Form.properties.getProperty("skillTree.ass.tab3.map");
		for(int i=0; i<3; i++){
			String[] skillPositionList = assList[i].split(",");
			for(int j=0; j<18; j++){
				assIntegers[i][j] = Integer.parseInt(skillPositionList[j].trim());
			}
		}
		treeDivMap.put(Character.CHAR_ASN, assIntegers);
		String[] barList = new String[3];
		Integer[][] barIntegers = new Integer[3][18];
		barList[0] = Form.properties.getProperty("skillTree.bar.tab1.map");
		barList[1] = Form.properties.getProperty("skillTree.bar.tab2.map");
		barList[2] = Form.properties.getProperty("skillTree.bar.tab3.map");
		for(int i=0; i<3; i++){
			String[] skillPositionList = barList[i].split(",");
			for(int j=0; j<18; j++){
				barIntegers[i][j] = Integer.parseInt(skillPositionList[j].trim());
			}
		}
		treeDivMap.put(Character.CHAR_BAR, barIntegers);
		String[] druList = new String[3];
		Integer[][] druIntegers = new Integer[3][18];
		druList[0] = Form.properties.getProperty("skillTree.dru.tab1.map");
		druList[1] = Form.properties.getProperty("skillTree.dru.tab2.map");
		druList[2] = Form.properties.getProperty("skillTree.dru.tab3.map");
		for(int i=0; i<3; i++){
			String[] skillPositionList = druList[i].split(",");
			for(int j=0; j<18; j++){
				druIntegers[i][j] = Integer.parseInt(skillPositionList[j].trim());
			}
		}
		treeDivMap.put(Character.CHAR_DRU, druIntegers);
		String[] necList = new String[3];
		Integer[][] necIntegers = new Integer[3][18];
		necList[0] = Form.properties.getProperty("skillTree.nec.tab1.map");
		necList[1] = Form.properties.getProperty("skillTree.nec.tab2.map");
		necList[2] = Form.properties.getProperty("skillTree.nec.tab3.map");
		for(int i=0; i<3; i++){
			String[] skillPositionList = necList[i].split(",");
			for(int j=0; j<18; j++){
				necIntegers[i][j] = Integer.parseInt(skillPositionList[j].trim());
			}
		}
		treeDivMap.put(Character.CHAR_NEC, necIntegers);
		String[] palList = new String[3];
		Integer[][] palIntegers = new Integer[3][18];
		palList[0] = Form.properties.getProperty("skillTree.pal.tab1.map");
		palList[1] = Form.properties.getProperty("skillTree.pal.tab2.map");
		palList[2] = Form.properties.getProperty("skillTree.pal.tab3.map");
		for(int i=0; i<3; i++){
			String[] skillPositionList = palList[i].split(",");
			for(int j=0; j<18; j++){
				palIntegers[i][j] = Integer.parseInt(skillPositionList[j].trim());
			}
		}
		treeDivMap.put(Character.CHAR_PAL, palIntegers);
		String[] sorList = new String[3];
		Integer[][] sorIntegers = new Integer[3][18];
		sorList[0] = Form.properties.getProperty("skillTree.sor.tab1.map");
		sorList[1] = Form.properties.getProperty("skillTree.sor.tab2.map");
		sorList[2] = Form.properties.getProperty("skillTree.sor.tab3.map");
		for(int i=0; i<3; i++){
			String[] skillPositionList = sorList[i].split(",");
			for(int j=0; j<18; j++){
				sorIntegers[i][j] = Integer.parseInt(skillPositionList[j].trim());
			}
		}
		treeDivMap.put(Character.CHAR_SOR, sorIntegers);
	}

	private SkillSpan dataSpan;
	private TabDiv tab1;
	private TabDiv tab2;
	private TabDiv tab3;
	private TabDiv tab4;
	private ResetLable[] resetLables;
	private TreeDiv[][] treeTable;
	private SkillTree()  {
		try {
			//设置图标
			Image icon = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("icon.path")));
			setIconImage(icon);
			setSize(655, 472);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			addWindowListener(new CloseListener());
			JPanel mainPanel = new JPanel(null);
			setContentPane(mainPanel);
			Image dataBackGround = ImageIO.read(ClassLoader.getSystemResourceAsStream(Form.properties.getProperty("skillTree.dataBackGround.path")));
			BackGroundPanel dataPanel = new BackGroundPanel(dataBackGround, new FlowLayout());
			mainPanel.add(dataPanel, data_panel_index);
			String text = "<html> <span color=#ff4040 text-align=center> <h2 color=#00ff00>火焰箭<br></h2>在箭矢或弓弹上附带了魔法火焰，<br> 并在打击时增加了火焰的伤害<br> <br> <span color=#00ff00><span color=black>40: </span >火焰箭 由以下技能得到额外加成:<br></span><span color=black>63: </span>爆裂箭: +12% 火焰伤害每一技能等级<br></span></html>";
			dataSpan = new SkillSpan(text); 
			dataPanel.setSize(320, 432);
			dataPanel.add(dataSpan,data_span_index);
			BackGroundPanel skillTreePanel = new BackGroundPanel(null, null);
			mainPanel.add(skillTreePanel, tree_panel_index);
			skillTreePanel.setSize(320, 432);
			skillTreePanel.setLocation(320, 0);
			tab1 = new TabDiv(230,329,85,96);
			skillTreePanel.add(tab1, tab1_index);
			tab2 = new TabDiv(230,221,85,96);
			skillTreePanel.add(tab2, tab2_index);
			tab3 = new TabDiv(230,113,85,96);
			skillTreePanel.add(tab3, tab3_index);
			tab4 = new TabDiv(237, 0, 79, 79);
			skillTreePanel.add(tab4);
			resetLables = new ResetLable[3];
			resetLables[0] = new ResetLable(15, 385, 32, 32);
			resetLables[1] = new ResetLable(100, 385, 32, 32);
			resetLables[2] = new ResetLable(171, 385, 32, 32);
			skillTreePanel.add(resetLables[0]);
			skillTreePanel.add(resetLables[1]);
			skillTreePanel.add(resetLables[2]);
			treeTable = new TreeDiv[6][3];
			for(int i=0;i<6;i++){
				for(int j=0;j<3;j++){
					treeTable[i][j] = new TreeDiv(i,j);
					skillTreePanel.add(treeTable[i][j]);
				}
			}
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
		String[] tabNames = tabNameMap.get(option.getValue());
		if (tabNames!=null && tabNames.length==4) {
			getTab1().setStr("<html>" + tabNames[0] + "<br>0</html>");
			getTab2().setStr("<html>" + tabNames[1] + "<br>0</html>");
			getTab3().setStr("<html>" + tabNames[2] + "<br>0</html>");
			tab4.setStr("<html>" + tabNames[3] + "<br>0</html>");
		}
		
		Integer close = tabCloseMap.get(option.getValue())[0];
		for(int i=1; i<=3; i++){
			if (i == close) {
				resetLables[i-1].setEnabled(true);
			}else {
				resetLables[i-1].setEnabled(false);
			}
		}
		Integer[] treeDiv = treeDivMap.get(option.getValue())[0];
		for(int i=0; i<6; i++){
			for(int j=0; j<3; j++){
				if (treeDiv[i*3+j] > 0) {
					treeTable[i][j].setVisible(true);
					Util.setEnable(treeTable[i][j], true);
					treeTable[i][j].setSkillIndex(treeDiv[i*3+j]);
				}else {
					treeTable[i][j].setVisible(false);
					Util.setEnable(treeTable[i][j], false);
				}
			}
		}
	}
	
	public SkillSpan getDataSpan() {
		return dataSpan;
	}
	
	public BackGroundPanel getTreePanel() {
		return (BackGroundPanel) getContentPane().getComponent(tree_panel_index);
	}
	
	public TabDiv getTab1() {
		return tab1;
	}
	
	public TabDiv getTab2() {
		return tab2;
	}
	
	public TabDiv getTab3() {
		return tab3;
	}
	
	private static class CloseListener extends WindowAdapter{

		@Override
		public void windowClosed(WindowEvent e) {
			Form form = Form.getInstance();
			Util.setEnable(form.getBody(), true);
			form.getCalc().setEnabled(true);
			form.getSpeedCalculator().setCharValues(form);
		}
		
		
	}
}
