package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>冻结之箭</b><BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能</strong>: {@link ColdArrow}冰箭, 
   {@link IceArrow}急冻箭
   <p>    
        最伟大的力量只有那些勇于为卡克由斯神献身的战士才能使用. 这个技能拥有雪崩一样的力量. 
        被冻结之箭击中的敌人都会被冻住, 承受巨大的痛苦, 就好像庞大的冰块杂在他们身上.   
   <p><strong>效果</strong>: 使箭矢带有冰冻伤害, 并且能冻结目标周围的怪物.
   <p><strong>玩家 vs 玩家 </strong>: 其他玩家会受到冰冻效果影响, 
   但不会完全被冻住.  
   <p>　　冻结之箭非常类似法师的冰尖柱. 冻结之箭比那个更加强力, 因为增加了冰冻伤害, 
   它同时可以和穿刺以及致命攻击一同发挥效果.  
   <p>在给这个技能升级的时候要注意在恶梦和地狱难度下冻结的时间都有缩短. 
   在地狱难度下冻结的时间只有 0.5 秒, 如果你使用的弓足够快, 
   那么还是能够阻止怪物快速移动的.
   <li> The cold damage adds to the arrow's regular physical damage.</li> 
 */
public class FreezingArrow extends AbstractSkill{

	public FreezingArrow(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("命中率: ",getAR(),"%<br>")
				+"<span color=black>10: </span>"+"冰冷伤害: "+getPlusMinDamage()+"-"+getPlusMaxDamage()+"<br>"
				+"<span color=black>12: </span>"+cc("冰冻时间 ",getDuration()," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>19: </span>"+"半径: "+getRadius()+" 码<br>";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"冻结之箭 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"冰箭: +12% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"急冻箭: +5% 冰冻时间每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{COLD_ARROW_ID,ICE_ARROW_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 30;
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_bow,Weapon.type_crossbow};
	}

	@Override
	public int getAR() {
		return ln(lvl(FREEZING_ARROW_ID),40,9);
	}

	@Override
	public int getPlusMinDamage() {
		return ((ln(lvl(FREEZING_ARROW_ID),40,10,15,20,22,24)<<8)*(100+(blvl(COLD_ARROW_ID)*12))/100)/256;
	}

	@Override
	public int getPlusMaxDamage() {
		return ((ln(lvl(FREEZING_ARROW_ID),50,10,15,20,22,24)<<8)*(100+(blvl(COLD_ARROW_ID)*12))/100)/256;
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(FREEZING_ARROW_ID),18,1)<<7)/256d,1);
	}

	@Override
	public double getDuration() {
		return dec((50*(100+(blvl(ICE_ARROW_ID)*5))/100)/25d,1);
	}

	@Override
	public double getRadius() {
		return 3.3;
	}

}
