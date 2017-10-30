package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>刺入</b><BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link CriticalStrike}致命攻击
   <p>　　传说中亚马逊战士可以通过在武器上做一个神奇的记号来大大提高她们的命中率. 
   <p><strong>被动效果</strong>: 增加准确率. 
   <li>Penetrate only adds half the AR bonus to melee attacks. The full bonus is applied to ranged attacks.
 */
public class Penetrate extends AbstractSkill{

	public Penetrate(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("命中率: ",getAR(),"%<br>");
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
		return new int[]{CRITICAL_STRIKE_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
	}

	@Override
	public int getAR() {
		return ln(lvl(PENETRATE_ID),35,10);
	}

	@Override
	public int getMelleAR() {
		return getAR()/2;
	}

}
