package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>爆裂箭</b><BR>
   <strong>须要等级:</strong> 12<BR>
   <strong>须要技能</strong>: {@link MagicArrow}魔法箭, {@link FireArrow}火焰箭, 
   {@link MultipleShot}多重箭
   <p>　　这是<a href="../../../../../../../resources/wiki/legend.html#Hefaetrus">
   荷法依特斯</a>的又一个礼物, 这种箭矢击中目标之后会自行爆炸. 这种箭矢不仅能伤害击中的目标, 
   还能利用爆炸的伤害伤及周围的敌人. 这种箭矢在发射的时候十分壮丽, 许多战士在看到自己的朋友中了这种箭倒下后, 
   发誓不再与亚马逊为敌.
   <p><strong>效果</strong>: 在普通的箭矢上附加火焰伤害和爆炸效果.   
 */
public class ExplodingArrow extends AbstractSkill{

	public ExplodingArrow(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>8: </span>"+cc("命中率: +",getAR(),"%<br>")
		+"<span color=black>10: </span>"+"火焰伤害: "+getFireMinDamage()+"-"+getFireMaxDamage()+"<br>"
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"爆裂箭 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"火焰箭: +12% 火焰伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{MAGIC_ARROW_ID,FIRE_ARROW_ID,MULTIPLE_SHOT_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 12;
	}

	@Override
	public int getFireMinDamage() {
		return (((ln(lvl(EXPLODING_ARROW_ID),2,5,7,9,12,20)<<8)*(100+(blvl(FIRE_ARROW_ID)*12))/100)/256);
	}

	@Override
	public int getFireMaxDamage() {
		return (((ln(lvl(EXPLODING_ARROW_ID),6,5,8,11,14,23)<<8)*(100+(blvl(FIRE_ARROW_ID)*12))/100)/256);
	}

	@Override
	public int getAR() {
		return ln(lvl(EXPLODING_ARROW_ID),20,9);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(EXPLODING_ARROW_ID),10,1)<<7)/256d,1);
	}
	
	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_crossbow,Weapon.type_bow};
	}

}
