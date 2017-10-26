package com.guang.diablo2.entity.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.guang.diablo2.calculator.SkillCalculator;
import com.guang.diablo2.frame.skill.SkillTree;
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
	private int[] tabPlusSkillLevel = {0,0,0};
	private int charPlusSKillLevel = 0;
	
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
	
	public int getSkillLevel(int skillId, int tabId) {
		int sum = charPlusSKillLevel + tabPlusSkillLevel[tabId];
		Integer[] level = skillLevelMap.get(skillId);
		if (level != null) {
			return sum+level[0]+level[1];
		}else {
			return sum;
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
	
	public int getTabPlusSkillLevel(int n) {
		return tabPlusSkillLevel[n];
	}
	
	public void setTabPlusSkillLevel(int n,int value) {
		tabPlusSkillLevel[n] = value;
	}
	
	public int getCharPlusSKillLevel() {
		return charPlusSKillLevel;
	}

	public void setCharPlusSKillLevel(int charPlusSKillLevel) {
		this.charPlusSKillLevel = charPlusSKillLevel;
	}

	public int getBasicSkillLevelSum() {
		int sum = 0;
		Collection<Integer[]> values = skillLevelMap.values();
		for (Integer[] level : values) {
			sum += level[0];
		}
		return sum;
	}
	
	public int getBasicSkillLevelTabSum(int tabId) {
		int sum = 0;
		Integer[] tabSkills = SkillTree.getInstance().getTabTreeDiv(tabId);
		for (Integer skill : tabSkills) {
			if (skill > 0) {
				Integer[] level = skillLevelMap.get(skill);
				if (level != null) {
					sum+=level[0];
				}
			}
		}
		return sum;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> charMap = new HashMap<>();
		charMap.put("名称", getName());
		charMap.put("力量", getStrength()+"");
		charMap.put("敏捷", getDexterity()+"");
		if (charPlusSKillLevel > 0) {
			charMap.put("角色技能增加", charPlusSKillLevel + "");
		}
		String[] tabNames = SkillTree.getTabNames(id);
		for(int i=0; i<3; i++){
			if (tabPlusSkillLevel[i] > 0) {
				charMap.put(tabNames[i].replace("<br>", "")+"增加", tabPlusSkillLevel[i]+"");
			}
		}
		Map<String, Map<String, String>> skillMap = new HashMap<String, Map<String,String>>();
		for(Entry<Integer, Integer[]> entry : skillLevelMap.entrySet()){
			Integer[] value = entry.getValue();
			if (value!=null && (value[0]>0 || value[1]>0)) {
				int skillId = entry.getKey();
				String name_en = SkillCalculator.getSkill(skillId).getName_en();
				Map<String, String> skill = new HashMap<String, String>();
				if (value[0] > 0) {
					skill.put("基本", value[0]+"");
				}
				if (value[1] > 0) {
					skill.put("装备增加", value[1]+"");
				}
				skillMap.put(name_en, skill);
			}
		}
		charMap.put("技能", skillMap);
		return charMap;
	}
}
