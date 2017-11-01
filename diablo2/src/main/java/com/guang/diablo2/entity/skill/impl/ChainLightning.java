package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>连锁闪电</b><BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link ChargedBolt}充能弹, {@link Lightning}闪电
   <p>　　经过加强和复杂化的闪电法术版本, 连锁闪电产生的电弧从一个敌人跃至下一个, 直到能量消散为止. 
   施法之后的空气中会留下烧焦的肢体的恶臭及臭氧的气息. 
   <p><strong>效果</strong>: 施放连锁的闪电, 打击多个目标.
 */
public class ChainLightning extends AbstractSkill{

	public ChainLightning(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+"电击次数: "+getCount()+"<br>"
				+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()+"<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"连锁闪电 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>11: </span>"+"闪电弹: +4% 闪电伤害每一技能等级<br>"
				+"<span color=black>11: </span>"+"新星: +4% 闪电伤害每一技能等级<br>"
				+"<span color=black>11: </span>"+"闪电: +4% 闪电伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{CHARGED_BOLT_ID,LIGHTNING_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
	}

	@Override
	public int getLightningMinDamage() {
		return (((1<<8)*(100+((blvl(CHARGED_BOLT_ID)+blvl(LIGHTNING_ID)+blvl(NOVA_ID))*4))/100)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return (((ln(lvl(CHAIN_LIGHTNING_ID),40,11,13,15)<<8)*(100+((blvl(CHARGED_BOLT_ID)+blvl(LIGHTNING_ID)+blvl(NOVA_ID))*4))/100)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public double getManaCost() {
		return ln(lvl(CHAIN_LIGHTNING_ID),9,1);
	}

	@Override
	public int getCount() {
		return ln(lvl(CHAIN_LIGHTNING_ID),26,1)/5;
	}

}
