package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>支配之焰</b><BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能</strong>: 无
   <p>　　即使是对法师来说, 火焰的力量有时也不是好相与的. 
   无法预知的火元素对不熟练它的用法的法师来讲是非常危险的. 火焰系的法师们要通过训练的话, 
   必须达到能够支配火焰的最高境界, 这会使火焰伤害达到最大的效果.   
   <p><strong>被动效果</strong>: 提升火焰法术的伤害.                         
   <p> 　　如果你选择火焰技能专精的话, 支配之焰对你是非常有用的. 
   它可以快速地把你的火焰技能的伤害提高到不可思议的程度.
 */
public class FireMastery extends AbstractSkill{

	public FireMastery(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("火焰伤害: ",getFirePercent(),"%<br>");
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
	public int getFirePercent() {
		return ln(lvl(FIRE_MASTERY_ID),30,7);
	}

	@Override
	public int getRequiredLevel() {
		return 30;
	}

}
