package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>暴风雪</b><BR>
   <strong>施放延迟</strong>: 1.8   秒<BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能:</strong> {@link IceBolt}冰弹, {@link IceBlast}冰风暴, 
   {@link FrostNova}霜之新星, {@link GlacialSpike}冰尖柱
    <p>　　通过训练能够获得的最有效的攻击性法术. 使用这项法术, 整片的敌人将被大片如冰雹般落下的冰块冷冻致死, 
    那些可怜的幸存者也只能缓缓地蠕行和哀号, 直到同样被寒冷杀死.   
   <p><strong>效果</strong>: 召集一场暴风雪, 以致死的寒冷攻击敌人. 
 */
public class Blizzard extends AbstractSkill{

	public Blizzard(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>10: </span>"+"冰冷伤害: "+getColdDurationMinDamage()+"-"+getColdDurationMaxDamage()+"<br>"
				+"<span color=black>23: </span>"+cc("持续时间: ",getDuration()," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"暴风雪 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"冰弹: +5% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰风暴: +5% 冰冷伤害每一技能等级<br>"
				+"<span color=black>63: </span>"+"冰尖柱: +5% 冰冷伤害每一技能等级<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{ICE_BOLT_ID,ICE_BLAST_ID,FROST_NOVA_ID,GLACIAL_SPIKE_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int getColdDurationMinDamage() {
		return ((ln(lvl(BLIZZARD_ID),45,15,30,45,55,65)<<8)*(100+((blvl(ICE_BOLT_ID)+blvl(ICE_BLAST_ID)+blvl(GLACIAL_SPIKE_ID))*5))/100)/256;
	}

	@Override
	public int getColdDurationMaxDamage() {
		return ((ln(lvl(BLIZZARD_ID),75,16,31,46,56,66)<<8)*(100+((blvl(ICE_BOLT_ID)+blvl(ICE_BLAST_ID)+blvl(GLACIAL_SPIKE_ID))*5))/100)/256;
	}

	@Override
	public double getManaCost() {
		return ln(lvl(BLIZZARD_ID),23,1);
	}

	@Override
	public double getDuration() {
		return 4d;
	}

	@Override
	public double getCastingDelay() {
		// TODO Auto-generated method stub
		return super.getCastingDelay();
	}

}
