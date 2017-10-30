package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>击退</b><BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能</strong>: {@link Jab}戳刺, {@link Impale}刺爆
   <p>　　一旦当亚马逊战士能够熟练使用标枪的时候, 
   她就能同时应付多个敌人并且在短时间内解决他们. 
   有些敌人会在遭受这种致命打击后侥幸存活下来. 
   塞里斯蒂娜夫人就能证明是奥苏拉神在一次面对众多对手的时候第一次使用这个技能的.   
   <p><strong>效果</strong>: 攻击所有邻近的目标. 
 */
public class Fend extends AbstractSkill{

	public Fend(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("准确率: ",getAR(),"%<br>")
				+"<span color=black>2: </span>"+cc("伤害: ",getSkillED(),"%<br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",dec(max(ln(lvl(FEND_ID),5,0)<<8,1<<8)/256,1),"<br>");
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
		return new int[]{JAB_ID,IMPALE_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_spear,Weapon.type_javelin};
	}

	@Override
	public int getAR() {
		return ln(lvl(FEND_ID),40,10);
	}

	@Override
	public int getSkillED() {
		return ln(lvl(FEND_ID),70,10);
	}

	@Override
	public double getManaCost() {
		return 5d;
	}

}
