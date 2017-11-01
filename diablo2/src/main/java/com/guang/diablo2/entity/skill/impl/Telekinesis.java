package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>心灵传动</b><BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong> 无
   <p>　　运用这种魔法, 法师可以用意志接触或是操纵远处的目标. 通过操控遍布这个世界的以太, 
   她可以拿到原本够不着的东西, 或在远处攻击敌人. 对一个狡黠的法师, 这项技能可以给她们制造很多的机会.   
   <p><strong>效果</strong>: 允许你拣起物品, 触发机关或是攻击敌人.
   <UL>
   <LI>对暗金怪物和头目, 击退和眩晕无效.   
   <LI>心灵传动可以用来开启混沌避难所中的封印.   
   <LI>心灵传动可以用来开箱子, 如果你身上的地方够的话还可能用以拣东西.
   <LI>心灵传动可以拾取卷轴, 药剂, 钥匙, 金币, 箭矢或十字弓弹.   
   <LI>你可以使用心灵传动击晕敌人, 然后将它们解决掉. 低等级的时候你会发现心灵传动杀敌时十分有用; 
   但如果你面对更强大的敌人时, 你会发现你需要使用无数遍才能杀死一个怪物.
   <LI>你可以用心灵传动来激活神殿, 这可以给你省下不少时间. 在和其他玩家抢神殿的时候也可以占据先手.
   <LI>心灵传动可以用来进入传送门或城镇传送门. 红色传送门例如秘密牛关或第五场景中的那些红门也可以使用.   
   <LI>你可以用心灵传动激活小站. 这样可以防止你因为距离或其他问题遗漏小站. </LI>
   </UL>
 */
public class Telekinesis extends AbstractSkill{

	public Telekinesis(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"闪电伤害: "+getLightningMinDamage()+"-"+getLightningMaxDamage()+"<br>"
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
	public int getRequiredLevel() {
		return 6;
	}

	@Override
	public int getLightningMinDamage() {
		return ((lvl(TELEKINESIS_ID)<<8)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public int getLightningMaxDamage() {
		return ((ln(lvl(TELEKINESIS_ID),2,1)<<8)*(100+ln(lvl(LIGHTNING_MASTERY_ID),50,12))/100)/256;
	}

	@Override
	public double getManaCost() {
		return 7d;
	}

}
