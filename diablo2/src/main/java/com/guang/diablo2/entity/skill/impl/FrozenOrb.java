package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>冰封球</b><BR>
   <strong>施放延迟</strong>: 1   秒<BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能:</strong> {@link IceBolt}冰弹, 
   {@link IceBlast}冰风暴, {@link FrostNova}霜之新星, 
   {@link GlacialSpike}冰尖柱, {@link Blizzard}暴风雪
    <p>　　冰冻的圆球, 与空气的接合处不断地放出冰弹, 向周围的一切敌人发起攻击, 
    最终造成一次毁灭性的爆炸. 强大的攻击力与绚目的视觉效果将使敌人从内心中感到恐惧.
   <p><strong>效果</strong>: 旋转的冰球, 向周围发射冰弹, 伤害并冻住敌人.
 */
public class FrozenOrb extends AbstractSkill{

	public FrozenOrb(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"冰冷伤害: "+getColdMinDamage()+"-"+getColdMaxDamage()+"<br>"
				+"<span color=black>11: </span>"+cc("冰冻时间: ",getFreezeTime()," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"冰封球 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"冰弹: +2% 冰冷伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{ICE_BOLT_ID,ICE_BLAST_ID,FROST_NOVA_ID,GLACIAL_SPIKE_ID,BLIZZARD_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 30;
	}

	@Override
	public int getColdMinDamage() {
		return ((ln(lvl(FROZEN_ORB_ID),80,20,24,28,29,30)<<7)*(100+(blvl(ICE_BOLT_ID)*2))/100)/256;
	}

	@Override
	public int getColdMaxDamage() {//RENAME 20级数据
		return ((ln(lvl(FROZEN_ORB_ID),90,21,25,29,30,31)<<7)*(100+(blvl(ICE_BOLT_ID)*2))/100)/256;
	}

	@Override
	public double getFreezeTime() {
		return dec(ln(lvl(FROZEN_ORB_ID),200,25)/25d,1);
	}

	@Override
	public double getManaCost() {
		return (ln(lvl(FROZEN_ORB_ID),50,1)<<7)/256;
	}

	@Override
	public double getCastingDelay() {
		return 1d;
	}

}
