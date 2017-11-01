package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>雷云风暴</b>BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能</strong>: {@link ChargedBolt}充能弹, 
   {@link StaticField}静态力场, {@link Lightning}闪电, 
   {@link Nova}新星, {@link ChainLightning}连锁闪电
   <p>　　在法师能够获得的元素法术中, 控制天气是最引人注目的. 
   学会这项技能的法师可以召出一阵蕴藏着闪电的乌云随在身后, 
   任何走入风暴范围内的目标将被狂风所席卷, 并受到强烈的闪电打击!   
   <p><strong>效果</strong>: 召唤出雷云风暴, 定时地利用闪电攻击附近的敌人.   
   <p>　　这是法师们中间非常流行的技能. 它自动攻击怪物, 不需要瞄准. 
   施放这个魔法以后的持续时间决定于雷暴的技能等级. 时间到后, 需要重新施放. 
   更高的技能等级配合支配闪电及加技能的装备, 雷云风暴可以造成相当大的伤害, 会秒杀怪物. 
   雷暴可以击中那些不容易用鼠标点到的怪物. 它能够在你使用主打法术之前击毙, 
   至少是大大削弱怪物. 推荐与支配闪电配合使用.
   <p>　　雷云风暴可以与冰系护盾、能量护盾和火焰强化同时使用.
   Thunder Storm shoots down a single bolt of lighting every second, 
   hitting a randomly-selected monster. 
   It can not be aimed or controlled, 
   and works in a passive fashion for as long as it's active. 
 */
public class ThunderStorm extends AbstractSkill{

	public ThunderStorm(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_SUMMON;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>12: </span>"+cc("持续时间: ",getDuration()," 秒 <br>")
				+"<span color=black>10: </span>"+"闪电伤害: "+getLightningDurationMinDamage()+"-"+getLightningDurationMaxDamage()+"<br>"
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
		return new int[]{CHARGED_BOLT_ID,STATIC_FIELD_ID,LIGHTNING_ID,NOVA_ID,CHAIN_LIGHTNING_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int getLightningDurationMinDamage() {
		return (((ln(lvl(THUNDER_STORM_ID),1,10,10,11)<<8))*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public int getLightningDurationMaxDamage() {
		return (((ln(lvl(THUNDER_STORM_ID),100,10,10,11)<<8))*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public double getManaCost() {
		return 19d;
	}

	@Override
	public double getDuration() {
		return dec(ln(lvl(THUNDER_STORM_ID),800,200)/25d,1);
	}

}
