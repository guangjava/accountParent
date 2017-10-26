package com.guang.diablo2.entity.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.guang.diablo2.frame.speed.Option;

public class Character {
	/**
	 * 亚马逊(Amazon)
	 */
	public static final int CHAR_AMA = 0;
	/**
	 * 野蛮人(Barbarian)
	 */
	public static final int CHAR_BAR = 1;
	/**
	 * 死灵法师(Necromancer)
	 */
	public static final int CHAR_NEC = 2;
	/**
	 * 圣骑士(Paladin)
	 */
	public static final int CHAR_PAL = 3;
	/**
	 * 法师(Sorceress)
	 */
	public static final int CHAR_SOR = 4;
	/**
	 * 德鲁伊(Druid)
	 */
	public static final int CHAR_DRU = 5;
	/**
	 * 刺客(Assassin)
	 */
	public static final int CHAR_ASN = 6;
	/**
	 * 佣兵(Mercenary) - Act 2
	 */
	public static final int CHAR_ACT2 = 7;
	/**
	 * 佣兵(Mercenary) - Act 1
	 */
	public static final int CHAR_ACT1 = 8;
	/**
	 * 佣兵(Mercenary) - Act 5
	 */
	public static final int CHAR_ACT5 = 9;
	/**
	 * 佣兵(Mercenary) - Act 2戳刺ias档位
	 */
	public static final int[] SD_act2_jab         = {-20,-17,-12,-6,0,8,17,28,42,56,75};
	public static final int[] SD_act1_standard    = {-10,-6,0,8,16,25,37,50,67};
	public static final int[] SD_act5_standard    = {-20,-19,-15,-10,-5,0,8,15,24,34,46,61};
	private int id;
	private String name;
	private int strength;
	private int dexterity;
	private Map<Integer, Integer[]> skillLevelMap;
	
	public Character(Option uchar,int strength,int dexterity){
		id = uchar.getValue();
		name = uchar.getLable();
		this.strength = strength;
		this.dexterity = dexterity;
		skillLevelMap = new HashMap<>();
	}

	public int getStrength() {
		return strength;
	}
	

	public void setStrength(int strength) {
		this.strength = strength;
	}
	

	public int getDexterity() {
		return dexterity;
	}
	

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getId() {
		return id;
	}
	

	public String getName() {
		return name;
	}
	
	public void setUchar(Option uchar) {
		id = uchar.getValue();
		name = uchar.getLable();
	}
	
	public int getSkillLevel(int skillId) {
		Integer[] level = skillLevelMap.get(skillId);
		if (level != null) {
			return level[0]+level[1];
		}else {
			return 0;
		}
	}
	
	public int getBasicSkillLevel(int skillId) {
		Integer[] level = skillLevelMap.get(skillId);
		if (level != null) {
			return level[0];
		}else {
			return 0;
		}
	}
	
	public void setBasicSkillLevel(int skillId,int value) {
		Integer[] level = skillLevelMap.get(skillId);
		if (level == null) {
			level = new Integer[2];
			level[0] = 0;
			level[1] = 0;
			skillLevelMap.put(skillId, level);
		}
		level[0] = value;
	}
	
	public int getPlusSkillLevel(int skillId) {
		Integer[] level = skillLevelMap.get(skillId);
		if (level != null) {
			return level[1];
		}else {
			return 0;
		}
	}
	
	public void setPlusSkillLevel(int skillId,int value) {
		Integer[] level = skillLevelMap.get(skillId);
		if (level == null) {
			level = new Integer[2];
			level[0] = 0;
			level[1] = 0;
			skillLevelMap.put(skillId, level);
		}
		level[1] = value;
	}
	
	public int getBasicSkillLevelSum() {
		int sum = 0;
		Collection<Integer[]> values = skillLevelMap.values();
		for (Integer[] level : values) {
			sum += level[0];
		}
		return sum;
	}
	
	public Map<String, String> toMap() {
		Map<String, String> charMap = new HashMap<>();
		charMap.put("名称", getName());
		charMap.put("力量", getStrength()+"");
		charMap.put("敏捷", getDexterity()+"");
		return charMap;
	}
}
