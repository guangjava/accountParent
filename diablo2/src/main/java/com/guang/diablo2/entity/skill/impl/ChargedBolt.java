package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>闪电弹</b>
 */
public class ChargedBolt extends AbstractSkill{

	public ChargedBolt(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return "";
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return "";
	}

}