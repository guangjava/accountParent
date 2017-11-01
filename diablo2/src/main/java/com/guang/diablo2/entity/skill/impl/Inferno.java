package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>地狱之火</b><BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong>: 无
   <p>　　使用这项法术, 法师可以发挥她最大的极限, 放出一团火焰, 
   烧焦魔法可以到达范围内的敌人. 
   <p><strong>效果</strong>: 施放一团火焰焚化敌人.
 */
public class Inferno extends AbstractSkill{

	public Inferno(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>26: </span>"+"平均火焰伤害: "+getFireDurationMinDamage()+"-"+getFireDurationMaxDamage()+" 每秒 <br>"
				+"<span color=black>19: </span>"+"射程: "+getRadius()+" 码<br>"
				+"<span color=black>3: </span>"+"魔法消耗: "+getManaCost()+" 每秒 <br>";
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>5: </span>"+"最低魔法需求: "+6+"<br>";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"地狱之火 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"热情: +13% 火焰伤害每一技能等级<br>";
	}

	@Override
	public int getRequiredLevel() {
		return 6;
	}

	@Override
	public int getFireDurationMinDamage() {
		return (int) dec((((ln(lvl(INFERNO_ID),32,24,26,28,32,36)<<2)*(100+((blvl(WARMTH_ID))*13))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/10.24,0);
	}

	@Override
	public int getFireDurationMaxDamage() {
		return (int) dec((((ln(lvl(INFERNO_ID),64,24,27,29,33,37)<<2)*(100+((blvl(WARMTH_ID))*13))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/10.24,0);
	}

	@Override
	public double getManaCost() {//RENAME 20级法力消耗
		return dec((ln(lvl(INFERNO_ID),36,1)<<2)/20.48,0);
	}

	@Override
	public double getRadius() {
		return dec((ln(lvl(INFERNO_ID),20,3)/4)*2/3d,1);
	}

}
