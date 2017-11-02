package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>支配闪电</b><BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能</strong>: 无
   <p>　　掌握这项来自天界的破坏性能量的最终步骤, 
   这技能让法师能够更好地控制和掌握她的能量. 一旦她的修习达到了这个地步, 
   她就可以直接与天界的力量对抗了.
   <p><strong>被动效果</strong>: 提升闪电法术伤害.   
   <p>　　支配闪电可以提升你所有闪电法术的伤害. 
 */
public class LightningMastery extends AbstractSkill{

	public LightningMastery(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("闪电伤害: ",getLightningPercent(),"%<br>");
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
	public int getRequiredLevel() {
		return 30;
	}

	@Override
	public int getLightningPercent() {
		return ln(lvl(LIGHTNING_MASTERY_ID),50,12);
	}

}
