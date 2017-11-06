package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>骷髅复生</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无
   <p>　　以前,   死灵法师们学习控制其去动物的躯体. 
   使用这个技能--从新鲜的尸体中造出一具活蹦乱跳的骷髅--会引起不愉快的混乱. 这些骷髅们的战斗部分是由于自己的意志, 
   部分是听命于被召唤的古代战士的英灵. 作为邀请他们为自己战斗的回报, 死灵法师经常需要提供一定程度的招待.     
   <p><strong>效果</strong>: 每级技能可以让你从死去的怪物尸体中复活一个骷髅为你战斗.   
   <p>　　在有了支配骷髅技能的支持下, 骷髅可以更好的发挥作用, 一旦你到了噩梦或地狱难度, 
   普通的骷髅就会非常快速的死去. 你应该做好计划, 一旦你打到了 30   级, 
   因该用复活怪物技能来替代复活骷髅和骷髅法师. 
   <p>　　骷髅当被创建的时候, 有 5% 概率会使用盾牌. 可以使骷髅产生格挡, 但只有 3% 格挡几率.
 */
public class RaiseSkeleton extends AbstractSkill{

	public RaiseSkeleton(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return "";
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return "";
	}

}
