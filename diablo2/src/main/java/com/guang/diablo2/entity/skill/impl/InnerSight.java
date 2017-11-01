package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>内视</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无<BR>
        茂盛的树木覆盖着亚马逊的家乡--这片少有阳光照耀的大地. 为了更好的适应这样的环境, 
        亚马逊学会了利用她们生命的力量来使敌人发光的技能. 这使得亚马逊和她们的同伴们更容易发现黑夜中的敌人.
   <p><strong>效果</strong>: 照亮附近的敌人, 让你和你的队伍成员更容易击中目标. 
   <p>　　这个技能在早期很有用. 在黑夜中, 内视使得怪物们更容易被发现. 在低等级的情况下, 
   			降低防御这个属性十分有用. 防御力决定了怪物的抗打击程度, 所以中了内视的怪物将会更容易被消灭. 
   			但是在后面的游戏中, 随着怪物防御力的提高, 这个技能的作用也就不那么明显了, 
   			特别是在更高的难度下. 可以参考怪物部分来了解怪物们的防御力. 如果你发现怪物很难被击中, 
   			或者大群的怪物无法发现, 那么这个既廉价又实用的技能将是你的首选.   
   <p>　　如果你施展技能的时候被攻击, 那么技能会被打断, 你需要重新施展这个技能. 
   <p>　　内视有较大的效果范围, 比大部分的诅咒法术要大. 所以基本不用担心内视会没有作用到怪物身上.  
   <p>　　内视无法叠加. 如果两个亚马逊都使用内视, 那么后施放的将发挥作用. 
 */
public class InnerSight extends AbstractSkill{

	public InnerSight(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CURSE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>12: </span>"+cc("持续时间: ",getDuration()," 秒 <br>")
		+"<span color=black>5: </span>"+"敌人防御: "+getReduceMonsterDefence()+"<br>"
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
	public double getDuration() {
		return dec((ln(lvl(INNER_SIGHT_ID),200,100))/25,1);
	}

	@Override
	public int getReduceMonsterDefence() {
		return (-(ln(lvl(INNER_SIGHT_ID),40,25,45,60,80,100)));
	}

	@Override
	public double getRadius() {
		return 13.3;
	}

	@Override
	public double getManaCost() {
		return 5d;
	}

}
