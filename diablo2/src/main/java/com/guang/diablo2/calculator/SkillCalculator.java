package com.guang.diablo2.calculator;

import java.util.Map;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.frame.speed.Form;

public class SkillCalculator {
	private Map<Integer, AbstractSkill> skillMap;
	
	public SkillCalculator() {
		super();
		skillMap = AbstractSkill.getSkillMap(Form.properties.getProperty("skillList"));
	}

	public AbstractSkill getSkill(int skillId) {
		return skillMap.get(skillId);
	}
}
