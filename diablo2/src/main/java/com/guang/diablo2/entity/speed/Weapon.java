package com.guang.diablo2.entity.speed;

import java.util.ArrayList;
import java.util.List;

public class Weapon {
	/**
	 * 单手手杖(Wand)
	 */
	public static final int type_wand = 1;
	/**
	 * 单手权杖(Scepter)
	 */
	public static final int type_scepter = 2;
	/**
	 * 单手斧头(1Hand axe)
	 */
	public static final int type_1H_axe = 3;
	/**
	 * 单手法师天球(Orb)
	 */
	public static final int type_orb = 4;
	/**
	 * 单手钉头锤(1Hand mace)
	 */
	public static final int type_1H_mace = 5;
	/**
	 * 单手剑(1Hand sword)
	 */
	public static final int type_1H_sword = 6;
	/**
	 * 单手匕首(Dagger)
	 */
	public static final int type_dagger = 7;
	/**
	 * 双手剑(2Hand sword)
	 */
	public static final int type_2H_sword = 8;
	/**
	 * 双手矛(Spear)
	 */
	public static final int type_spear = 9;
	/**
	 * 双手斧(2Hand axe)
	 */
	public static final int type_2H_axe = 10;
	/**
	 * 双手法杖(Staff)
	 */
	public static final int type_staff = 11;
	/**
	 * 双手钉头锤(2Hand mace)
	 */
	public static final int type_2H_mace = 12;
	/**
	 * 双手长柄武器(Polearm)
	 */
	public static final int type_polearm = 13;
	/**
	 * 弓(Bow)
	 */
	public static final int type_bow = 14;
	/**
	 * 十字弓(Crossbow)
	 */
	public static final int type_crossbow = 15;
	/**
	 * 标枪(Javelin)
	 */
	public static final int type_javelin = 16;
	/**
	 * 投掷型武器(Throwing weapon)
	 */
	public static final int type_throw = 17;
	/**
	 * 爪类武器(Claw)
	 */
	public static final int type_claw = 18;
	/**
	 * 单手持
	 */
	public static final int h2h_one_handed = 1;
	/**
	 * 双手持
	 */
	public static final int h2h_two_handed = 0;
	public static final int[] SD_clawslash_left   = {-10,-7,-1,6,14,24,35,49,65};
	public static final int[] SD_clawthrust_right = {-10,-7,-1,6,14,24,35,49,65};
	public static final int[] SD_clawslash_right  = {-10,-9,-2,5,13,24,36,51,70};
	public static final int[] SD_clawcharge_2H    = {-10,-8,-5,-3,0,4,7,11,15,20,25,30,38,45,54,64,76,91};
	public static final int[] SD_clawcharge_1H    = {-10,-9,-6,-3,1,5,11,16,23,30,40,51,64,80,102};
	/**
	 * 不同角色不同武器基础帧数
	 * 0 = amazon
  1 = barbarian
  2 = necromancer
  3 = paladin
  4 = sorceress
  5 = druid - normal
  6 = druid - werewolf
  7 = druid - werebear
  8 = assassin - normal
  9 = assassin - 1 claw
  10 = assassin - 2 claw
  11 = assassin - claw of thunder
	 */
	public static final int[][] baseframes ={
			{13,15,18,14,17,20,19,19,14}, // wand
			{13,15,18,14,17,20,19,19,14}, // scepter
			{13,15,18,14,17,20,19,19,14}, // 1H axe
			{13,15,18,14,17,20,19,19,14}, // orb
			{13,15,18,14,17,20,19,19,14}, // 1H mace
			{13,15,18,14,17,20,19,19,14}, // 1H sword
			{12,15,18,16,16,20,19,19,14}, // dagger
			{17,17,22,17,21,21,21,21,22}, // 2H sword
			{15,18,23,19,20,23,23,23,22}, // spear
			{17,18,19,17,15,17,17,17,18}, // 2H axe
			{17,18,19,17,15,17,17,17,18}, // 2H staff
			{17,18,19,17,15,17,17,17,18}, // 2H mace
			{17,18,19,17,15,17,17,17,18}, // 2H polearm
			{13,14,17,15,16,15,16,16,15}, // bow
			{19,19,19,19,19,19,20,20,20}, // crossbow
			{15,15,19,15,19,17,19,19,14}, // javelin
			{15,15,19,15,19,17,19,19,14}, // throw
			{-1,-1,-1,-1,-1,-1,-1,-1,13,13,18,24} // claw
	};
	/**
	 * 英文名称
	 */
	private String name_en;
	/**
	 * 基础速度
	 */
	private int speed;
	/**
	 * 武器类型
	 */
	private int type;
	/**
	 * 佣兵可以使用
	 */
	private int mercenary;
	/**
	 * 中文名称
	 */
	private String name_zh;
	/**
	 * 角色特有武器
	 */
	private int standby;
	/**
	 * 下标
	 */
	private int index;
	/**
	 * 敏捷系数
	 */
	private int dexCoef;
	/**
	 * 力量系数
	 */
	private int strCoef;
	/**
	 * 最小伤害
	 */
	private int min;
	/**
	 * 最大伤害
	 */
	private int max;
	/**
	 * 第二攻击选择最小伤害 投掷/双手
	 */
	private int minB;
	/**
	 * 第二攻击选择最大伤害 投掷/双手
	 */
	private int maxB;
	/**
	 * 投掷敏捷系数
	 */
	private int dexCoefB;
	/**
	 * 投掷力量系数
	 */
	private int strCoefB;
	/**
	 * 无形
	 */
	private boolean ethereal;
	/**
	 * 投掷
	 */
	private boolean thrown;
	private Weapon(String name_en, int speed, int type, int mercenary, String name_zh, int standby, int dexCoef,
			int strCoef, int min, int max) {
		super();
		this.name_en = name_en;
		this.speed = speed;
		this.type = type;
		this.mercenary = mercenary;
		this.name_zh = name_zh;
		this.standby = standby;
		this.dexCoef = dexCoef;
		this.strCoef = strCoef;
		this.min = min;
		this.max = max;
	}
	/**
	 * 返回 #{bare_field_comment}
	 * @return the name_en
	 */
	public String getName_en() {
		return name_en;
	}

	/**
	 * 返回 #{bare_field_comment}
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 返回 #{bare_field_comment}
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * 返回 #{bare_field_comment}
	 * @return the mercenary
	 */
	public int getMercenary() {
		return mercenary;
	}

	/**
	 * 返回 #{bare_field_comment}
	 * @return the name_zh
	 */
	public String getName_zh() {
		return name_zh;
	}

	/**
	 * 返回 #{bare_field_comment}
	 * @return the standby
	 */
	public int getStandby() {
		return standby;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getDexCoef() {
		return dexCoef;
	}
	
	public int getStrCoef() {
		return strCoef;
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
	
	public int getMinB() {
		return minB;
	}
	
	public int getMaxB() {
		return maxB;
	}
	
	public int getDexCoefB() {
		return dexCoefB;
	}
	
	public int getStrCoefB() {
		return strCoefB;
	}
	
	public boolean isEthereal() {
		return ethereal;
	}
	
	public void setEthereal(boolean ethereal) {
		this.ethereal = ethereal;
	}
	
	public boolean isThrown() {
		return thrown;
	}
	
	public void setThrown(boolean thrown) {
		this.thrown = thrown;
	}
	
	private void setMinB(int minB) {
		this.minB = minB;
	}
	
	private void setMaxB(int maxB) {
		this.maxB = maxB;
	}
	
	private void setDexCoefB(int dexCoefB) {
		this.dexCoefB = dexCoefB;
	}
	
	private void setStrCoefB(int strCoefB) {
		this.strCoefB = strCoefB;
	}
	
	public static List<Weapon> getWeaponList(String str) {
		List<Weapon> weaponList = new ArrayList<>();
		if (str == null) return weaponList;
		str = str.replace("[", "").replace("\"", "");
		String[] weaponStrs = str.split("],");
		for (String weaponStr : weaponStrs) {
			String[] weaponAttrs = weaponStr.split(",|]");
			Weapon weapon = new Weapon(weaponAttrs[0], Integer.parseInt(weaponAttrs[1]), Integer.parseInt(weaponAttrs[2]), Integer.parseInt(weaponAttrs[3]), weaponAttrs[4], Integer.parseInt(weaponAttrs[5]), Integer.parseInt(weaponAttrs[6]), Integer.parseInt(weaponAttrs[7]), Integer.parseInt(weaponAttrs[8]), Integer.parseInt(weaponAttrs[9]));
			if (weaponAttrs.length > 10) {
				weapon.setMinB(Integer.parseInt(weaponAttrs[10]));
				weapon.setMaxB(Integer.parseInt(weaponAttrs[11]));
			}
			if (weaponAttrs.length > 12) {
				weapon.setDexCoefB(Integer.parseInt(weaponAttrs[12]));
				weapon.setStrCoefB(Integer.parseInt(weaponAttrs[13]));
			}
			weaponList.add(weapon);
		}
		return weaponList;
	}
}
