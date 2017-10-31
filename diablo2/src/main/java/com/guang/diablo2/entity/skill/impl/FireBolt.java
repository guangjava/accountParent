package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>火弹</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无
   <p>　　火弹年轻法师在开始探险的旅途前所必须学会的咒语之一. 通过聚集少量的元素能量, 
   法师可以向妄图伤害她的人投掷火球.   
   <p><STRONG>效果</STRONG>: 创造一个火焰小球.</p>
   <p>　　在低等级的技能中十分好用. 法师开始游戏时会配有一个 +1 火弹的法杖.</p>
   <p>　　记住在 12 级时可以升出火球这项技能, 不要在火弹上放更高的技能点.</p>
 */
public class FireBolt extends AbstractSkill{

	public FireBolt(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"火焰伤害: "+getFireMinDamage()+"-"+getFireMaxDamage()+"<br>";
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"火弹 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"火球: +16% 火焰伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"陨石: +16% 火焰伤害每一技能等级<br>";
	}

	@Override
	public int getFireMinDamage() {
		return (((ln(lvl(FIRE_BOLT_ID),6,3,4,8,18,54)<<7)*(100+((blvl(FIREBALL_ID)+blvl(METEOR_ID))*16))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public int getFireMaxDamage() {
		return (((ln(lvl(FIRE_BOLT_ID),12,3,6,10,20,METEOR_ID)<<7)*(100+((blvl(FIREBALL_ID)+blvl(METEOR_ID))*16))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public double getManaCost() {
		return 2.5d;
	}

}
