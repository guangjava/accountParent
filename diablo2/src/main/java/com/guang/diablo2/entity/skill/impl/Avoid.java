package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>躲避</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong>: {@link Dodge}闪避
   <p>　　这个技能是亚马逊族与生具来的本领. 当她站立不动的时候, 她能预测远程攻击的到来并及时的躲避, 
   大多数的亚马逊都能做到这一点, 但是只有一小部分亚马逊战士才能在下意识中进行躲避.   
   <p><strong>被动效果</strong>: 有机会以站立不动的方式躲开敌人的飞射攻击.   
   <p>　　躲避可以在攻击时发挥作用.  
   <p>　　这个技能上不要分配太多技能点, 高等级的时候每增长 1 级的效果提升并不明显.
 */
public class Avoid extends AbstractSkill{

	public Avoid(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+getDodgeCast()+"% 概率<br>";
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
	public int[] getRequiredSkill() {
		return new int[]{DODGE_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int getDodgeCast() {
		return dm(lvl(AVOID_ID),15,75);
	}

}
