package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>闪电之怒</b><BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能</strong>: {@link PoisonJavelin}毒枪, {@link LightningBolt}闪电球, 
   {@link PlagueJavelin}瘟疫标枪
   <p>　　这个技能应该是亚马逊族闪电系魔法中最具威力, 最壮观的一个魔法, 
   女神泽拉依挑选出最为强大的亚马逊战士传授这个技能. 它使得标枪成为复仇的最终武器, 
   这种无敌的力量使得标枪击中目标之后会爆发出无数的闪电球, 打倒周围所有的敌人. 当然, 
   只有最杰出的亚马逊女战士才能拥有这一技能.   
   <p><strong>效果</strong>: 把投掷性的标枪变成一个威力强大的闪电之球, 并在撞击时自动散开. 
   <p>　　闪电之怒会朝周围的每个怪物释放出一定数量的闪电球. 放出弹数的最大数量取决于你的技能等级. 
   放出弹数的最小数量由范围内的怪物数量决定. 如果有穿刺效果, 那么第二次释放会产生更强大的效果.
 */
public class LightningFury extends AbstractSkill{

	public LightningFury(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>3: </span>"+"释放 "+dec(ln(lvl(LIGHTNING_FURY_ID),2,1),0)+" 闪电球<br>"
				+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"闪电之怒 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"威力一击: +1% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电球: +1% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"充能一击: +1% 闪电伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"闪电攻击: +1% 闪电伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{POISON_JAVELIN_ID,LIGHTNING_BOLT_ID,PLAGUE_JAVELIN_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 30;
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
		return (256*(100+((blvl(CHARGED_STRIKE_ID)+blvl(LIGHTNING_BOLT_ID)+blvl(POWER_STRIKE_ID)+blvl(LIGHTNING_STRIKE_ID))*1))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return ((ln(lvl(LIGHTNING_FURY_ID),40,20,30,40,50)<<8)*(100+((blvl(CHARGED_STRIKE_ID)+blvl(LIGHTNING_BOLT_ID)+blvl(POWER_STRIKE_ID)+blvl(LIGHTNING_STRIKE_ID))*1))/100)/256;
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(LIGHTNING_FURY_ID),20,1)<<7)/256d,1);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return super.getCount();
	}

}
