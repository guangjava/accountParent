package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>急冻箭</b><BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link ColdArrow}冰箭
   <p>　　这是克由斯神给真正的战士的又一礼物. 这个技能赋予亚马逊战士的箭矢以冰河和暴风雪的力量. 
   敌人遭到这种箭的攻击后不仅能感受到寒风刺骨, 还会被极地的冰风所折磨. 
   <p><strong>效果</strong>: 箭矢上增加冰冻伤害并且立即冰冻住目标.   
   <p><strong>玩家 vs 玩家 </strong>: 其他玩家会受减速影响, 但不会被冰冻.  
   <p>这是冰箭的升级版, 很像法师的冰风暴技能. 急冻箭会把敌人冻住. 但是在高难度的游戏中, 冻结时间会被缩短. 
   所以在给这个技能分配更多技能点的时候要考虑到这个问题, 在达到 30 级的时候, 冻结之箭会是它很好的替代品.
 */
public class IceArrow extends AbstractSkill{

	public IceArrow(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>8: </span>"+cc("命中率: +",getAR(),"%<br>")
		+"<span color=black>10: </span>"+"冰冷伤害: "+getColdMinDamage()+"-"+getColdMaxDamage()+"<br>"
		+"<span color=black>12: </span>"+cc("冰冻时间 ",getDuration()," 秒 <br>")
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"急冻箭 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"冰箭: +8% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冻结之箭: +5% 冰冻时间每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{COLD_ARROW_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_bow,Weapon.type_crossbow};
	}

	@Override
	public int getColdMinDamage() {
		return ((ln(lvl(ICE_ARROW_ID),6,6,12,18,26,36)<<8)*(100+((blvl(COLD_ARROW_ID))*8))/100)/256;
	}

	@Override
	public int getColdMaxDamage() {
		return ((ln(lvl(ICE_ARROW_ID),10,6,13,19,27,38)<<8)*(100+((blvl(COLD_ARROW_ID))*8))/100)/256;
	}

	@Override
	public int getAR() {
		return ln(lvl(ICE_ARROW_ID),20,9);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(ICE_ARROW_ID),16,1)<<6)/256d,1);
	}

	@Override
	public double getDuration() {
		return dec((ln(lvl(ICE_ARROW_ID),50,5)*(100+(blvl(FREEZING_ARROW_ID)*5))/100)/25d,1);
	}

}
