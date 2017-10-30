package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>瘟疫标枪</b><BR>
   <strong>施放延迟</A></strong>: 4 秒   <BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link PoisonJavelin}毒枪 , {@link LightningBolt}闪电球
   <p>　　有经验的亚马逊战士可以利用有毒植物和野生生物的器官制造一种传染性强, 并能产生致命水疱的毒药, 
   然后把它们涂在自己的标枪上. 当标枪命中目标的时候会散发出腐蚀性的毒雾, 迅速的杀死目标. 
   这种毒素攻击甚至能够杀死最强悍的敌人.  
   <p><strong>效果</strong>: 在撞击时魔法般的从你的标枪爆出毒气烟雾.
 */
public class PlagueJavelin extends AbstractSkill{

	public PlagueJavelin(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("命中率: ",getAR(),"%<br>")
		+"<span color=black>14: </span>"+"毒素伤害: "+getPoisonMinDamage()+"-"+getPoisonMaxDamage()+"<br>结束于 "+getDuration()+" 秒 <br>"
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"瘟疫标枪 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"毒枪: +10% 毒素伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{POISON_JAVELIN_ID,LIGHTNING_BOLT_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
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
	public int getPoisonMinDamage() {
		return ((ln(lvl(PLAGUE_JAVELIN_ID),10,6,12,20,40,60)<<3)*(100+(blvl(POISON_JAVELIN_ID)*10))/100)*ln(lvl(PLAGUE_JAVELIN_ID),75,10)/256;
	}

	@Override
	public int getPoisonMaxDamage() {
		return ((ln(lvl(PLAGUE_JAVELIN_ID),16,6,12,20,40,60)<<3)*(100+(blvl(POISON_JAVELIN_ID)*10))/100)*ln(lvl(PLAGUE_JAVELIN_ID),75,10)/256;
	}

	@Override
	public int getAR() {
		return ln(lvl(PLAGUE_JAVELIN_ID),30,9);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(PLAGUE_JAVELIN_ID),14,1)<<7)/256d,1);
	}

	@Override
	public double getDuration() {
		return dec(ln(lvl(PLAGUE_JAVELIN_ID),75,10)/25d,1);
	}

	@Override
	public double getCastingDelay() {
		return 4d;
	}

}
