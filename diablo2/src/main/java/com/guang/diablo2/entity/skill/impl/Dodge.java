package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>闪避</b><BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong>: 无<BR>
       任何熟悉亚马逊战士敏捷身手的人都不会对她们的闪避能力感到惊奇, 这个技能可以避免在战斗中遭到潜在的攻击.
   <p><strong>被动效果</strong>:  你有机会以站立不动的方式在肉搏战中闪避攻击.  
   <p>闪避的时候, 亚马逊身体会向后倾斜以躲避攻击. 
   <p>闪避可以在攻击时发挥作用.  
   <p>这个技能上不要分配太多技能点, 高等级的时候每增长 1 级的效果提升并不明显.
 */
public class Dodge extends AbstractSkill{

	public Dodge(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+getDodge()+"% 概率<br>";
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"</span>";
	}

	@Override
	public int getRequiredLevel() {
		return 6;
	}

	@Override
	public int getDodge() {
		return dm(lvl(DODGE_ID),10,65);
	}

}
