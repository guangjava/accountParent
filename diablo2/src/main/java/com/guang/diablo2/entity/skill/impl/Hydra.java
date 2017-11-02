package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>九头海蛇</b><BR>
   <strong>施放延迟</strong>: 2   秒<BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能</strong>: {@link FireBolt}火弹, 
   {@link Warmth}热情, {@link Fireball}火球, {@link Enchant}火焰强化
   <p>　　这项魔法可以让法师从世界的深处召唤纯火系的怪物. 九头海蛇与赞依苏的女人们结成了世代同盟, 上古时代的法师哈拉卡瓦娜拥有对它们的控制权. 它们对签订了契约的法师有求必应, 并随时准备向她的敌人吐射出灼热的熔岩火球.
   <p><strong>效果</strong>: 创造一个多头猛兽并用火焰攻击敌人.<BR>
   支配火焰可以提升九头海蛇的伤害. 
 */
public class Hydra extends AbstractSkill{

	public Hydra(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>12: </span>"+cc("持续时间: ",getDuration()," 秒 <br>")
				+"<span color=black>24: </span>"+"九头海蛇 火焰伤害: "+getFireMinDamage()+"-"+getFireMaxDamage()+"<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"九头海蛇 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"火弹: +3% 火焰伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"火球: +3% 火焰伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{FIRE_BOLT_ID,WARMTH_ID,FIREBALL_ID,ENCHANT_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 30;
	}

	@Override
	public int getFireMinDamage() {
		return (((ln(lvl(HYDRA_ID),24,9,13,17,21,25)<<7)*(100+((blvl(FIRE_BOLT_ID)+blvl(FIREBALL_ID))*3))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public int getFireMaxDamage() {//RENAME 1级数据为19
		return (((ln(lvl(HYDRA_ID),38,11,15,19,23,27)<<7)*(100+((blvl(FIRE_BOLT_ID)+blvl(FIREBALL_ID))*3))/100)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)/256;
	}

	@Override
	public double getManaCost() {
		return max(ln(lvl(HYDRA_ID),40,1)<<7,1<<8)/256;
	}

	@Override
	public double getDuration() {
		return 10d;
	}

	@Override
	public double getCastingDelay() {
		return 2d;
	}

}
