package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * 魔法箭
 */
public class MagicArrow extends AbstractSkill{

	public MagicArrow(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>66: </span>"+"转化 "+(1+(lvl(6)-1)*1)+"% 物理伤害为元素伤害<br>"
				+"<span color=black>8: </span>"+cc("命中率: +",ln(lvl(6),10,9),"%<br>")
				+"<span color=black>9: </span>"+cc("伤害: +",dec((lvl(6)<<8)/256d,0),"<br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",dec(max(ln(lvl(6),12,-1)<<5,0)/256d,1),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"</span>";
	}

}
