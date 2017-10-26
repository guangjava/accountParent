package com.guang.diablo2.calculator;

import java.util.Map;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.frame.speed.Form;

public class SkillCalculator {
	private static Map<Integer, AbstractSkill> skillMap;
	static{
		skillMap = AbstractSkill.getSkillMap(Form.properties.getProperty("skillList"));
	}
	public SkillCalculator() {
		super();
		
	}

	public static AbstractSkill getSkill(int skillId) {
		return skillMap.get(skillId);
	}
}
