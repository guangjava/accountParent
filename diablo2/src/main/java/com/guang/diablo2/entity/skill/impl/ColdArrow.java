package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>冰箭</b><BR>
   <strong>须要等级:</strong> 6<BR>
   <strong>须要技能</strong>: 无<p>   
        尽管在亚马逊常年居住的岛上不会有冬天的来临, 但是在费力奥岛上, 卡克由斯山脉的顶部却终年被积雪所覆盖. 
        在山峰上的冰洞里, 是守护神卡克由斯的王座--镜之大殿. 在这里训练过的亚马逊战士都会射出带有冰冻威力的箭矢.   
   <p><strong>效果</strong>: 在箭矢上强化冰冻伤害并且减慢敌人速度.   
   <p>　　这非常象女巫的冰弹技能. 怪物会在被命中后产生冰冻的效果. 当被杀死时, 
   冰冻住的怪物有可能碎裂而不留下尸体, 这样在对那些可以被复活的怪物时就非常有用.  
   <p>　　冰箭在游戏的初期非常有用. 不过不要投入超过 1 点技能, 
   注意在后期{@link IceArrow}急冻箭 和{@link FreezingArrow}冻结之箭 对高等级玩家来说更有用.
 */
public class ColdArrow extends AbstractSkill{

	public ColdArrow(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>66: </span>"+"转化 "+getConvertColdDamage()+"% 物理伤害为元素伤害<br>"
				+"<span color=black>8: </span>"+cc("命中率: +",getAR(),"%<br>")
				+"<span color=black>10: </span>"+"冰冷伤害: "+getColdMinDamage()+"-"+getColdMaxDamage()+"<br>"
				+"<span color=black>11: </span>"+cc("冰冻时间: ",getFreezeTime()," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"冰箭 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"急冻箭: +12% 冰冷伤害每一技能等级<br>";
	}

	@Override
	public int getConvertColdDamage() {
		return (3+(lvl(COLD_ARROW_ID)-1)*2);
	}

	@Override
	public int getAR() {
		return ln(lvl(COLD_ARROW_ID),10,9);
	}

	@Override
	public int getColdMinDamage() {
		return ((ln(lvl(COLD_ARROW_ID),6,4,5,8,16,42)<<7)*(100+((blvl(ICE_ARROW_ID))*12))/100)/256;
	}

	@Override
	public int getColdMaxDamage() {
		return (((ln(lvl(COLD_ARROW_ID),8,4,5,9,17,44)<<7)*(100+((blvl(ICE_ARROW_ID))*12))/100)/256);
	}

	@Override
	public double getFreezeTime() {
		return dec(ln(lvl(COLD_ARROW_ID),100,30)/25d,1);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(COLD_ARROW_ID),28,1)<<5)/256d,1);
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
