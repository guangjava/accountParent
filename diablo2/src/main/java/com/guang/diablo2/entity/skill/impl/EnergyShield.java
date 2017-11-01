package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>能量护盾</b><BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能</strong>: {@link ChargedBolt}充能弹, 
   {@link Telekinesis}心灵传动, 
   {@link Lightning}闪电, {@link Teleport}传送, 
   {@link ChainLightning}连锁闪电
   <p>　　用纯粹的魔法力量将自己罩住后, 法师可以毫无畏惧地步入战场. 
   只要她能够集中精力维持这护盾, 就可以用法力的储备来减少受到的魔法伤害或吸收物理伤害. 
   <p><strong>效果</strong>: 用法力代替生命吸收魔法和一些物理伤害.
   <p>　　传统的法师的法力点数要远比生命点数高. 
   能量护盾可以将她受到的伤害部分转移至法力上面, 让她在战斗中幸存的几率增大. 
   在噩梦和地狱的难度中是非常有用的. 吸收伤害的数量由能量护盾的技能等级决定. 
   使用能量护盾时唯一需要顾虑的是它会吸收法师用以施法的法力点数. 如果你的法力有限, 
   那么在有足够的法力或更快的潜力回复来支持能量护盾前不要投入太多的技能点数.
   <p>　　在心灵传动上增加的技能点可以使能量护盾的伤害吸收效果更佳. 在初始情况中, 
   能量护盾每吸收一点的伤害, 会减少 2 点的法力--比率为 200%. 每加一点心灵传动, 
   会使这个比率减少   6.25%. 例如, 投 8 点在心灵传动上时, 
   每点伤害吸收会减少 1.5 的法力--比率为 150%; 投入 16 点时, 
   每点伤害吸收只造成 1 点的法力耗费, 比率为 100%.</p>
 */
public class EnergyShield extends AbstractSkill{

	public EnergyShield(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_DEFENCE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>12: </span>"+cc("持续时间: ",getDuration()," 秒 <br>")
				+"<span color=black>3: </span>"+"吸收 "+getAbsorbPercent()+"%<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"能量护盾 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>18: </span>"+"心灵传动<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{CHARGED_BOLT_ID,TELEKINESIS_ID,LIGHTNING_ID,TELEPORT_ID,CHAIN_LIGHTNING_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int getAbsorbPercent() {
		return min(ln(lvl(ENERGY_SHIELD_ID),20,5,2,1),95);
	}

	@Override
	public double getRedirectPercent() {
		return 200-6.25*blvl(TELEKINESIS_ID);
	}

	@Override
	public double getManaCost() {
		return 5d;
	}

	@Override
	public double getDuration() {
		return dec((ln(lvl(ENERGY_SHIELD_ID),3600,1500))/25d,1);
	}

}
