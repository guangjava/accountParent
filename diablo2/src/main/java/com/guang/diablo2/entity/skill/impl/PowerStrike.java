package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>威力一击</b><BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong>: {@link Jab}戳刺 <BR>
        泽拉依是荷法依特斯的妻子. 她是掌管复仇和风暴的神灵. 如果亚马逊战士能够在战斗中证明自身的价值, 
        那么这位女神就会在她的攻击上增加来自南海的闪电与飓风的力量.
   <p><strong>效果</strong>: 标枪和长矛类的武器可以附加闪电伤害.
 */
public class PowerStrike extends AbstractSkill{

	public PowerStrike(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>8: </span>"+cc("命中率: +",getAR(),"%<br>")
		+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()+"<br>"
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"威力一击 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"闪电球: +10% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"充能一击: +10% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电攻击: +10% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电之怒: +10% 闪电伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{JAB_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 6;
	}

	@Override
	public int getAR() {
		return ln(lvl(POWER_STRIKE_ID),LIGHTNING_BOLT_ID,12);
	}

	@Override
	public int getLightningMinDamage() {
		return ((1<<8)*(100+((blvl(LIGHTNING_STRIKE_ID)+blvl(LIGHTNING_BOLT_ID)+blvl(CHARGED_STRIKE_ID)+blvl(LIGHTNING_FURY_ID))*10))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return (((ln(lvl(POWER_STRIKE_ID),16,18,36,54,72,90)<<8)*(100+((blvl(LIGHTNING_STRIKE_ID)+blvl(LIGHTNING_BOLT_ID)+blvl(CHARGED_STRIKE_ID)+blvl(LIGHTNING_FURY_ID))*10))/100)/256);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(POWER_STRIKE_ID),8,1)<<6)/256d,1);
	}
	
	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_javelin,Weapon.type_spear};
	}

}
