package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>闪电攻击</b><BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能</strong>: {@link Jab}戳刺, {@link PoisonJavelin}毒枪, 
   {@link PowerStrike}威力一击, {@link LightningBolt}闪电球, {@link ChargedStrike}充能一击
   <p>　　这是对泽拉依神绝对忠诚的亚马逊战士才能使用的技能. 她们能够很好的利用闪电的威力, 
   召唤出泽拉依女神来摧毁敌人, 释放出连锁闪电来攻击敌人. 
   <p><strong>效果</strong>: 在标枪或是长矛类的武器加上闪电力量, 并在撞击时自动施放出来. 
   <p>　　这个技能允许你使用长矛或标枪类武器施展连锁闪电技能.   
 */
public class LightningStrike extends AbstractSkill{

	public LightningStrike(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+getCount()+" 次"
				+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"闪电攻击 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"威力一击: +8% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电球: +8% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"充能一击: +8% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电之怒: +8% 闪电伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{JAB_ID,POISON_JAVELIN_ID,POWER_STRIKE_ID,LIGHTNING_BOLT_ID,CHARGED_STRIKE_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 30;
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_javelin,Weapon.type_spear};
	}

	@Override
	public int getLightningMinDamage() {
		return (256*(100+((blvl(CHARGED_STRIKE_ID)+blvl(LIGHTNING_BOLT_ID)+blvl(POWER_STRIKE_ID)+blvl(LIGHTNING_FURY_ID))*8))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return ((ln(lvl(LIGHTNING_STRIKE_ID),25,10,15,20,25,30)<<8)*(100+((blvl(CHARGED_STRIKE_ID)+blvl(LIGHTNING_BOLT_ID)+blvl(POWER_STRIKE_ID)+blvl(LIGHTNING_FURY_ID))*8))/100)/256;
	}

	@Override
	public double getManaCost() {
		return 9d;
	}

	@Override
	public int getCount() {
		return ln(lvl(LIGHTNING_STRIKE_ID),2,1);
	}

}
