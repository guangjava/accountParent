package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>导引箭</b><BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link MagicArrow}魔法箭, {@link ColdArrow}冰箭, 
   {@link MultipleShot}多重箭
   <p>　　夜间的狩猎和战斗是每一个亚马逊战士必修的技能. 作为奥苏拉的信徒, 她们通过了艰苦的训练, 
   可以在黑夜之中射中目标, 就好像假借了奥苏拉之手一样. 可以想象, 这对于一个盲人来说是多么有用的一项技能.   
   <p><strong>效果</strong>: 可以附加在你的箭矢或十字弓弹上, 并追踪你的目标或自行寻找目标.
   <UL>
   <LI>导引箭在 PVP 战斗时有非常好的效果.    
   <LI>导引箭可以克制那些快速移动的敌人, 也可以隔着角落来攻击敌人. 当然这些效果多重箭和炮轰也能达到.    
   <LI>在专著于使用炮轰或者多重箭的时候可以用这个技能来对付落单的敌人或者敌人头目.    
   <LI>导引箭不会有穿刺效果. </LI>
   </UL>
 */
public class GuidedArrow extends AbstractSkill{

	public GuidedArrow(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("伤害: ",getSkillED(),"%<br>")
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=#00ff00>"+"</span>";
	}

	@Override
	public String getPlus() {
		return "";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{MAGIC_ARROW_ID,COLD_ARROW_ID,MULTIPLE_SHOT_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_crossbow,Weapon.type_bow};
	}

	@Override
	public int getSkillED() {
		return ln(lvl(GUIDED_ARROW_ID),0,5);
	}

	@Override
	public double getManaCost() {
		return dec(max(ln(lvl(GUIDED_ARROW_ID),32,-1)<<6,1<<8)/256d,1);
	}

}
