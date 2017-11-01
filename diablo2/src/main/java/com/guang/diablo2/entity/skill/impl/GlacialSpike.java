package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**RENAME 冰尖柱
 * <b>冰矛</b>><BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link IceBolt}冰弹, {@link IceBlast}
   <p>　　比冰风暴更加强大, 这项进攻性技能是一个追求迅速杀敌的高段位法师的选择. 
   用这项技能的法师经常会走在被她击碎的敌人的冰冻尸体的碎块上.<p><strong>效果</strong>: 一个碎冰块, 
   造成沉重的冰冷伤害, 爆炸并冻住附近的敌人.
   <p>　　比冰风暴更强大的技能, 冰尖柱比冰风暴的施展速度快得多, 并会造成区域性的冻结效果, 冻结半径为 2.6 码.
 */
public class GlacialSpike extends AbstractSkill{

	public GlacialSpike(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"冰冷伤害: "+getColdMinDamage()+"-"+getColdMaxDamage()
				+"<span color=black>12: </span>"+cc("冰冻时间 ",getFreezeTime()," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>19: </span>"+"半径: "+getRadius()+" 码<br>";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"冰矛 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"冰弹: +5% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰风暴: +5% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"暴风雪: +3% 冰冻时间每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰封球: +5% 冰冷伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{ICE_BOLT_ID,ICE_BLAST_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
	}

	@Override
	public int getColdMinDamage() {//RENAME 1级数据
		return ((ln(lvl(GLACIAL_SPIKE_ID),32,14,26,28,30,32)<<7)*(100+((blvl(ICE_BOLT_ID)+blvl(ICE_BLAST_ID)+blvl(FROZEN_ORB_ID))*5))/100)/256;
	}

	@Override
	public int getColdMaxDamage() {//RENAME 1级数据
		return ((ln(lvl(GLACIAL_SPIKE_ID),48,15,27,29,31,33)<<7)*(100+((blvl(ICE_BOLT_ID)+blvl(ICE_BLAST_ID)+blvl(FROZEN_ORB_ID))*5))/100)/256;
	}

	@Override
	public double getFreezeTime() {
		return dec((ln(lvl(GLACIAL_SPIKE_ID),50,3)*(100+blvl(BLIZZARD_ID)*3)/100)/25d,1);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(GLACIAL_SPIKE_ID),20,1)<<7)/256d,1);
	}

	@Override
	public double getRadius() {
		return 2.6;
	}

}
