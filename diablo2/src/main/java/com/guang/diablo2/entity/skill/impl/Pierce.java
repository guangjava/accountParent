package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>穿透</b><BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能</strong>: {@link CriticalStrike}致命攻击, {@link Penetrate}刺入
   <p>　　经过漫长的训练, 亚马逊战士的弓箭技能将会非常熟练, 威力也会越来越大. 通过一些特殊的培训, 
   她们那带着强大威力的箭矢可以射穿一个又一个目标. 
   <p><strong>被动效果</strong>: 你的飞射武器, 有机会在击中时候穿过敌人继续飞行.   
   <p>这是很有用的被动技能, 效果能作用在所有远程攻击武器上. 它击中敌人, 穿透, 杀伤下一个敌人......
   这个技能和瘟疫标枪或者魔法箭配合会更具威力. 在炮轰技能中, 你也会有更多的穿透伤害.
   <p>　　有一些建议说把这个技能提升等级到 20, 不过更高的等级效果提升并不明显. 
   你需要自己斟酌加多少技能点进去. 如果你的技能点实在是多得没处用, 那么就全部放在这个技能上吧.
   <p>　　引导所有的怪物都站在一条线上, 你就会发现穿透技能是多么好用.
 */
public class Pierce extends AbstractSkill{

	public Pierce(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+getPierce()+"% 概率<br>";
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
		return new int[]{CRITICAL_STRIKE_ID,PENETRATE_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 30;
	}

	@Override
	public int getPierce() {
		return dm(lvl(PIERCE_ID),10,100);
	}

}
