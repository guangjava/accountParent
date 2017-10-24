package com.guang.diablo2.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guang.diablo2.calculator.WeaponSpeed;
import com.guang.diablo2.frame.base.GBC;

public class Form extends JFrame{

	private static final long serialVersionUID = 2033940145974929596L;
	private static final Logger LOGGER = LoggerFactory.getLogger(Form.class);
	private static final String PATH = "diablo2.properties";
	private static Form instance;
	public static Properties properties;
	static {
		properties = new Properties();
		try {
			properties.load(new InputStreamReader(ClassLoader.getSystemResourceAsStream(PATH), "UTF-8"));
		} catch (IOException e) {
			LOGGER.error("properties error",e);
		}
		
	}
	private static final int _mainPanel_index = 0;
	private static final int mainPanel_scroll_index = 1;
	private static final int mainPanel_input_index = 2;
	private static final int body_uchar_tr_index = 2;
	private static final int body_rightWeapon_pane_index = 3;
	private static final int body_leftWeapon_pane_index = 4;
	private static final int body_ias_tr_index = 6;
	private static final int body_non_weapon_ed_tr_index = 8;
	private static final int body_skill_ed_tr_index = 10;
	private static final int body_damage_tr_index = 12;
	private static final int body_double_damage_tr_index = 14;
	private static final int body_elemental_damage_pane_index = 15;
	private static final int body_skill_tr_index = 17;
	private static final int body_fana_tr_index = 20;
	private static final int body_frenzy_tr_index = 22;
	private static final int body_ww_tr_index = 24;
	private static final int body_burst_tr_index = 26;
	private static final int body_fps1_index = 29;
	private static final int body_fps2_index = 30;
	private static final int body_sps1_index = 32;
	private static final int body_final_damage1_index = 34;
	private static final int body_final_damage2_index = 35;
	private static final int uchar_comboBox_index = 0;
	private static final int strength_text_index = 2;
	private static final int dexterity_text_index = 4;
	private static final int skill_tree_index = 5;
	private static final int rightWeapon_pane_wuqi_tr_index = 0;
	private static final int rightWeapon_pane_weapon_tr_index = 1;
	private static final int rightWeapon_pane_h2h_tr_index = 2;
	private static final int rightWeapon_pane_weaponias_tr_index = 3;
	private static final int rightWeapon_pane_weapon_ed_tr_index = 4;
	private static final int rightWeapon_pane_weapontype1_tr_index = 5;
	private static final int rightWeapon_pane_weapon_base_damage_tr_index = 6;
	private static final int wuqi_comboBox_index = 0;
	private static final int weapon_comboBox_index = 0;
	private static final int ethereal_checkBox_index = 2;
	private static final int h2h_comboBox_index = 0;
	private static final int weaponias_comboBox_index = 1;
	private static final int weapon_ed_text_index = 1;
	private static final int weapontype1_var_index = 1;
	private static final int weapon_base_damage_var_index = 1;
	private static final int c2h_comboBox_index = 0;
	private static final int cwias_tr_index = 1;
	private static final int weapontype2_tr_index = 2;
	private static final int cwias_comboBox_index = 1;
	private static final int weapontype2_var_index = 1;
	private static final int ias_comboBox_index = 0;
	private static final int non_weapon_ed_text_index = 0;
	private static final int skill_ed_text_index = 0;
	private static final int plus_min_damage_text_index = 1;
	private static final int plus_max_damage_text_index = 3;
	private static final int crit_strike_comboBox_index = 1;
	private static final int deadly_strike_comboBox_index = 4;
	private static final int fire_lightning_damage_tr_index = 0;
	private static final int cold_poison_damage_tr_index = 1;
	private static final int fire_min_damage_index = 1;
	private static final int fire_max_damage_index = 3;
	private static final int lightning_min_damage_index = 5;
	private static final int lightning_max_damage_index = 7;
	private static final int cold_min_damage_index = 1;
	private static final int cold_max_damage_index = 3;
	private static final int poison_damage_index = 5;
	private static final int poison_time_index = 7;
	private static final int skill_comboBox_index = 0;
	private static final int thrown_checkBox_index = 1;
	private static final int fana_comboBox_index = 1;
	private static final int frenzy_comboBox_index = 1;
	private static final int ww_comboBox_index = 1;
	private static final int burst_comboBox_index = 1;
	private static final int input_text_index = 0;
	private static final int input_calc_index = 1;
	private static final String rightWeaponLable = "右手武器:(Right weapon)         ";
	private static final String leftWeaponLable  = "左手武器:(Left weapon)           ";
	private WeaponSpeed speedCalculator;
	private static boolean initOk = false;
	public static Form getInstance() {
		if (instance == null) instance = new Form();
		initOk = true;
		return instance;
	}
	/**
	 * @throws HeadlessException
	 */
	private Form() throws HeadlessException {
		LOGGER.info(Thread.currentThread().getName()+"======start=======");
		speedCalculator = new WeaponSpeed();
		try {
			initForm();
		} catch (IOException e) {
			LOGGER.error("",e);
		}
	}
	private void initForm() throws IOException {
		BaseDamageListener baseDamagelistener = new BaseDamageListener();
		FinalDamageDocumentListener finalDamageDocListener = new FinalDamageDocumentListener();
		FinalDamageItemListener finalDamageItemListener = new FinalDamageItemListener();
		//主框架
		JPanel mainPanel = new JPanel(new BorderLayout());
		add(mainPanel,null,_mainPanel_index);
		mainPanel.setBackground(Color.BLACK);
		/***********标题栏**********************/
		setSize(1250, 1030);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(properties.getProperty("title_en"));
		//设置图标
		Image icon = ImageIO.read(ClassLoader.getSystemResourceAsStream(properties.getProperty("icon.path")));
		setIconImage(icon);
		/**************菜单栏************************/
		JMenuBar menuBar = new JMenuBar();
		mainPanel.add(menuBar, "North",0);
		/**************计算************************/
		Image backGround = ImageIO.read(ClassLoader.getSystemResourceAsStream(properties.getProperty("backGround.path")));
		JPanel body = new BackGroundPanel(backGround,new GridBagLayout());
		JScrollPane scrollPane = new JScrollPane(body);
		mainPanel.add(scrollPane, "Center",mainPanel_scroll_index);
		body.setBackground(new Color(0x2e, 0x29, 0x27));
		body.add(new THheader("主要资料(Main materials)"),new GBC(0, 0, 12, 1,GBC.CENTER),0);
		body.add(new TDheader("人物:(Character)"), new GBC(0, 1, 2, 1), 1);
		TRone ucharTR = new TRone();
		body.add(ucharTR, new GBC(2, 1,10,1),body_uchar_tr_index);
		JComboBox<Option> uchar = new JComboBox<Option>(Option.getOptionsLable(properties.getProperty("form.uchar")));
		uchar.addItemListener(new UcharListener());
		ucharTR.add(uchar,uchar_comboBox_index);
		ucharTR.add(new TRoneTD("力量(Strength)"), 1);
		JTextField strength = new JTextField("15",4);
		strength.getDocument().addDocumentListener(finalDamageDocListener);
		ucharTR.add(strength, strength_text_index);
		ucharTR.add(new TRoneTD("敏捷(Dexterity)"), 3);
		JTextField dexterity = new JTextField("15",4);
		ucharTR.add(dexterity, dexterity_text_index);
		dexterity.getDocument().addDocumentListener(finalDamageDocListener);
		JButton skillTree = new JButton("技能树");
		skillTree.addMouseListener(new SkillTreeListener());
		ucharTR.add(skillTree,skill_tree_index);
		TRone rightWeaponTR = new TRone(7, 1);
		body.add(new TRJsplitPane(TRJsplitPane.HORIZONTAL_SPLIT, new TDheader(rightWeaponLable), rightWeaponTR),new GBC(0, 2, 12, 7),body_rightWeapon_pane_index);
		TRone wuqiTR = new TRone(1,3);
		rightWeaponTR.add(wuqiTR,rightWeapon_pane_wuqi_tr_index);
		JComboBox<Option> wuqi = new JComboBox<Option>();
		wuqiTR.add(wuqi,wuqi_comboBox_index);
		wuqiTR.add(new TRoneTD("[中文]"),1);
		TRCheckBox ethereal = new TRCheckBox("无形(Ethereal)");
		ethereal.setBackground(new Color(0x2e, 0x29, 0x27));
		ethereal.addItemListener(new EthListenner());
		wuqiTR.add(ethereal,ethereal_checkBox_index);
		TRone weaponTR = new TRone(1,2);
		rightWeaponTR.add(weaponTR,rightWeapon_pane_weapon_tr_index);
		JComboBox<Option> weapon = new JComboBox<Option>();
		weaponTR.add(weapon,weapon_comboBox_index);
		weaponTR.add(new TRoneTD("[english]"));
		TRone h2hTR = new TRone(1,2);
		rightWeaponTR.add(h2hTR,rightWeapon_pane_h2h_tr_index);
		JComboBox<Option> h2h = new JComboBox<Option>();
		h2hTR.add(h2h,h2h_comboBox_index);
		h2h.addItem(new Option("-", 0));
		h2h.addItemListener(new H2hListener());
		h2hTR.add(new TRoneTD("-手持(handed) [barbarian only]"));
		TRone weaponiasTR = new TRone(1,3);
		rightWeaponTR.add(weaponiasTR,rightWeapon_pane_weaponias_tr_index);
		weaponiasTR.add(new TRoneTD("武器提速(Weapon IAS)"),0);
		JComboBox<Option> weaponias = new JComboBox<Option>();
		weaponias.addItemListener(new IasListener());
		weaponiasTR.add(weaponias,weaponias_comboBox_index);
		weaponiasTR.add(new TRoneTD("% [only weredruid/barbarian/assassin]"));
		TRone weaponEdTR = new TRone(1, 3);
		rightWeaponTR.add(weaponEdTR, rightWeapon_pane_weapon_ed_tr_index);
		weaponEdTR.add(new TRoneTD("武器增加伤害(Weapon ED)"), 0);
		JTextField weaponED = new JTextField();
		weaponED.getDocument().addDocumentListener(baseDamagelistener);
		weaponEdTR.add(weaponED, weapon_ed_text_index);
		weaponEdTR.add(new TRoneTD("% [ON-WEAPON ONLY!]"));
		TRone weapontype1TR = new TRone(1,2);
		rightWeaponTR.add(weapontype1TR,rightWeapon_pane_weapontype1_tr_index);
		weapontype1TR.add(new TRoneTD("武器种类(Weapon type)"),0);
		weapontype1TR.add(new TRoneTD(""),weapontype1_var_index);
		TRone weaponBaseDamageTR = new TRone(1, 2);
		rightWeaponTR.add(weaponBaseDamageTR, rightWeapon_pane_weapon_base_damage_tr_index);
		weaponBaseDamageTR.add(new TRoneTD("武器基础伤害(Base Damage)"), 0);
		weaponBaseDamageTR.add(new TRoneTD(""), weapon_base_damage_var_index);
		TRone leftWeaponTR = new TRone(3, 1);
		body.add(new TRJsplitPane(TRJsplitPane.HORIZONTAL_SPLIT, new TDheader(leftWeaponLable), leftWeaponTR),new GBC(0, 9, 12, 3),body_leftWeapon_pane_index);
		JComboBox<Option> c2h = new JComboBox<Option>();
		leftWeaponTR.add(c2h, c2h_comboBox_index);
		c2h.addItem(new Option("-", 0));
		c2h.addItemListener(new C2hListener());
		TRone cwiasTR = new TRone(1,3);
		leftWeaponTR.add(cwiasTR, cwias_tr_index);
		cwiasTR.add(new TRoneTD("武器提速(Weapon IAS)"), 0);
		JComboBox<Option> cwias = new JComboBox<Option>();
		cwias.addItemListener(new IasListener());
		cwiasTR.add(cwias, cwias_comboBox_index);
		cwias.addItem(new Option("-", 0));
		cwiasTR.add(new TRoneTD("% [only weredruid/barbarian/assassin]"));
		TRone weapontype2TR = new TRone(1,2);
		leftWeaponTR.add(weapontype2TR,weapontype2_tr_index);
		weapontype2TR.add(new TRoneTD("武器种类(Weapon type)"),0);
		weapontype2TR.add(new TRoneTD(""),weapontype2_var_index);
		body.add(new TDheader("装备提速:(IAS)"), new GBC(0, 12, 2, 1), 5);
		TRone iasTR = new TRone();
		body.add(iasTR, new GBC(2, 12, 2, 1), body_ias_tr_index);
		JComboBox<Option> ias = new JComboBox<Option>();
		ias.addItemListener(new IasListener());
		iasTR.add(ias, ias_comboBox_index);
		iasTR.add(new TRoneTD("%"));
		body.add(new TDheader("非武器增加伤害:(ED)"), new GBC(4, 12, 2, 1), 7);
		TRone nonWeaponEDTR = new TRone();
		body.add(nonWeaponEDTR, new GBC(6, 12, 2, 1), body_non_weapon_ed_tr_index);
		JTextField nonWeaponED = new JTextField(4);
		nonWeaponED.getDocument().addDocumentListener(finalDamageDocListener);
		nonWeaponEDTR.add(nonWeaponED, non_weapon_ed_text_index);
		nonWeaponEDTR.add(new TRoneTD("%"));
		body.add(new TDheader("技能增加的伤害:(ED)"), new GBC(8, 12, 2, 1), 9);
		TRone skillEDTR = new TRone();
		body.add(skillEDTR, new GBC(10, 12, 2, 1), body_skill_ed_tr_index);
		JTextField skillED = new JTextField(4);
		skillED.getDocument().addDocumentListener(finalDamageDocListener);
		skillEDTR.add(skillED, skill_ed_text_index);
		skillEDTR.add(new TRoneTD("%"));
		body.add(new TDheader("加成伤害:(Damage)"), new GBC(0, 13, 2, 1), 11);
		TRone damageTR = new TRone();
		body.add(damageTR, new GBC(2, 13, 10, 1), body_damage_tr_index);
		damageTR.add(new TRoneTD("最小伤害(Min)"), 0);
		JTextField plus_min_damage = new JTextField(4);
		plus_min_damage.getDocument().addDocumentListener(baseDamagelistener);
		damageTR.add(plus_min_damage, plus_min_damage_text_index);
		damageTR.add(new TRoneTD("最大伤害(Max)"), 2);
		JTextField plus_max_damage = new JTextField(4);
		plus_max_damage.getDocument().addDocumentListener(baseDamagelistener);
		damageTR.add(plus_max_damage, plus_max_damage_text_index);
		TRone elementalDamageTR = new TRone(2, 1);
		body.add(new TDheader("双倍打击:(Double Damage)"), new GBC(0, 14, 2, 1), 13);
		TRone doubleDamageTR = new TRone();
		body.add(doubleDamageTR, new GBC(2, 14, 10, 1), body_double_damage_tr_index);
		doubleDamageTR.add(new TRoneTD("双倍打击(CS)"), 0);
		JComboBox<Option> critStrike = new JComboBox<>();
		doubleDamageTR.add(critStrike, crit_strike_comboBox_index);
		critStrike.addItemListener(finalDamageItemListener);
		doubleDamageTR.add(new TRoneTD("% "), 2);
		doubleDamageTR.add(new TRoneTD("致命一击(DS)"), 3);
		JComboBox<Option> deadlystrike = new JComboBox<>();
		deadlystrike.addItemListener(finalDamageItemListener);
		doubleDamageTR.add(deadlystrike, deadly_strike_comboBox_index);
		doubleDamageTR.add(new TRoneTD("%"));
		body.add(new TRJsplitPane(TRJsplitPane.HORIZONTAL_SPLIT, new TDheader("元素伤害:(Elemental Damage)"), elementalDamageTR),new GBC(0, 15, 12, 2),body_elemental_damage_pane_index);
		TRone fireLightingDamageTR = new TRone();
		elementalDamageTR.add(fireLightingDamageTR, fire_lightning_damage_tr_index);
		fireLightingDamageTR.add(new TRoneTD("火焰伤害(FD)",Color.RED), 0);
		JTextField fireMinDamage = new JTextField(3);
		fireMinDamage.getDocument().addDocumentListener(baseDamagelistener);
		fireLightingDamageTR.add(fireMinDamage, fire_min_damage_index);
		fireLightingDamageTR.add(new TRoneTD(" - "), 2);
		JTextField fireMaxDamage = new JTextField(3);
		fireMaxDamage.getDocument().addDocumentListener(baseDamagelistener);
		fireLightingDamageTR.add(fireMaxDamage, fire_max_damage_index);
		fireLightingDamageTR.add(new TRoneTD("闪电伤害(LD)", Color.YELLOW), 4);
		JTextField lightningMinDamage = new JTextField(3);
		lightningMinDamage.getDocument().addDocumentListener(baseDamagelistener);
		fireLightingDamageTR.add(lightningMinDamage, lightning_min_damage_index);
		fireLightingDamageTR.add(new TRoneTD("       -       "), 6);
		JTextField lightningMaxDamage = new JTextField(3);
		lightningMaxDamage.getDocument().addDocumentListener(baseDamagelistener);
		fireLightingDamageTR.add(lightningMaxDamage, lightning_max_damage_index);
		TRone coldPoisonDamageTR = new TRone();
		elementalDamageTR.add(coldPoisonDamageTR, cold_poison_damage_tr_index);
		coldPoisonDamageTR.add(new TRoneTD("冰冻伤害(CD)", Color.BLUE), 0);
		JTextField coldMinDamage = new JTextField(3);
		coldMinDamage.getDocument().addDocumentListener(baseDamagelistener);
		coldPoisonDamageTR.add(coldMinDamage, cold_min_damage_index);
		coldPoisonDamageTR.add(new TRoneTD(" - "), 2);
		JTextField coldMaxDamage = new JTextField(3);
		coldMaxDamage.getDocument().addDocumentListener(baseDamagelistener);
		coldPoisonDamageTR.add(coldMaxDamage, cold_max_damage_index);
		coldPoisonDamageTR.add(new TRoneTD("毒素伤害(PD)", Color.GREEN), 4);
		JTextField poisonDamage = new JTextField(3);
		poisonDamage.getDocument().addDocumentListener(baseDamagelistener);
		coldPoisonDamageTR.add(poisonDamage, poison_damage_index);
		coldPoisonDamageTR.add(new TRoneTD("持续时间"), 6);
		JTextField poisonTime = new JTextField(3);
		poisonTime.getDocument().addDocumentListener(baseDamagelistener);
		coldPoisonDamageTR.add(poisonTime, poison_time_index);
		body.add(new TDheader("使用技能:(Skill)"), new GBC(0, 17, 2, 1), 16);
		TRone skillTR = new TRone();
		body.add(skillTR, new GBC(2, 17, 10, 1), body_skill_tr_index);
		JComboBox<Option> skill = new JComboBox<Option>();
		skill.addItemListener(new SkillListener());
		skillTR.add(skill, skill_comboBox_index);
		TRCheckBox thrown = new TRCheckBox("投掷:(throw)"); 
		thrown.addItemListener(new ThrownListenner());
		skillTR.add(thrown, thrown_checkBox_index);
		body.add(new THheader("其他持续性技能加成(Other constant Skill IAS)"),new GBC(0, 18, 12, 1,GBC.CENTER),18);
		body.add(new TDheader("狂热灵气:(Fanaticism)"), new GBC(0, 19, 2, 1), 19);
		TRone fanaTR = new TRone();
		body.add(fanaTR, new GBC(2, 19, 10, 1), body_fana_tr_index);
		fanaTR.add(new TRoneTD("等级(Level)"), 0);
		JComboBox<Option> fana = new JComboBox<Option>();
		fana.addItemListener(new IasListener());
		fanaTR.add(fana, fana_comboBox_index);
		body.add(new TDheader("狂乱:(Frenzy)"), new GBC(0, 20, 2, 1), 21);
		TRone frenzyTR = new TRone();
		body.add(frenzyTR, new GBC(2, 20, 10, 1), body_frenzy_tr_index);
		frenzyTR.add(new TRoneTD("等级(Level)"), 0);
		JComboBox<Option> frenzy = new JComboBox<Option>();
		frenzy.addItemListener(new IasListener());
		frenzyTR.add(frenzy, frenzy_comboBox_index);
		frenzyTR.add(new TRoneTD("[barbarian only]"), 2);
		body.add(new TDheader("变身狼人:(Werewolf)"), new GBC(0, 21, 2, 1), 23);
		TRone wwTR = new TRone();
		body.add(wwTR, new GBC(2, 21, 10, 1), body_ww_tr_index);
		wwTR.add(new TRoneTD("等级(Level)"), 0);
		JComboBox<Option> ww = new JComboBox<Option>();
		ww.addItemListener(new IasListener());
		wwTR.add(ww, ww_comboBox_index);
		wwTR.add(new TRoneTD("[druid only]"), 2);
		body.add(new TDheader("速度爆发:(Burst of Speed)"), new GBC(0, 22, 2, 1), 25);
		TRone burstTR = new TRone();
		body.add(burstTR, new GBC(2, 22, 10, 1), body_burst_tr_index);
		burstTR.add(new TRoneTD("等级(Level)"), 0);
		JComboBox<Option> burst = new JComboBox<Option>();
		burst.addItemListener(new IasListener());
		burstTR.add(burst, burst_comboBox_index);
		burstTR.add(new TRoneTD("[assassin only]"));
		body.add(new THheader("结果(Results)"),new GBC(0, 23, 12, 1,GBC.CENTER),27);
		body.add(new TDheader("最终攻击速度: (Attack Speed)"), new GBC(0, 24, 2, 1), 28);
		body.add(new TRoneTD(""), new GBC(2, 24, 10, 1), body_fps1_index);
		body.add(new TRoneTD(""), new GBC(2, 25, 10, 1), body_fps2_index);
		body.add(new TDheader("攻击频率: (Frequency)"), new GBC(0, 26, 2, 1), 31);
		body.add(new TRoneTD(""), new GBC(2, 26, 10, 1), body_sps1_index);
		body.add(new TDheader("最终伤害 (Final Damage)"), new GBC(0, 27, 2, 1), 33);
		body.add(new TRoneTD(""), new GBC(2, 27, 10, 1), body_final_damage1_index);
		body.add(new TRoneTD(""), new GBC(2, 28, 10, 1), body_final_damage2_index);
		/**************输入框************************/
		JPanel input = new JPanel();
		mainPanel.add(input, "South",mainPanel_input_index);
		input.setBackground(new Color(0x2e, 0x29, 0x27));
		TextArea textArea = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		TRoneTD error = new TRoneTD("正常",Color.RED);
		TRJsplitPane inputSplit = new TRJsplitPane(TRJsplitPane.VERTICAL_SPLIT, textArea, error);
		input.add(inputSplit, input_text_index);
		JButton calc = new JButton("计算");
		calc.addMouseListener(new CalcListener());
		input.add(calc, input_calc_index);
		
		speedCalculator.setCharValues(this);
		setVisible(true);
	}
	
	public void setEnable(Container container,boolean enable) {
		container.setEnabled(enable);
		Component[] components = container.getComponents();
		for (Component component : components) {
			if (!(component instanceof Container)) {
				component.setEnabled(enable);
			}else {
				setEnable((Container) component, enable);
			}
		}
	}
	
	/**
	 * @return 右手武器:(Right weapon)[中文]
	 * @author zhouchenguang
	 * @date 2017年10月5日上午9:21:02
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getWuqi() {
		JPanel body = getBody();
		TRone rightWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_rightWeapon_pane_index)).getRightComponent();
		return (JComboBox<Option>) ((TRone) rightWeaponTR.getComponent(rightWeapon_pane_wuqi_tr_index)).getComponent(wuqi_comboBox_index);
	}
	
	/**
	 * @return 右手武器:(Right weapon)[english]
	 * @author zhouchenguang
	 * @date 2017年10月5日上午9:21:41
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getWeapon() {
		JPanel body = getBody();
		TRone rightWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_rightWeapon_pane_index)).getRightComponent();
		return (JComboBox<Option>) ((TRone) rightWeaponTR.getComponent(rightWeapon_pane_weapon_tr_index)).getComponent(weapon_comboBox_index);
	}
	
	/**
	 * @return 使用技能:(Skill)
	 * @author zhouchenguang
	 * @date 2017年10月5日上午9:22:00
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getSkill() {
		JPanel body = getBody();
		TRone skillTR = (TRone) body.getComponent(body_skill_tr_index);
		return (JComboBox<Option>) skillTR.getComponent(skill_comboBox_index);
	}
	
	/**
	 * @return 装备提速:(IAS)
	 * @author zhouchenguang
	 * @date 2017年9月30日下午11:47:27
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getIas() {
		JPanel body = getBody();
		TRone iasTR = (TRone) body.getComponent(body_ias_tr_index);
		return (JComboBox<Option>) iasTR.getComponent(ias_comboBox_index);
	}
	
	/**
	 * @return 右手武器:(Right weapon)武器提速(Weapon IAS)
	 * @author zhouchenguang
	 * @date 2017年10月5日上午1:33:24
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getWeaponIas() {
		JPanel body = getBody();
		TRone rightWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_rightWeapon_pane_index)).getRightComponent();
		TRone weaponiasTR = (TRone) rightWeaponTR.getComponent(rightWeapon_pane_weaponias_tr_index);
		return (JComboBox<Option>) weaponiasTR.getComponent(weaponias_comboBox_index);
	}
	
	/**
	 * @return  右手武器:(Right weapon)手持(handed) [barbarian only]
	 * @author zhouchenguang
	 * @date 2017年10月5日上午9:14:56
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getH2h() {
		JPanel body = getBody();
		TRone rightWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_rightWeapon_pane_index)).getRightComponent();
		TRone h2hTR = (TRone) rightWeaponTR.getComponent(rightWeapon_pane_h2h_tr_index);
		return (JComboBox<Option>) h2hTR.getComponent(h2h_comboBox_index);
	}
	
	/**
	 * @return 左手武器:(Left weapon)
	 * @author zhouchenguang
	 * @date 2017年10月5日上午9:20:23
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getC2h() {
		JPanel body = getBody();
		TRone leftWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_leftWeapon_pane_index)).getRightComponent();
		return (JComboBox<Option>) leftWeaponTR.getComponent(c2h_comboBox_index);
	}
	
	/**
	 * @return 左手武器:(Left weapon)武器提速(Weapon IAS)
	 * @author zhouchenguang
	 * @date 2017年10月5日下午6:11:22
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getCwias() {
		JPanel body = getBody();
		TRone leftWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_leftWeapon_pane_index)).getRightComponent();
		TRone cwiasTR = (TRone) leftWeaponTR.getComponent(cwias_tr_index);
		return (JComboBox<Option>) cwiasTR.getComponent(cwias_comboBox_index);
	}
	
	/**
	 * @return 变身狼人:(Werewolf)等级(Level)
	 * @author zhouchenguang
	 * @date 2017年10月5日上午2:24:51
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getWW() {
		JPanel body = getBody();
		TRone wwTR = (TRone) body.getComponent(body_ww_tr_index);
		return (JComboBox<Option>) wwTR.getComponent(ww_comboBox_index);
	}
	
	/**
	 * @return 速度爆发:(Burst of Speed)等级(Level)
	 * @author zhouchenguang
	 * @date 2017年10月5日上午2:51:31
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getBurst() {
		JPanel body = getBody();
		TRone burstTR = (TRone) body.getComponent(body_burst_tr_index);
		return (JComboBox<Option>) burstTR.getComponent(burst_comboBox_index);
	}
	
	/**
	 * @return 狂乱:(Frenzy)等级(Level)
	 * @author zhouchenguang
	 * @date 2017年10月5日上午3:04:56
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getFrenzy() {
		JPanel body = getBody();
		TRone frenzyTR = (TRone) body.getComponent(body_frenzy_tr_index);
		return (JComboBox<Option>) frenzyTR.getComponent(frenzy_comboBox_index);
	}
	
	/**
	 * @return 狂热灵气:(Fanaticism)等级(Level)
	 * @author zhouchenguang
	 * @date 2017年10月5日上午8:58:50
	 * @since 1.0.0
	 */
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getFana() {
		JPanel body = getBody();
		TRone fanaTR = (TRone) body.getComponent(body_fana_tr_index);
		return (JComboBox<Option>) fanaTR.getComponent(fana_comboBox_index);
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getUchar() {
		JPanel body = getBody();
		return  (JComboBox<Option>) ((TRone) body.getComponent(body_uchar_tr_index)).getComponent(uchar_comboBox_index);
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getCS() {
		JPanel body = getBody();
		return  (JComboBox<Option>) ((TRone) body.getComponent(body_double_damage_tr_index)).getComponent(crit_strike_comboBox_index);
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<Option> getDS() {
		JPanel body = getBody();
		return  (JComboBox<Option>) ((TRone) body.getComponent(body_double_damage_tr_index)).getComponent(deadly_strike_comboBox_index);
	}
	
	public Option getSelectedUchar() {
		return (Option) getUchar().getSelectedItem();
	}
	
	public TRoneTD getFps1() {
		JPanel body = getBody();
		return (TRoneTD) body.getComponent(body_fps1_index);
	}
	
	public TRoneTD getFps2() {
		JPanel body = getBody();
		return (TRoneTD) body.getComponent(body_fps2_index);
	}
	
	public TRoneTD getSps1() {
		JPanel body = getBody();
		return (TRoneTD) body.getComponent(body_sps1_index);
	}
	
	public TRoneTD getFinalDamage1() {
		JPanel body = getBody();
		return (TRoneTD) body.getComponent(body_final_damage1_index);
	}
	
	public TRoneTD getFinalDamage2() {
		JPanel body = getBody();
		return (TRoneTD) body.getComponent(body_final_damage2_index);
	}
	
	public TRoneTD getWeaponType1() {
		JPanel body = getBody();
		TRone rightWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_rightWeapon_pane_index)).getRightComponent();
		return (TRoneTD) ((TRone) rightWeaponTR.getComponent(rightWeapon_pane_weapontype1_tr_index)).getComponent(weapontype1_var_index);
	}
	
	public TRoneTD getWeaponType2() {
		JPanel body = getBody();
		TRone leftWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_leftWeapon_pane_index)).getRightComponent();
		return (TRoneTD) ((TRone) leftWeaponTR.getComponent(weapontype2_tr_index)).getComponent(weapontype2_var_index);
	}
	
	public TRoneTD getWeaponBaseDamage() {
		JPanel body = getBody();
		TRone rightWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_rightWeapon_pane_index)).getRightComponent();
		return (TRoneTD) ((TRone) rightWeaponTR.getComponent(rightWeapon_pane_weapon_base_damage_tr_index)).getComponent(weapon_base_damage_var_index);
	}
	
	public TRCheckBox getEthereal() {
		JPanel body = getBody();
		TRone rightWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_rightWeapon_pane_index)).getRightComponent();
		return (TRCheckBox) ((TRone) rightWeaponTR.getComponent(rightWeapon_pane_wuqi_tr_index)).getComponent(ethereal_checkBox_index);
	}
	
	public TRCheckBox getThrown() {
		JPanel body = getBody();
		TRone skillTR = (TRone) body.getComponent(body_skill_tr_index);
		return (TRCheckBox)  skillTR.getComponent(thrown_checkBox_index);
	}
	
	public TRoneTD getError() {
		TRJsplitPane input = getInput();
		return (TRoneTD) input.getRightComponent();
	}
	
	public TextArea geTextArea() {
		TRJsplitPane input = getInput();
		return (TextArea) input.getLeftComponent();
	}
	
	public JButton getCalc() {
		JPanel mainPanel = (JPanel) getRootPane().getContentPane().getComponent(_mainPanel_index);
		return (JButton) ((JPanel) mainPanel.getComponent(mainPanel_input_index)).getComponent(input_calc_index);
	}
	
	public int getStrengthText() throws Exception{
		try {
			JTextField strength = getStrength();
			String text = strength.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			int result = Integer.parseInt(text);
			if (result <= 0) {
				throw new Exception("\"力量\"错误");
			}
			return result;
		} catch (Exception e) {
			LOGGER.error("\"力量\"错误",e);
			throw new Exception("\"力量\"错误");
		}
	}
	
	public int getDexterityText() throws Exception{
		try {
			JTextField dexterity = getDexterity();
			String text = dexterity.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			int result = Integer.parseInt(text);
			if (result <= 0) {
				throw new Exception("\"敏捷\"错误");
			}
			return result;
		} catch (Exception e) {
			LOGGER.error("\"敏捷\"错误",e);
			throw new Exception("\"敏捷\"错误");
		}
	}
	
	public int getWeaponEDText() throws Exception{
		try {
			JTextField weapon_ed = getWeaponED();
			String text = weapon_ed.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"武器增加伤害\"错误",e);
			throw new Exception("\"武器增加伤害\"错误");
		}
	}
	
	public int getNonWeaponEDText() throws Exception{
		try {
			JTextField non_weapon_ed = getNonWeaponED();
			String text = non_weapon_ed.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"非武器增加伤害\"错误",e);
			throw new Exception("\"非武器增加伤害\"错误");
		}
	}
	
	public int getSkillEDText() throws Exception{
		try {
			JTextField skill_ed = getSkillED();
			String text = skill_ed.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"技能增加伤害\"错误",e);
			throw new Exception("\"技能增加伤害\"错误");
		}
	}
	
	public int getPlusMinDamageText() throws Exception{
		try {
			JTextField plus_min_damage = getPlusMinDamage();
			String text = plus_min_damage.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"最小加成伤害\"错误",e);
			throw new Exception("\"最小加成伤害\"错误");
		}
	}
	
	public int getPlusMaxDamageText() throws Exception{
		try {
			JTextField plus_max_damage = getPlusMaxDamage();
			String text = plus_max_damage.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"最大加成伤害\"错误",e);
			throw new Exception("\"最大加成伤害\"错误");
		}
	}
	
	public int getFireMinDamageText() throws Exception{
		try {
			JTextField fire_min_damage = getFireMinDamage();
			String text = fire_min_damage.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"火焰最小伤害\"错误",e);
			throw new Exception("\"火焰最小伤害\"错误");
		}
	}
	
	public int getFireMaxDamageText() throws Exception{
		try {
			JTextField fire_max_damage = getFireMaxDamage();
			String text = fire_max_damage.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"火焰最大伤害\"错误",e);
			throw new Exception("\"火焰最大伤害\"错误");
		}
	}
	
	public int getLightningMinDamageText() throws Exception{
		try {
			JTextField lightning_min_damage = getLightningMinDamage();
			String text = lightning_min_damage.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"闪电最小伤害\"错误",e);
			throw new Exception("\"闪电最小伤害\"错误");
		}
	}
	
	public int getLightningMaxDamageText() throws Exception{
		try {
			JTextField lightning_max_damage = getLightningMaxDamage();
			String text = lightning_max_damage.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"闪电最大伤害\"错误",e);
			throw new Exception("\"闪电最大伤害\"错误");
		}
	}
	
	public int getColdMinDamageText() throws Exception{
		try {
			JTextField cold_min_damage = getColdMinDamage();
			String text = cold_min_damage.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"冰冻最小伤害\"错误",e);
			throw new Exception("\"冰冻最小伤害\"错误");
		}
	}
	
	public int getColdMaxDamageText() throws Exception{
		try {
			JTextField cold_max_damage = getColdMaxDamage();
			String text = cold_max_damage.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"闪电最大伤害\"错误",e);
			throw new Exception("\"闪电最大伤害\"错误");
		}
	}
	
	public int getPoisonDamageText() throws Exception{
		try {
			JTextField poison_damage = getPoisonDamage();
			String text = poison_damage.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"毒素伤害\"错误",e);
			throw new Exception("\"毒素伤害\"错误");
		}
	}
	
	public int getPoisonTimeText() throws Exception{
		try {
			JTextField poison_time = getPoisonTime();
			String text = poison_time.getText();
			if (text==null || text.trim().equals("")) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			LOGGER.error("\"毒素持续时间\"错误",e);
			throw new Exception("\"毒素持续时间\"错误");
		}
	}
	
	public JTextField getStrength() {
		JPanel body = getBody();
		TRone ucharTR = (TRone) body.getComponent(body_uchar_tr_index);
		JTextField strength = (JTextField)ucharTR.getComponent(strength_text_index);
		return strength;
	}
	
	public JTextField getDexterity() {
		JPanel body = getBody();
		TRone ucharTR = (TRone) body.getComponent(body_uchar_tr_index);
		JTextField dexterity = (JTextField)ucharTR.getComponent(dexterity_text_index);
		return dexterity;
	}
	
	public JTextField getWeaponED() {
		JPanel body = getBody();
		TRone rightWeaponTR = (TRone) ((TRJsplitPane)body.getComponent(body_rightWeapon_pane_index)).getRightComponent();
		JTextField weapon_ed = (JTextField) ((TRone)rightWeaponTR.getComponent(rightWeapon_pane_weapon_ed_tr_index)).getComponent(weapon_ed_text_index);
		return weapon_ed;
	}
	
	public JTextField getNonWeaponED() {
		JPanel body = getBody();
		TRone nonWeaponEDTR = (TRone) body.getComponent(body_non_weapon_ed_tr_index);
		JTextField non_weapon_ed = (JTextField)nonWeaponEDTR.getComponent(non_weapon_ed_text_index);
		return non_weapon_ed;
	}
	
	public JTextField getSkillED() {
		JPanel body = getBody();
		TRone skillEDTR = (TRone) body.getComponent(body_skill_ed_tr_index);
		JTextField skill_ed = (JTextField)skillEDTR.getComponent(skill_ed_text_index);
		return skill_ed;
	}
	
	public JTextField getPlusMinDamage() {
		JPanel body = getBody();
		TRone damageTR = (TRone) body.getComponent(body_damage_tr_index);
		JTextField plus_min_damage = (JTextField)damageTR.getComponent(plus_min_damage_text_index);
		return plus_min_damage;
	}
	
	public JTextField getPlusMaxDamage() {
		JPanel body = getBody();
		TRone damageTR = (TRone) body.getComponent(body_damage_tr_index);
		JTextField plus_max_damage = (JTextField)damageTR.getComponent(plus_max_damage_text_index);
		return plus_max_damage;
	}
	
	public JTextField getFireMinDamage() {
		JPanel body = getBody();
		TRone elementalDamageTR = (TRone) ((TRJsplitPane)body.getComponent(body_elemental_damage_pane_index)).getRightComponent();
		JTextField fire_min_damage = (JTextField) ((TRone)elementalDamageTR.getComponent(fire_lightning_damage_tr_index)).getComponent(fire_min_damage_index);
		return fire_min_damage;
	}
	
	public JTextField getFireMaxDamage() {
		JPanel body = getBody();
		TRone elementalDamageTR = (TRone) ((TRJsplitPane)body.getComponent(body_elemental_damage_pane_index)).getRightComponent();
		JTextField fire_max_damage = (JTextField) ((TRone)elementalDamageTR.getComponent(fire_lightning_damage_tr_index)).getComponent(fire_max_damage_index);
		return fire_max_damage;
	}
	
	public JTextField getLightningMinDamage() {
		JPanel body = getBody();
		TRone elementalDamageTR = (TRone) ((TRJsplitPane)body.getComponent(body_elemental_damage_pane_index)).getRightComponent();
		JTextField lightning_min_damage = (JTextField) ((TRone)elementalDamageTR.getComponent(fire_lightning_damage_tr_index)).getComponent(lightning_min_damage_index);
		return lightning_min_damage;
	}
	
	public JTextField getLightningMaxDamage() {
		JPanel body = getBody();
		TRone elementalDamageTR = (TRone) ((TRJsplitPane)body.getComponent(body_elemental_damage_pane_index)).getRightComponent();
		JTextField lightning_max_damage = (JTextField) ((TRone)elementalDamageTR.getComponent(fire_lightning_damage_tr_index)).getComponent(lightning_max_damage_index);
		return lightning_max_damage;
	}
	
	public JTextField getColdMinDamage() {
		JPanel body = getBody();
		TRone elementalDamageTR = (TRone) ((TRJsplitPane)body.getComponent(body_elemental_damage_pane_index)).getRightComponent();
		JTextField cold_min_damage = (JTextField) ((TRone)elementalDamageTR.getComponent(cold_poison_damage_tr_index)).getComponent(cold_min_damage_index);
		return cold_min_damage;
	}
	
	public JTextField getColdMaxDamage() {
		JPanel body = getBody();
		TRone elementalDamageTR = (TRone) ((TRJsplitPane)body.getComponent(body_elemental_damage_pane_index)).getRightComponent();
		JTextField cold_max_damage = (JTextField) ((TRone)elementalDamageTR.getComponent(cold_poison_damage_tr_index)).getComponent(cold_max_damage_index);
		return cold_max_damage;
	}
	
	public JTextField getPoisonDamage() {
		JPanel body = getBody();
		TRone elementalDamageTR = (TRone) ((TRJsplitPane)body.getComponent(body_elemental_damage_pane_index)).getRightComponent();
		JTextField poison_damage = (JTextField) ((TRone)elementalDamageTR.getComponent(cold_poison_damage_tr_index)).getComponent(poison_damage_index);
		return poison_damage;
	}
	
	public JTextField getPoisonTime() {
		JPanel body = getBody();
		TRone elementalDamageTR = (TRone) ((TRJsplitPane)body.getComponent(body_elemental_damage_pane_index)).getRightComponent();
		JTextField poison_time = (JTextField) ((TRone)elementalDamageTR.getComponent(cold_poison_damage_tr_index)).getComponent(poison_time_index);
		return poison_time;
	}
	
	private TRJsplitPane getInput() {
		JPanel mainPanel = (JPanel) getRootPane().getContentPane().getComponent(_mainPanel_index);
		return (TRJsplitPane) ((JPanel) mainPanel.getComponent(mainPanel_input_index)).getComponent(input_text_index);
	}
	/**
	 * @return
	 * @author zhouchenguang
	 * @date 2017年9月30日下午10:14:13
	 * @since 1.0.0
	 */
	JPanel getBody() {
		JPanel mainPanel = (JPanel) getRootPane().getContentPane().getComponent(_mainPanel_index);
		JScrollPane scrollPane = (JScrollPane) mainPanel.getComponent(mainPanel_scroll_index);
		return (JPanel) scrollPane.getViewport().getView();
	}

	/**
	 * 返回 #{bare_field_comment}
	 * @return the speedCalculator
	 */
	public WeaponSpeed getSpeedCalculator() {
		return speedCalculator;
	}
	
	/**
	 * 返回 #{bare_field_comment}
	 * @return the initOk
	 */
	public static boolean isInitOk() {
		return initOk;
	}
	
	private static class UcharListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				Form form = Form.getInstance();
				form.speedCalculator.setCharValues(form);
			}
		}
		
	}
	
	private static class SkillTreeListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			Form form = Form.getInstance();
			form.setEnable(form.getBody(), false);
			form.getCalc().setEnabled(false);
			SkillTree.getInstance().init(form.getSelectedUchar());
		}
		
	}
	
	private static class EthListenner implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			Form form = Form.getInstance();
			form.speedCalculator.thrownCheck(form);
		}
		
	}
	
	private static class H2hListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {//排除取消选项时干扰
				Form form = Form.getInstance();
				form.speedCalculator.changeH2h(form);
				form.speedCalculator.thrownCheck(form);
			}
		}
	}
	
	private static class IasListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (initOk && e.getStateChange()==ItemEvent.SELECTED) {//防止死循环
				Form form = Form.getInstance();
				form.speedCalculator.compute(form);
			}
		}
	}
	
	private static class C2hListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (initOk && e.getStateChange()==ItemEvent.SELECTED) {//防止死循环
				Form form = Form.getInstance();
				form.speedCalculator.changeLeftWeapon(form);
			}
		}
	}
	
	private static class BaseDamageListener implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			Form form = Form.getInstance();
			form.speedCalculator.doBaseDamage(form);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			Form form = Form.getInstance();
			form.speedCalculator.doBaseDamage(form);
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			Form form = Form.getInstance();
			form.speedCalculator.doBaseDamage(form);
		}
		
	}
	
	private static class FinalDamageDocumentListener implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			Form form = Form.getInstance();
			form.speedCalculator.calc_final_damage(form);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			Form form = Form.getInstance();
			form.speedCalculator.calc_final_damage(form);
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			Form form = Form.getInstance();
			form.speedCalculator.calc_final_damage(form);
		}
		
	}
	
	private static class FinalDamageItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (initOk && e.getStateChange()==ItemEvent.SELECTED) {//防止死循环
				Form form = Form.getInstance();
				form.speedCalculator.calc_final_damage(form);
			}
		}
	}
	
	private static class SkillListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (initOk && e.getStateChange()==ItemEvent.SELECTED) {//防止死循环
				Form form = Form.getInstance();
				form.speedCalculator.changeSkill(form, false);
			}
		}
	}
	
	private static class ThrownListenner implements ItemListener{


		@Override
		public void itemStateChanged(ItemEvent e) {
			if (initOk) {
				Form form = Form.getInstance();
				form.speedCalculator.doBaseDamage(form);
			}
		}
		
	}
	
	private static class CalcListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			Form form = Form.getInstance();
			form.speedCalculator.jsonCalc(form);
		}

	}
}
