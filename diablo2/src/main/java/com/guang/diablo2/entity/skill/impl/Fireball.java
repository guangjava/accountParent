package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>火球</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong>: {@link FireBolt}火弹
   <p>　　一旦法师掌握了这项魔法的基本咒语, 她就可以聚集大量的火元素并将它们包裹在一个能量球中. 
   把这个球投向敌人时, 这些能量会在一次毁灭性的爆炸中施放. 这个强大的技能特别适合在敌人密集的时候使用.   
   <p><strong>效果</strong>: 产生一个火球, 在撞击中爆炸.
 */
public class Fireball extends AbstractSkill{

	public Fireball(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"火焰伤害: "+getFireMinDamage()+"-"+getFireMaxDamage()+"<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>28: </span>"+"半径: 1 码<br>";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"火球 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"火弹: +14% 火焰伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"陨石: +14% 火焰伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{FIRE_BOLT_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int getFireMinDamage() {
		return (((ln(lvl(FIREBALL_ID),12,13,23,28,33,38)<<7)*(100+((blvl(FIRE_BOLT_ID)+blvl(METEOR_ID))*14))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public int getFireMaxDamage() {
		return (((ln(lvl(FIREBALL_ID),28,15,25,30,35,40)<<7)*(100+((blvl(FIRE_BOLT_ID)+blvl(METEOR_ID))*14))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(FIREBALL_ID),10,1)<<7)/256d,1);
	}

	@Override
	public double getRadius() {
		return 1;
	}

}
