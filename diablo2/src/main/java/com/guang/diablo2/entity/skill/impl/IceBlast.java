package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>冰风暴</b><BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong>: {@link IceBolt}冰弹
   <p>　　这项技能的冰冷伤害可以将敌人打碎成冰渣, 不让敌人中的施法者有机会复活他们. 用这和方法, 
   在对付可以复活死者的敌人的时候, 法师的效率更高些.<p><strong>效果</strong>: 创造一个冰弹, 
   完全地冻结目标.<p><strong>PvP</strong> - 其他玩家会受到减速效果影响.  
   <p>　　作为冰弹的升级形式,   冰风暴会冻结怪物. 在解冻前怪物无法移动或攻击. 
   如果在怪物被冻住后你继续攻击的话, 它们将被打碎, 使其他怪物无法复活. 
   在对沉沦巫师这样有复生能力的怪物的时候十分有用. 冰风暴可以迅速固定住敌人的部队并将之各个击破. 
   在组队时这项技能是十分有用的. 比如, 你可以冻住敌人, 让队友中的圣骑士和野蛮人将它们击碎.
 */
public class IceBlast extends AbstractSkill{

	public IceBlast(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"冰冷伤害: "+getColdMinDamage()+"-"+getColdMaxDamage()+"<br>"
				+"<span color=black>12: </span>"+cc("冰冻时间 ",getFreezeTime()," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"冰风暴 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"冰弹: +8% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰矛: +10% 冰冻时间每一技能等级<br>"
				+"<span color=black>63: </span>"+"暴风雪: +8% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰封球: +8% 冰冷伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{ICE_BOLT_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 6;
	}

	@Override
	public int getColdMinDamage() {
		return ((ln(lvl(ICE_BLAST_ID),16,14,28,42,56,70)<<7)*(100+((blvl(ICE_BOLT_ID)+blvl(BLIZZARD_ID)+blvl(FROZEN_ORB_ID))*8))/100)/256;
	}

	@Override
	public int getColdMaxDamage() {
		return ((ln(lvl(ICE_BLAST_ID),24,15,29,43,57,71)<<7)*(100+((blvl(ICE_BOLT_ID)+blvl(BLIZZARD_ID)+blvl(FROZEN_ORB_ID))*8))/100)/256;
	}

	@Override
	public double getFreezeTime() {
		return dec((ln(lvl(ICE_BLAST_ID),75,5)*(100+((blvl(GLACIAL_SPIKE_ID))*10))/100)/25d,1);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(ICE_BLAST_ID),12,1)<<7)/256d,1);
	}

}
