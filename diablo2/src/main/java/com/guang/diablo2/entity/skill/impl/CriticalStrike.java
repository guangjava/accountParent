package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/** 
 * <b>双倍打击</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无
   <p>　　亚马逊的战士经常研究敌人的弱点, 她们擅长利用敌人的弱点对其造成更大的打击. 
   <p><strong>被动效果</strong>: 你的攻击可能对目标造成双倍伤害.   
   <p>　　双倍打击对于任何武器都有效果. 这个技能相当有用, 它增加了亚马逊制造双倍伤害的几率. 
   		它是被动技能, 可以和任何技能共同作用, 并且它时刻都是激活的--因为是被动技能. 
   		你可以和多重箭、穿刺或其他技能一起使用.   
   <p><strong>双倍打击技能能够使所有伤害加倍, 还是只能对基础伤害加倍, 而无法使元素攻击翻番呢?</strong><BR>
                这个公式的计算非常复杂. 通常, 所有的提升加到一起例如 (+50% 和 +20% = +70%). 
                一些魔法效果提升武器的基础伤害, 并且通常没有元素伤害. 
 */
public class CriticalStrike extends AbstractSkill{

	public CriticalStrike(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+getCS()+"% 概率<br>";
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
	public int getCS() {
		return dm(lvl(CRITICAL_STRIKE_ID),5,80);
	}

}
