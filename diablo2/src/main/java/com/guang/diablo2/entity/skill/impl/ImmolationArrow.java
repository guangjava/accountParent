package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>祭奠之箭</b><BR>
   <strong>施放延迟</strong>: 1 秒   <BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能</strong>: {@link MagicArrow}魔法箭, {@link FireArrow}火焰箭, 
   {@link MultipleShot}多重箭, {@link ExplodingArrow}爆裂箭
   <p>　　荷法依特斯有时候会把这个技能传授给能力最强的亚马逊战士. 
   这种蕴含着火焰力量的箭矢击中的地方都会燃起巨大的火焰. 尽管火焰只能燃烧很短的时间, 但是其威力确实无可比拟, 
   就像荷法依特斯神亲自降临, 打倒敌人一样.   
   <p><strong>效果</strong>: 箭矢上增加火焰伤害和爆炸的属性. 在周围产生火焰, 
   任何穿过火焰的生物都会受到额外的伤害.
   <p>这个技能某些方面来说很像法师的火墙. 如果你能让怪物呆在同一个地方(利用诱饵或女武神), 
   你会发现这个技能相当好用. 这或许是在遇到有铁布衫属性的暗金怪时的好办法.
 */
public class ImmolationArrow extends AbstractSkill{

	public ImmolationArrow(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("命中率: ",getAR())
		+"<span color=black>24: </span>"+"爆炸伤害: "+getExplodeMinDamage()+"-"+getExplodeMaxDamage()+"<br>"
		+"<span color=black>23: </span>"+cc("火焰持续时间: ",getDuration()," 秒 <br>")
		+"<span color=black>22: </span>"+"平均火焰伤害: "+getFireDurationMinDamage()+"-"+getFireDurationMaxDamage()+" 每秒 <br>"
		+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"祭奠之箭 由以下技能得到额外加成:<br>"
				+"</span>"+"火焰箭: +5% 平均火焰伤害每秒 每一技能等级<br>"
				+"<span color=black>63: </span>"+"爆裂箭: +10% 火焰伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{MAGIC_ARROW_ID,FIRE_ARROW_ID,MULTIPLE_SHOT_ID,EXPLODING_ARROW_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_bow,Weapon.type_crossbow};
	}

	@Override
	public int getExplodeMinDamage() {
		return ((ln(lvl(IMMOLATION_ARROW_ID),10,10,20,30,32,34)<<8)*(100+(blvl(EXPLODING_ARROW_ID)*10))/100)/256;
	}

	@Override
	public int getExplodeMaxDamage() {
		return ((ln(lvl(IMMOLATION_ARROW_ID),20,10,20,30,32,34)<<8)*(100+(blvl(EXPLODING_ARROW_ID)*10))/100)/256;
	}

	@Override
	public int getFireDurationMinDamage() {
		return (((ln(lvl(IMMOLATION_ARROW_ID),7,5)<<2)*(100+(blvl(FIRE_ARROW_ID)*5))/100)*75/256);
	}

	@Override
	public int getFireDurationMaxDamage() {
		return (((ln(lvl(IMMOLATION_ARROW_ID),9,5)<<2)*(100+(blvl(FIRE_ARROW_ID)*5))/100)*25/256)*3;
	}

	@Override
	public int getAR() {
		return ln(lvl(IMMOLATION_ARROW_ID),30,9);
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(IMMOLATION_ARROW_ID),12,1)<<7)/256d,1);
	}

	@Override
	public double getDuration() {
		return 3d;
	}

	@Override
	public double getCastingDelay() {
		return 1d;
	}

}
