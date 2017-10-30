package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>充能一击</b><BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link Jab}戳刺, {@link PoisonJavelin}毒枪, 
   {@link PowerStrike}威力一击, {@link LightningBolt}闪电球
   <p>　　效忠泽拉依神的亚马逊战士们, 会被赋予复仇和风暴的力量. 在复仇的仪式上, 
   泽拉依会给每个亚马逊战士的武器上附加上闪电和爆炸的力量. 这些元素的力量可以击倒周围的多个敌人. 
   曾经遭遇过困境的老兵说过: 使用长矛的亚马逊女战士在&quot;泽拉依的道路上&quot;会被赋予新生, 
   因为她们的威力和双海上的风暴一样狂猛.   
   <p><strong>效果</strong>: 在标枪或是长矛上面附加闪电性伤害, 并在接触的时候将光弹的能量释放出来.
   <p>　　充能一击可以在你的长矛攻击时附加充能弹.
 */
public class ChargedStrike extends AbstractSkill{

	public ChargedStrike(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>3: </span>"+"释放 "+getCount()+" 闪电弹<br>"
				+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()+"<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"充能一击 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"威力一击: +10% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电球: +10% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电攻击: +10% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电之怒: +10% 闪电伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{JAB_ID,POISON_JAVELIN_ID,POWER_STRIKE_ID,LIGHTNING_BOLT_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_javelin,Weapon.type_spear};
	}

	@Override
	public int getLightningMinDamage() {
		return ((1<<8)*(100+((blvl(LIGHTNING_STRIKE_ID)+blvl(LIGHTNING_BOLT_ID)+blvl(POWER_STRIKE_ID)+blvl(LIGHTNING_FURY_ID))*10))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return ((ln(lvl(CHARGED_STRIKE_ID),30,12,16,20,24,28)<<8)*(100+((blvl(LIGHTNING_STRIKE_ID)+blvl(LIGHTNING_BOLT_ID)+blvl(POWER_STRIKE_ID)+blvl(LIGHTNING_FURY_ID))*10))/100)/256;
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(CHARGED_STRIKE_ID),16,1)<<6)/256d,1);
	}

	@Override
	public int getCount() {
		return 3+lvl(CHARGED_STRIKE_ID)/5;
	}

}
