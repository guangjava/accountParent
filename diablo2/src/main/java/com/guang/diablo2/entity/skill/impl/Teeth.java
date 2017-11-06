package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>牙</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无
   <p>　　作为拉斯玛的第一项能力, 这项技能允许死灵法师召唤塔奥格或塔格奥龙之牙. 死灵法师们相信, 
   塔格奥是一只背负着整个世界的巨兽. 为了保持世间万物的平衡, 塔格奥被设想为整个世界的支点. 
   它是离拉斯玛的祭礼最近的东西, 这项技能是它用来保护它的选民的.     
   <p><STRONG>效果</STRONG>: 召唤多支弹头来打击敌人. </p>
 */
public class Teeth extends AbstractSkill{

	public Teeth(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+cc("牙齿数量:",getCount(),"<br>")
		+"<span color=black>10: </span>"+"魔法伤害: "+getMagicMinDamage()+"-"+getMagicMaxDamage()+"<br>"
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"牙 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"骨墙: +15% 魔法伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"骨矛: +15% 魔法伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"骨牢: +15% 魔法伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"骨魂: +15% 魔法伤害每一技能等级<br>";
	}

	@Override
	public int getMagicMinDamage() {
		return ((ln(lvl(TEETH_ID),4,2,2,3,4,5)<<7)*(100+((blvl(BONE_WALL_ID)+blvl(BONE_PRISON_ID)+blvl(BONE_SPEAR_ID)+blvl(BONE_SPIRIT_ID))*15))/100)/256;
	}

	@Override
	public int getMagicMaxDamage() {
		return ((ln(lvl(TEETH_ID),8,2,3,4,5,6)<<7)*(100+((blvl(BONE_WALL_ID)+blvl(BONE_PRISON_ID)+blvl(BONE_SPEAR_ID)+blvl(BONE_SPIRIT_ID))*15))/100)/256;
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(TEETH_ID),6,1)<<7)/256d,1);
	}

	@Override
	public int getCount() {
		return min(ln(lvl(TEETH_ID),2,1),24);
	}

}
