package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>寒冰装甲</b><BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能:</strong> {@link FrozenArmor}冰封装甲, 
   {@link IceBolt}冰弹, {@link IceBlast}冰风暴, 
   {@link ShiverArmor}碎冰甲
    <p>　　这强大的装甲标明使用者已经拥有了最好的防护法术. 
    这项魔法可以很好地防御远程的攻击, 使箭头和法术无法伤害法师. 
    那些试图攻击法师的蠢货们马上会为它们的愚昧付出代价.   
   <p><strong>效果</strong>: 提供防御的提升并向远处的敌人发射冰弹.
 */
public class ChillingArmor extends AbstractSkill{

	public ChillingArmor(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_DEFENCE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>3: </span>"+"防御加成: "+getDenfencePercent()+"%"
				+"<span color=black>12: </span>"+cc("持续时间: ",getDuration()," 秒 <br>")
				+"<span color=black>10: </span>"+"冰冷伤害: "+getColdMinDamage()+"-"+getColdMaxDamage()
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>11: </span>"+"寒冰装甲 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>67: </span>"+"冰封装甲: +"+10+" 秒 每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰封装甲: +7% 冰冷伤害每一技能等级<br>"
				+"<span color=black>67: </span>"+"碎冰甲: +"+10+" 秒 每一技能等级<br>"
				+"<span color=black>63: </span>"+"碎冰甲: +7% 冰冷伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{FROZEN_ARMOR_ID,ICE_BOLT_ID,ICE_BLAST_ID,SHIVER_ARMOR_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int getColdMinDamage() {
		return ((ln(lvl(CHILLING_ARMOR_ID),8,2,4,6,8,10)<<7)*(100+((blvl(FROZEN_ARMOR_ID)+blvl(SHIVER_ARMOR_ID))*7))/100)/256;
	}

	@Override
	public int getColdMaxDamage() {
		return ((ln(lvl(CHILLING_ARMOR_ID),12,3,5,7,9,11)<<7)*(100+((blvl(FROZEN_ARMOR_ID)+blvl(SHIVER_ARMOR_ID))*7))/100)/256;
	}

	@Override
	public int getDenfencePercent() {
		return ln(lvl(CHILLING_ARMOR_ID),45,5);
	}

	@Override
	public double getManaCost() {
		return 17d;
	}

	@Override
	public double getDuration() {
		return dec((ln(lvl(CHILLING_ARMOR_ID),3600,150)+(blvl(FROZEN_ARMOR_ID)+blvl(SHIVER_ARMOR_ID))*250)/25d,1);
	}

}
