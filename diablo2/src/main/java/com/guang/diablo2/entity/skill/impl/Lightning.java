package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>闪电</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong> {@link ChargedBolt}充能弹
    <p>　　这个魔法使法师能够召唤天界的能量并发射强大的电波. 产生一道闪电直接击中目标, 有相当高的准确度. 
   <p><strong>效果</strong>: 放出一道闪电. 
 */
public class Lightning extends AbstractSkill{

	public Lightning(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()+"<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"闪电 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>40: </span>"+"闪电弹: +8% 闪电伤害每一技能等级<br>"
				+"<span color=black>40: </span>"+"新星: +8% 闪电伤害每一技能等级<br>"
				+"<span color=black>40: </span>"+"连锁闪电: +8% 闪电伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{CHARGED_BOLT_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int getLightningMinDamage() {
		return (((1<<8)*(100+((blvl(CHARGED_BOLT_ID)+blvl(CHAIN_LIGHTNING_ID)+blvl(NOVA_ID))*8))/100)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return (((ln(lvl(LIGHTNING_ID),40,8,12,20,28,36)<<8)*(100+((blvl(CHARGED_BOLT_ID)+blvl(CHAIN_LIGHTNING_ID)+blvl(NOVA_ID))*8))/100)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(LIGHTNING_ID),16,1)<<7)/256d,1);
	}

}
