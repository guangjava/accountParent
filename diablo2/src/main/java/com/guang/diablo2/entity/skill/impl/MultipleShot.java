package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>多重箭</b><BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong>: {@link MagicArrow}魔法箭
   <p>　　传说中的亚马逊女箭手--帕拉西亚, 宣称自己能够结合所有对手的技能于一身. 对于种种无理的挑衅, 
   	她和她的对手们决定进行一场决斗. 为了维护自己的荣誉, 帕拉西亚要在对方出手之前击倒对手. 决斗那天的黎明到来, 
   	信号发出的刹那, 大家都全力射出一箭, 只见帕拉西亚的箭矢在空中分成许多小箭, 个个命中目标, 众人都啧啧称奇, 
   	而她的这项技能也被奉为机密, 只有武艺高强的亚马逊战士才能修习这项技能.   
   <p><strong>效果</strong>: 由一根分为数根魔法般的飞箭或十字弓弹.
   <p>　　只会产生你武器的 3/4 伤害.  
   <p>　　你可以利用鼠标点击的距离来改变多重箭之间的间隔. 
   	按住 <strong>shift</strong> 键可以在不移动的前提下攻击敌人.
   <p>  
        多重箭在攻击屏幕之外的目标或者移动速度非常快的目标时非常有用. 当结合了生命偷取和法力偷取效果之后, 
        这个技能可以很快的让你的生命和法力补满. 不论看上去有多少箭击中了怪物, 
        实际上每次施展对于一个怪物来说只能击中一箭. 多重箭的等级越高, 耗费的魔法也越多, 
        你需要更多的魔法偷取来使用这个技能. 多重箭可以和其他技能相配合, 比如先用冻结之箭攻击怪物, 然后使用多重箭. 
        多重箭在任何难度下都是很好用的技能. 这个技能不要升太多, 因为那样耗费的魔法也相当多. 
        一般来说 6 级或者 10 级就够用了.   
   <p>　　你可以设置多重箭为右键技能. 这样在你逃跑的时候不至于使用了多重箭而无法移动.
 */
public class MultipleShot extends AbstractSkill{

	public MultipleShot(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+getCount()+" 枝<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>73: </span>"+(3)+"/"+(4)+" 武器伤害<br>";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"</span>";
	}

	@Override
	public int getPunish() {
		return 75;
	}

	@Override
	public int getCount() {
		return (min(24,ln(lvl(MULTIPLE_SHOT_ID),2,1)));
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(MULTIPLE_SHOT_ID),4,1)<<8)/256d,1);
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{MAGIC_ARROW_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 6;
	}
	
	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_crossbow,Weapon.type_bow};
	}

}
