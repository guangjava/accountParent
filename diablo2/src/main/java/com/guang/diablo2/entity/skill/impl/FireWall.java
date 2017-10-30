package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>火墙</b>
 */
public class FireWall extends AbstractSkill{

	public FireWall(int id, String name_en, String name_zh, String describe) {
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
