package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>女武神</b><BR>
   <strong>须要等级:</strong> 30<BR>
   <strong>须要技能</strong>: {@link InnerSight}内视, {@link Dodge}闪避, 
   {@link SlowMissiles}慢速箭, {@link Avoid}躲避, {@link Decoy}诱饵, {@link Evade}回避
   <p>　　当一个亚马逊战士在战斗中履立战功而表达出对奥苏拉神的忠诚的时候, 女神就会派人帮助她. 
   这些人是亚马逊战士中最武勇者的灵魂. 使用这个技能是一个亚马逊战士的莫大荣耀, 
   它意味着使用者在死后依然能继续效忠奥苏拉神--甚至可能成为瓦尔基里, 即女武神.   
   <p><strong>效果</strong>: 召唤一个威力强大的女武神同伴.   
   <p>女武神比任何雇佣兵都更有用处, 只要你有足够的法力就可以随时随地召唤她. 你只能同时召唤一个女武神. 
   女武神身边带有光环, 你可以轻易的找到她的所在. 她们使用长矛近身攻击. 
   她们被召唤的时候身上的装备的加成也在作用在女武神的身上. 身上的装备同技能的等级是有关的, 基础等级为 25, 
   每级提升 3. 这就是说只要你的召唤技能足够高, 女武神可以使用足够好的装备.
   <p>女武神和远程攻击型的亚马逊配合相当好. 女武神能像雇佣兵一样吸引近战敌人的注意, 
   这样可以减轻你控制人物的压力. 女武神也能吸引远程攻击敌人的火力从而可以减少你瞬时受到的伤害. 
   你在这个技能上投资的技能点越多, 女武神就越强大. 女武神也能从圣骑士的灵气或者其他组队成员的技能中受益.
   <UL>
   <LI>你可以通过城镇的医师治疗女武神, 还可以依靠圣骑士的祈祷灵气或重新召唤女武神.   
   <LI>不必担心女武神陷入敌人的包围, 只要有 % 击中偷取法力物品, 你可以很快恢复法力并重新召唤.   
   <LI>女武神和诱饵配合使用可以很好的降低你受到的伤害.   
   <LI>有时女武神在高难度级别下会有某种抗性. 你可以尝试重复召唤女武神直到获得你需要的抗性. </LI>
   <LI>当你召唤出女物神时, 她的盔甲颜色会随机显示. </LI>
   </UL>
   <strong>隐藏属性</strong><BR>
   <BLOCKQUOTE><strong>抗性</strong><BR>
        女武神的抗性等于她的等级 * 2, 最大为 85. 所以等级 10 女武神会有 +20 所有抗性.   
        女武神另个隐藏相关技能是诱饵, 每点诱饵等级会 +2 所有抗性. 
        完整公式 = (女武神   等级 + 基础 诱饵 等级 ) * 2
   <p><strong>魔法等级</strong><BR>
        女武神的装备取决于她的魔法等级, 例如. ilvl 决定了她的装备属性, 会获得哪些属性词缀. 
        1 级女武神的魔法等级 为 25, 每等级提升 3.   
   <p><strong>敏捷</strong><BR>
        女武神每等级提升会获得 +12 点敏捷.   等级 12 的女武神将有 144 点敏捷. 
        这样就可以象其他角色一样获得准确率和防御的提升, 但是这些并没有体现在技能说明里面. </p>
   </BLOCKQUOTE>
   <strong>女武神生命值</strong><BR>
         女武神生命值 =   440 * (1 + 0.2 * (女武神 等级 + 诱饵 等级 - 1))
   <p><strong>相关技能</strong><BR>
        女武神可以从其他技能上获得相应的属性奖励, 包括致命攻击, 闪避, 躲避,   以及 回避. 例如, 
        如果你放 1 点技能在 躲避,  女武神 将会有 24% 几率闪避远程攻击.
 */
public class Valkyrie extends AbstractSkill{

	public Valkyrie(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_SUMMON;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>13: </span>"+"生命: "+getSummonHitPoint()
				+"<span color=black>2: </span>"+cc("伤害: ",getSummonSkillED(),"%<br>")
				+"<span color=black>4: </span>"+cc("命中率: +",getSummonAR(),"%<br>")
				+"<span color=black>2: </span>"+cc("防御: ",getSummonDefencePercent(),"%<br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost());
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"女武神 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"诱饵: +20% 生命每一技能等级<br>"
				+"<span color=black>67: </span>"+"刺入: +"+40+" 攻击命中率每一技能等级<br>"
				+"<span color=black>25: </span>"+"双倍打击<span color=black>25: </span>闪避"
				+"<span color=black>25: </span>"+"躲避<span color=black>252525: </span>回避<br>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{INNER_SIGHT_ID,DODGE_ID,SLOW_MISSILES_ID,AVOID_ID,DECOY_ID,EVADE_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 30;
	}
	
	@Override
	public int getSummonHitPoint() {
		return 440*(100+(20*(lvl(VALKYRIE_ID)-1)+blvl(DECOY_ID)*20))/100;
	}

	@Override
	public int getSummonDexterity() {
		return ln(lvl(VALKYRIE_ID), 12, 12);
	}

	@Override
	public int getSummonDefencePercent() {
		return (lvl(VALKYRIE_ID)-1)*10;
	}

	@Override
	public int getSummonAR() {
		return (40*lvl(VALKYRIE_ID)+40*blvl(PENETRATE_ID));
	}

	@Override
	public int getSummonSkillED() {
		return 25*(lvl(VALKYRIE_ID)-1);
	}

	@Override
	public int getSummonCS() {
		return dm(lvl(CRITICAL_STRIKE_ID),5,80);
	}

	@Override
	public int getSummonDodge() {
		int evade = dm(lvl(EVADE_ID),10,65);
		int dodge = dm(lvl(DODGE_ID),10,65);
		return dodge + (100-dodge)*evade/100;
	}

	@Override
	public int getSummonDodgeCast() {
		int avoid = dm(lvl(AVOID_ID),15,75);
		int evade = dm(lvl(EVADE_ID),10,65);
		return avoid + (100-avoid)*evade/100;
	}

	@Override
	public int getSummonResistFire() {
		return min(2*(lvl(VALKYRIE_ID)+blvl(DECOY_ID)), 85);
	}

	@Override
	public int getSummonResistCold() {
		return getSummonResistFire();
	}

	@Override
	public int getSummonResistPoison() {
		return getSummonResistFire();
	}

	@Override
	public int getSummonResistLightning() {
		return getSummonResistFire();
	}

	@Override
	public double getManaCost() {
		return ln(lvl(VALKYRIE_ID),25,1);
	}

	@Override
	public int getCount() {
		return 1;
	}

}
