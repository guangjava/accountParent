package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>炽烈之径</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong>: {@link Inferno}地狱之火
   <p>　　使用这项法术，法师会点燃她在上面行走的土地，在身后留下一道燃烧的火墙。
   <p><STRONG>效果</STRONG>: 随着你的脚步留下火墙.
   <p>　　许多傻乎乎的生物(尤其是不死系的)会紧跟着你跑, 直到在你的炽烈之径里被烧成烟.</p>
 */
public class Blaze extends AbstractSkill{

	public Blaze(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>23: </span>"+cc("火焰持续时间: ",getDuration()," 秒 <br>")
		+"<span color=black>27: </span>"+"平均火焰伤害: "+getFireDurationMinDamage()+"-"+getFireDurationMaxDamage()+" 每秒 <br>"
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"</span>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{INFERNO_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int getFireDurationMinDamage() {
		return ((ln(lvl(BLAZE_ID),4,2,3,4,6,9)<<4)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)*75/256;
	}

	@Override
	public int getFireDurationMaxDamage() {
		return ((ln(lvl(BLAZE_ID),8,2,3,4,6,9)<<4)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)*75/256;
	}

	@Override
	public double getManaCost() {//RENAME 20级魔法消耗
		return dec((ln(lvl(BLAZE_ID),22,1)<<7)/256d,1);
	}

	@Override
	public double getDuration() {
		return dec(ln(lvl(BLAZE_ID),115,25)/25d,1);
	}

}
