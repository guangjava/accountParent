package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>霜之新星</b><BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong> 无
   <p>　　和闪电新星一样, 这项技能在对付大群蜂涌而至的近战敌人时十分有效. 虽然伤害的效果比闪电新星稍小, 
   但能冻住敌人. The radius is the same as that of Nova, 
   about 2/3 of the visible screen.
   <p><strong>效果</strong>: 创造一个冰霜制成的环, 伤害并减慢敌人.
 */
public class FrostNova extends AbstractSkill{

	public FrostNova(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"冰冷伤害: "+getColdMinDamage()+"-"+getColdMaxDamage()+"<br>"
				+"<span color=black>11: </span>"+cc("冰冻时间: ",getFreezeTime()," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"霜之新星 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"暴风雪: +10% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰封球: +10% 冰冷伤害每一技能等级<br>";
	}

	@Override
	public int getRequiredLevel() {
		return 6;
	}

	@Override
	public int getColdMinDamage() {
		return (((ln(lvl(FROST_NOVA_ID),4,4,6,8,10,12)<<7)*(100+((blvl(BLIZZARD_ID)+blvl(FROZEN_ORB_ID))*10))/100)/256);
	}

	@Override
	public int getColdMaxDamage() {
		return ((ln(lvl(FROST_NOVA_ID),8,5,7,9,11,13)<<7)*(100+((blvl(BLIZZARD_ID)+blvl(FROZEN_ORB_ID))*10))/100)/256;
	}

	@Override
	public double getFreezeTime() {
		return dec(ln(lvl(FROST_NOVA_ID),200,25)/25d,1);
	}

	@Override
	public double getManaCost() {
		return ln(lvl(FROST_NOVA_ID),9,1);
	}

}
