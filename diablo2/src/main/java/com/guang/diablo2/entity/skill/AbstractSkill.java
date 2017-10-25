package com.guang.diablo2.entity.skill;

import java.util.HashMap;
import java.util.Map;

/**
 * @comment 用于技能树
 * @author guang
 * @date 2017年10月25日下午11:21:03
 * @version 1.0.2
 */
public class AbstractSkill {
	private int id;
	private String name_en;
	private String name_zh;
	private String describe;
	
	private AbstractSkill(int id, String name_en, String name_zh, String describe) {
		super();
		this.id = id;
		this.name_en = name_en;
		this.name_zh = name_zh;
		this.describe = describe;
	}

	public static Map<Integer, AbstractSkill> getSkillMap(String str) {
		Map<Integer, AbstractSkill> skillMap = new HashMap<Integer, AbstractSkill>();
		if (str==null || "".equals(str)) {
			return skillMap;
		}
		str = str.replace("[", "").replace("'", "");
		String[] skillList = str.split("],");
		for (String skillStr : skillList) {
			String[] skillAttrs = skillStr.split(",|]");
			int id = Integer.parseInt(skillAttrs[0]);
			AbstractSkill skill = new AbstractSkill(id,skillAttrs[3],skillAttrs[1],skillAttrs[2]);
			skillMap.put(id, skill);
		}
		return skillMap;
	}

	public int getId() {
		return id;
	}

	public String getName_en() {
		return name_en;
	}

	public String getName_zh() {
		return name_zh;
	}

	public String getDescribe() {
		return describe;
	}
}
