package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**RENAME 强化
 * <b>火焰强化</b><BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link FireBolt}火弹, {@link Warmth}热情, 
   {@link Fireball}火球
   <p>　　学会了这项技能, 有经验的魔法师会在武器上浸入火焰的威力. 
   有名的法师哈瓦娜就曾经运用这元素的力量武装过自己. 她使用一把经过火焰强化的锤子. 
   她的敌人立即像敬畏她的名字一样害怕起这件武器来.   
   <p><strong>效果</strong>: 临时在武器上增加火焰伤害. <BR>
   火焰强化也可以在队友、仆从及佣兵身上施放。激活以后你可以切换武器，它们都会拥有加成的火焰伤害。
   火焰强化也可以对箭头起作用，所以可以对亚马逊施法。
   <p>　　火焰强化对雇佣兵十分有用, 尤其是第二场景及第五场景的. 
   所以可以找个 +1-3 火焰强化的法杖并将它放到副手的武器上, 在需要的时候切换过去施放. 
   你可以展开雇佣兵窗口查看雇佣兵的伤害, 看火焰强化是否已经过期. 如果伤害数值是不红色的, 那就说明它已经过期了. 
   用火焰强化你可以给你的雇佣兵增强相当大的伤害. 你可以投入&quot;真正&quot;的技能点, 
   也可以使用加技能的装备来增强雇佣兵的伤害.</p>
 */
public class Enchant extends AbstractSkill{

	public Enchant(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_SUPPORT;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>12: </span>"+cc("持续时间: ",getDuration()," 秒 <br>")
		+"<span color=black>10: </span>"+"火焰伤害: "+getFireMinDamage()+"-"+getFireMaxDamage()+"<br>"
		+"<span color=black>2: </span>"+cc("准确率: ",getAR(),"%<br>")
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"火焰强化 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"热情: +9% 火焰伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{FIRE_BOLT_ID,WARMTH_ID,FIREBALL_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
	}

	@Override
	public int getFireMinDamage() {//RENAME 20级数据
		return (((ln(lvl(ENCHANT_ID),16,3,7,11,15,19)<<7)*(100+(blvl(WARMTH_ID)*9))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public int getFireMaxDamage() {//RENAME 20级数据
		return (((ln(lvl(ENCHANT_ID),20,5,9,13,17,21)<<7)*(100+(blvl(WARMTH_ID)*9))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public double getManaCost() {
		return ln(lvl(ENCHANT_ID),25,1);
	}

	@Override
	public double getDuration() {
		return dec((ln(lvl(ENCHANT_ID),3600,600))/25d,1);
	}

	@Override
	public int getAR() {//RENAME ED/AR?
		return ln(lvl(ENCHANT_ID),20,9);
	}

}
