package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>静态力场</b><BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong> 无
   <p>　　有限范围内的破坏性法术. 静态力场可以立即除去周围敌人的相当一部分生命. 受到这样的伤害, 
   怪物会被法师及其对友接下来的打击所消灭. 重复的施法造成的伤害少些, 但是与其他的法术或强大的物理伤害结合, 
   法师可以轻松地消灭哪怕再强大的敌人. 
   <p><strong>效果</strong>: 范围内的所有敌人失去现有生命的 25%.
   <p><strong>PvP</strong>: 静态力场对其他玩家的效果有限.  
   <p>　　静态力场对法师来说是非常有用的技能. 
   你可以对有很高魔法抗性的怪物或头目、暗金怪物这样法师很难用火、冰或其他电系法术解决的怪物使用静态力场. 
   在静态力场投入更多的技能点数只会增加法术的作用范围而没有其他的加成. 你可以靠加技能点数的装备来升级静态力场, 
   不用投放太多的技能点.
   <p>　　静态力场的作用是递减的, 所以放几次就足够了, 然后结合其他的技能来解决它们. 组队时此技能十分有效, 
   你可以负责怪物生命降低到一定程度, 然后其他玩家继续进行攻击.
   <p>　　静态力场属于闪电伤害, 闪电抗性可以降低它的伤害.  
   <p>　　Static Field is affected by the lightning resist of your enemy; 
   if that resist is positive then Static will do less than 25% of their life 
   in damage, and if their resist is negative (e.g. facets, conviction, 
   lower resist) it will do more, 
   up to 50% of their total life in one cast vs an enemy with -100 lightning resist.
   <p>　　静态力场在噩梦难度无法在怪物生命 33% 以下使用, 地狱难度为 50%.  In nightmare, 
   static will not do damage to any monster with 33% or less life remaining (and 
   will not bring it below 33%), and in hell, 
   static will not bring any monster below 50% health.
 */
public class StaticField extends AbstractSkill{

	public StaticField(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>19: </span>"+"半径: "+getRadius()+" 码<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>3: </span>"+"削弱敌人生命 "+getStaticFieldPercent()+"%<br>";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"</span>";
	}

	@Override
	public int getRequiredLevel() {
		return 6;
	}

	@Override
	public int getStaticFieldPercent() {
		return 25;
	}

	@Override
	public double getManaCost() {
		return 9d;
	}

	@Override
	public double getRadius() {
		return dec(ln(lvl(STATIC_FIELD_ID),5,1)*2/3d,1);
	}

}
