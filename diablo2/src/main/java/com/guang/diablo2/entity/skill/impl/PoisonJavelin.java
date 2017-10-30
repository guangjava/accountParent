package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>毒枪</b><BR>
   <strong>施放延迟</A></strong>: 0.5 秒   <BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong>: 无
    <p>　　亚马逊的巫医很早以前就发现一些天然植物带有很大的毒性, 
    一些学习这些技能的亚马逊战士发现这些植物的毒性所拥有的致命力量, 并把它带入战场, 制造出有毒的标枪.
    <p><strong>效果</strong>: 你的标枪会魔法般的留下毒气云雾.
 */
public class PoisonJavelin extends AbstractSkill{

	public PoisonJavelin(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>14: </span>"+"毒素伤害: "+getPoisonMinDamage()+"-"+getPoisonMaxDamage()+"<br>结束于 "+getDuration()+" 秒 <br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"毒枪 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"瘟疫标枪: +12% 毒素伤害每一技能等级<br>";
	}

	@Override
	public double getCastingDelay() {
		return 0.5;
	}

	@Override
	public int getRequiredLevel() {
		return 6;
	}

	@Override
	public int getPoisonMinDamage() {
		return ((ln(lvl(POISON_JAVELIN_ID),32,16,32,48,64,96)*(100+(blvl(PLAGUE_JAVELIN_ID)*12))/100)*ln(lvl(POISON_JAVELIN_ID),200,50)/256);
	}

	@Override
	public int getPoisonMaxDamage() {
		return ((ln(lvl(POISON_JAVELIN_ID),48,16,36,52,68,84)*(100+(blvl(PLAGUE_JAVELIN_ID)*12))/100)*ln(lvl(POISON_JAVELIN_ID),200,50)/256);
	}

	@Override
	public double getDuration() {
		return dec(ln(lvl(POISON_JAVELIN_ID),200,50)/25d,1);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(POISON_JAVELIN_ID),16,1)<<6)/256d,1);
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_javelin};
	}

	@Override
	public int getAttackType() {
		return 1;
	}
}
