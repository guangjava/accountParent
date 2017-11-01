package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>碎冰甲</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong>: {@link FrozenArmor}冰封装甲, {@link IceBolt}冰弹, 
   {@link IceBlast}冰风暴
   <p>　　冰封装甲的一项重要升级, 这个防御盾牌将向敌人发射冰弹, 使之受到冰冷的伤害. 
   <p><strong>效果</strong>: 防御提升, 伤害并减慢击中你的敌人.
 */
public class ShiverArmor extends AbstractSkill{

	public ShiverArmor(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>12: </span>"+cc("持续时间: ",getDuration()," 秒 ")
		+"<span color=black>3: </span>"+"防御加成: "+getDenfencePercent()+"%<br>"
		+"<span color=black>10: </span>"+"冰冷伤害: "+getColdMinDamage()+"-"+getColdMaxDamage()
		+"<span color=black>11: </span>"+cc("冰冻时间: ",getFreezeTime()," 秒 <br>")
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>24: </span>"+"碎冰甲 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>67: </span>"+"冰封装甲: +"+10+" 秒 每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰封装甲: +9% 冰冷伤害每一技能等级<br>"
				+"<span color=black>67: </span>"+"寒冰装甲: +"+10+" 秒 每一技能等级<br>"
				+"<span color=black>63: </span>"+"寒冰装甲: +9% 冰冷伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{FROZEN_ARMOR_ID,ICE_BOLT_ID,ICE_BLAST_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int getColdMinDamage() {//RENAME 20级伤害
		return ((ln(lvl(SHIVER_ARMOR_ID),12,4,6,8,10,12)<<7)*(100+((blvl(FROZEN_ARMOR_ID)+blvl(CHILLING_ARMOR_ID))*9))/100)/256;
	}

	@Override
	public int getColdMaxDamage() {//RENAME 20级伤害
		return ((ln(lvl(SHIVER_ARMOR_ID),16,5,7,9,11,13)<<7)*(100+((blvl(FROZEN_ARMOR_ID)+blvl(CHILLING_ARMOR_ID))*9))/100)/256;
	}

	@Override
	public double getFreezeTime() {//RENAME 20级时间
		return dec((ln(lvl(SHIVER_ARMOR_ID),100,0,25,50))/25d,1);
	}

	@Override
	public int getDenfencePercent() {
		return ln(lvl(SHIVER_ARMOR_ID),45,6);
	}

	@Override
	public double getManaCost() {
		return 11d;
	}

	@Override
	public double getDuration() {//RENAME 1级时间
		return dec((ln(lvl(SHIVER_ARMOR_ID),3000,300)+(blvl(FROZEN_ARMOR_ID)+blvl(CHILLING_ARMOR_ID))*250)/25d,1);
	}

}
