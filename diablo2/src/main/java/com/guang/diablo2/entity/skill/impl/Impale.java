package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>刺爆</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong>: {@link Jab}戳刺
   <p>　　尽管敏捷的身手是亚马逊最突出的特点, 但是其强大的力量也是人们有目共睹的. 
   一个经验丰富的亚马逊战士能够集合她所有的愤怒, 进行威力极大的一击, 这甚至能损坏她们手中的武器.   
   <p><strong>效果</strong>: 可以增加破坏力, 但是武器的耐久会迅速下降.<p>　　
   刺爆很大程度上降低了攻击速度, 在攻击期间, 如果时间较长, 那么攻击会被打断. 
 */
public class Impale extends AbstractSkill{

	public Impale(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("伤害: ",getSkillED(),"%<br>")
		+"<span color=black>2: </span>"+cc("命中率: ",getAR(),"%<br>")
		+"<span color=black>3: </span>"+"武器耐久度损失: "+getLostDurability()+"%<br>"
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
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
		return new int[]{JAB_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int getAR() {
		return ln(lvl(IMPALE_ID),100,25);
	}

	@Override
	public int getSkillED() {
		return ln(lvl(IMPALE_ID),300,25);
	}

	@Override
	public double getManaCost() {
		return 3d;
	}

	@Override
	public int getLostDurability() {
		return (50-dm(lvl(IMPALE_ID),0,30));
	}
	
	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_javelin,Weapon.type_spear};
	}

}
