package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>支配冰冷</b><BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能</strong>: 无
   <p>　　一旦掌握了这种强大的元素, 法师会在法师学校中获取极好的成绩. 
   以往对她的冰冷法术毫不介意的对手会发现自己成了这种令人胆颤的元素下的牺牲品. 
   <p><strong>被动效果</strong>: 降低敌人的冰冷抗性.   
   <p><strong>PvP</strong> - 使其他玩家冰冷抗性减半, 当最大化时.  
   <p>　　支配冰冷降低的怪物抗性只对法师的攻击起到效果, 无法对团队成员的攻击起到效果.   
   <p>　　支配冰冷无法作用于冰冷免疫的怪物. 如果你有目标敌人抗寒 -105%, 
   但他们是冰免的话你仍然可以使他们抗性降低但无法伤害他们. 
   那么为什么还要最大化的投入点数 100%+ ? 如果他们不是冰免, 而只是抗性较高的化, 
   那么通过这个技能你就可以获得更高的攻击伤害. 这就象你在噩梦/地狱难度一样.   
   <p>　　如果目标有 75% 抗寒并且你有技能等级 1 支配冰冷,   
   那目标抗寒就为 75% - 20% = 55%.
 */
public class ColdMastery extends AbstractSkill{

	public ColdMastery(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+getReduceMonsterColdRegist()+"%<br>";
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
		return 30;
	}

	@Override
	public int getReduceMonsterColdRegist() {
		return ln(lvl(COLD_MASTERY_ID),20,5);
	}

}
