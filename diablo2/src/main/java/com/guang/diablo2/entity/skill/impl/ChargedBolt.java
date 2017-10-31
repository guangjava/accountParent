package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>充能弹</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong> 无
   <p>　　通过给周围的空气离子注入法力, 法师会放出爆裂性的闪电力量. 这些弹头四处乱窜, 追击并打击敌人. 
   <p><strong>效果</strong>: 发射多个弹头, 跳跃的闪电能量会自己寻找并打击目标.
 */
public class ChargedBolt extends AbstractSkill{

	public ChargedBolt(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()+"<br>"
				+"<span color=black>7: </span>"+"数量 "+getCount()+"<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"充能弹 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"闪电: +6% 闪电伤害每一技能等级<br>";
	}

	@Override
	public int getLightningMinDamage() {
		return (((ln(lvl(CHARGED_BOLT_ID),4,1,1,2,3,4)<<7)*(100+(blvl(LIGHTNING_ID)*6))/100)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return (((ln(lvl(CHARGED_BOLT_ID),8,1,1,2,3,4)<<7)*(100+(blvl(LIGHTNING_ID)*6))/100)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public double getManaCost() {//RENAME 20级消耗
		return dec((ln(lvl(CHARGED_BOLT_ID),24,4)<<5)/256d,1);
	}

	@Override
	public int getCount() {
		return min(24,ln(lvl(CHARGED_BOLT_ID),3,1));
	}

}
