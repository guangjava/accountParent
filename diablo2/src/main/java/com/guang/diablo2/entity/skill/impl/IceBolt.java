package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>冰弹</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无
   <p>　　新手级的冰系法术之一是产生带有冰冷能量的水晶. 当这水晶击中敌人时, 
   将使之受到寒冷的痛苦并减缓它的动作.   
   <p><STRONG>效果</STRONG>: 发射一个冰球, 伤害并减慢目标.</p>
   <p>　　低级技能中相当有用的一项, 在冰弹上投放更多的技能点之前, 记住当 6 级时可以使用冰风暴. 
   你可以找个加冰弹的法杖来增加这项技能的等级. 冰风暴会冻结目标并将之击碎, 这样其他的怪物将无法复活它们.</p>
 */
public class IceBolt extends AbstractSkill{

	public IceBolt(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"冰冷伤害: "+getColdMinDamage()+"-"+getColdMaxDamage()
				+"<span color=black>11: </span>"+cc("冰冻时间: ",getFreezeTime()," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"冰弹 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"霜之新星: +15% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰风暴: +15% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰矛: +15% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"暴风雪: +15% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰封球: +15% 冰冷伤害每一技能等级<br>";
	}

	@Override
	public int getColdMinDamage() {
		return ((ln(lvl(ICE_BOLT_ID),6,2,4,6,8,10)<<7)*(100+((blvl(FROST_NOVA_ID)+blvl(ICE_BLAST_ID)+blvl(GLACIAL_SPIKE_ID)+blvl(BLIZZARD_ID)+blvl(FROZEN_ORB_ID))*15))/100)/256;
	}

	@Override
	public int getColdMaxDamage() {
		return ((ln(lvl(ICE_BOLT_ID),10,3,5,7,9,11)<<7)*(100+((blvl(FROST_NOVA_ID)+blvl(ICE_BLAST_ID)+blvl(GLACIAL_SPIKE_ID)+blvl(BLIZZARD_ID)+blvl(FROZEN_ORB_ID))*15))/100)/256;
	}

	@Override
	public double getManaCost() {
		return 3d;
	}

	@Override
	public double getFreezeTime() {
		return dec(ln(lvl(ICE_BOLT_ID),150,35)/25d,1);
	}

}
