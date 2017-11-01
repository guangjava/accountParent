package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>陨石</b><BR>
   <strong>施放延迟</strong>: 1.2   秒<BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能</strong>: {@link FireBolt}火弹, 
   {@link Inferno}地狱之火, {@link Blaze}炽烈之径, 
   {@link FireWall}火墙, {@link Fireball}火球
   <p>　　向天界伸出援助的手, 法师可以从天空召唤落下的星星来打击敌人. 
   这是她最强大的法术之一, 可以大范围的敌人烧成灰烬. 在瓦卡塔娜起义期间, 
   一个名叫哈斯巴的法师出于同情站在了革命者的一边. 在最后的决定性战斗中, 
   她的这个魔法起到了极大的效果, 
   一手摧毁了巴瑞恩王的军队并使瓦卡塔娜人从他的暴政中解放了出来.   
   <p><strong>效果</strong>: 从天空中降下无数的流星陨石, 给予敌人猛烈的打击. 
   <P>陨石需要一点施放技巧. 陨石落到地上需要一定时间, 而爆炸的半径固定为 4 码. 
   如果你在撤退当中, 或是目标在移动时, 将很难击中对手, 你在直线行进时, 
   可以在你前面施放陨石, 把怪物们引到它着陆的地方. 经过一定的练习后, 
   你会很熟练地使用这个技能. 如果你能承受一定的攻击, 你可以在你所站的地方施放很多的陨石, 
   然后让怪物们上来打你. 这样可以让它们接受一场暴雨般的洗礼. 
   同样可以对近身战斗的队友使用这招. 这会让他们很快地搞定怪物. 如果可能的话, 
   最好对河或峡谷对岸的怪物使用陨石.
 */
public class Meteor extends AbstractSkill{

	public Meteor(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"火焰伤害: "+getFireMinDamage()+"-"+getFireMaxDamage()+"<br>"
				+"<span color=black>19: </span>"+"半径: "+getRadius()+" 码<br>"
				+"<span color=black>22: </span>"+"平均火焰伤害: "+getFireDurationMinDamage()+"-"+getFireDurationMaxDamage()+" 每秒 <br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"陨石 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"火弹: +5% 火焰伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"火球: +5% 火焰伤害每一技能等级<br>"
				+"地狱火:+3%平均火焰伤害每秒每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{FIRE_BOLT_ID,INFERNO_ID,BLAZE_ID,FIRE_WALL_ID,FIREBALL_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int getFireMinDamage() {
		return (((ln(lvl(METEOR_ID),80,23,39,79,81,83)<<8)*(100+((blvl(FIRE_BOLT_ID)+blvl(FIREBALL_ID))*5))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public int getFireMaxDamage() {
		return (((ln(lvl(METEOR_ID),100,25,INFERNO_ID,81,83,85)<<8)*(100+((blvl(FIRE_BOLT_ID)+blvl(FIREBALL_ID))*5))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public int getFireDurationMinDamage() {//RENAME 20级数据
		return (((ln(lvl(METEOR_ID),15,4,5,6)<<3)*(100+(blvl(INFERNO_ID)*3))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)*75/256;
	}

	@Override
	public int getFireDurationMaxDamage() {//RENAME 20级数据
		return (((ln(lvl(METEOR_ID),25,4,5,6)<<3)*(100+(blvl(INFERNO_ID)*3))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)*25*3/256;
	}

	@Override
	public double getManaCost() {
		return (ln(lvl(METEOR_ID),34,1)<<7)/256;
	}

	@Override
	public double getRadius() {
		return 4d;
	}

	@Override
	public double getCastingDelay() {
		return 1.2;
	}

}
