package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>慢速箭</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong>: {@link InnerSight}内视
   <p>　　经过严格的军事训练, 亚马逊战士能够与周围的环境融为一体, 并且机敏的对一切危险作出第一反应. 
   一方面她要学会如何躲避远程攻击, 就好像自己能够熟练使用弓箭和标枪, 学会躲避这些武器也是必修技能. 
   当她使用这个技能的时候, 敌人的远程攻击速度会放慢, 使得她能够更及时的躲避.   
   <p><strong>效果</strong>: 在这道光明当中的敌人, 他们的远距离攻击都会减慢.   
   <p>　　慢速箭是一个很有趣的技能. 它甚至允许你和敌人的远程攻击武器赛跑. 
   对于对抗那些多重射击的暗金怪物也有很大的作用. 这个技能也有利于队伍中的其他角色躲避远程攻击. 
   <p>　　慢速箭这个技能对付那些遗忘骑士相当好用. 看到它们之后在它们身上施展慢速箭然后跑开, 
   你会发现它们发射的攻击会非常容易躲避了.
 */
public class SlowMissiles extends AbstractSkill{

	public SlowMissiles(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CURSE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>12: </span>"+cc("持续时间: ",getDuration()," 秒 <br>")
		+"<span color=black>3: </span>"+"减缓敌人远距离攻击速度 "+getSlowMonsterCast()+"%<br>"
		+"<span color=black>19: </span>"+"半径: "+getRadius()+" 码<br>"
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
		return new int[]{INNER_SIGHT_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int getSlowMonsterCast() {
		return 33;
	}

	@Override
	public double getManaCost() {
		return 5d;
	}

	@Override
	public double getDuration() {
		return dec(ln(lvl(SLOW_MISSILES_ID),300,150)/25d,1);
	}

	@Override
	public double getRadius() {
		return 13.3;
	}

}
