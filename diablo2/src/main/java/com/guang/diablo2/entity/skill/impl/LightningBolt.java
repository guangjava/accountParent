package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>闪电球</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong>: {@link PoisonJavelin}毒枪
   <p>　　如果一个亚马逊战士证明了她的价值, 那么泽拉依神会赋予她的标枪以雷电的魔力, 
   就好像她能抓住天空中的闪电一般.
   <p><strong>效果</strong>: 魔法般的把你的标枪变成一个闪电球.  
 */
public class LightningBolt extends AbstractSkill{

	public LightningBolt(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>73: </span>"+(3)+"/"+(4)+" 武器伤害<br>"
				+"<span color=black>66: </span>"+"转变 "+getConvertLightningDamage()+"% 物理伤害为元素伤害<br>";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"闪电球 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"威力一击: +3% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"充能一击: +3% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电攻击: +3% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电之怒: +3% 闪电伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{POISON_JAVELIN_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_javelin};
	}

	@Override
	public int getAttackType() {
		return 1;
	}

	@Override
	public int getLightningMinDamage() {
		return ((1<<8)*(100+((blvl(LIGHTNING_STRIKE_ID)+blvl(POWER_STRIKE_ID)+blvl(CHARGED_STRIKE_ID)+blvl(LIGHTNING_FURY_ID))*3))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return ((ln(lvl(LIGHTNING_BOLT_ID),40,12,18,28,48,88)<<8)*(100+((blvl(LIGHTNING_STRIKE_ID)+blvl(POWER_STRIKE_ID)+blvl(CHARGED_STRIKE_ID)+blvl(LIGHTNING_FURY_ID))*3))/100)/256;
	}

	@Override
	public int getConvertLightningDamage() {
		return 100;
	}

	@Override
	public int getPunish() {
		return 75;
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(LIGHTNING_BOLT_ID),24,1)<<6)/256d,1);
	}

}
