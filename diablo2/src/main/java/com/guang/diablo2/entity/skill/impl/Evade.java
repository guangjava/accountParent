package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>回避</b><BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能</strong>: {@link Dodge}闪避, {@link Avoid}躲避
   <p>　　掌握了躲避和闪避技能的勇士将有机会学习这个技能. 通过这个技能, 
   亚马逊战士可以在移动过程中闪避远程攻击和攻城武器的爆炸攻击, 以及法师的魔法攻击. 
   <p><strong>被动效果</strong>: 
   当你在行动或是跑步时有机会回避来袭的近战攻击或飞箭.
   <p>　　这个技能可以帮助角色回避范围性法术效果.   
   <p>　　你不需要投入太多点数在回避. 大多数亚马逊玩家只投入 1 点. 
   后期的提升效果不明显.  
   <p><strong>回避锁定</strong><BR>
        这个技能如果成功施展你将会作出一个躲避的动作而无法移动--
        这在你企图逃离的时候是很危险的. 当然这种情况会很少发生的, 还不足以过于担心. 
 */
public class Evade extends AbstractSkill{

	public Evade(int id, String name_en, String name_zh, String describe) {
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
	public int[] getRequiredSkill() {
		return new int[]{DODGE_ID,AVOID_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int getDodge() {
		return dm(lvl(EVADE_ID),10,65);
	}

	@Override
	public int getDodgeCast() {
		return getDodge();
	}

}
