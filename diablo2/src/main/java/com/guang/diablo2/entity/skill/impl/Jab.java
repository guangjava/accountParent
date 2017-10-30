package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>戳刺</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无<BR>
       在亚玛逊家乡茂盛的雨林中很难寻找敌人, 树木和野兽使得觅敌非常困难. 在早期的训练中, 
       使用长矛的战士必须练习迅速和有力的刺出长矛. 在杀死敌人之前, 先要找出弱点, 这就是使用长矛的基本技能.
   <p><strong>效果</strong>:使用标枪或长矛类武器以快速的刺击攻击数下.   
   <p>　　戳刺不会被打断.
 */
public class Jab extends AbstractSkill{

	public Jab(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("命中率: ",getAR(),"%<br>")
		+"<span color=black>2: </span>"+cc("伤害: ",getSkillED(),"%<br>")
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return "";
	}

	@Override
	public int getAR() {
		return ln(lvl(JAB_ID),10,9);
	}

	@Override
	public int getSkillED() {
		return ln(lvl(JAB_ID),-15,3);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(JAB_ID),8,1)<<6)/256d,1);
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_javelin,Weapon.type_spear};
	}

}
