package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>新星</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong>: {@link StaticField}静态力场
   <p>　　用这种法术攻击时, 法师从指尖创造出一道带有电系能量的辐射波, 周围的所有敌人会受到破坏性的打击. 
   这项法术用来对付蜂涌而来的近战的敌人十分理想. 
   <p><strong>效果</strong>: 创造一个扩散的电环, 造成大面积的伤害. 
 */
public class Nova extends AbstractSkill{

	public Nova(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()+"<br>"
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
		return new int[]{STATIC_FIELD_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int getLightningMinDamage() {
		return ((ln(lvl(NOVA_ID),1,6,7,8,9,10)<<8)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return ((ln(lvl(NOVA_ID),20,8,9,10,11,12)<<8)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public double getManaCost() {
		return ln(lvl(NOVA_ID),15,1);
	}

}
