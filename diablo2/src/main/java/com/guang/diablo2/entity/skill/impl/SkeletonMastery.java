package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>支配骷髅</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: {@link RaiseSkeleton}骷髅复生
   <p>　　随着死灵法师们关于不死系生物知识的增长, 他们将能够为那些召唤出的骷髅们披甲戴胄, 
   并可从新鲜尸体中召唤出更强大的灵魂. 一个拥有这项技能的死灵法师可以召唤出更为强大的骷髅战士与各种骷髅法师.   
   <p><strong>被动效果</strong>: 提升你复生部下的生命和伤害, 包括骷髅, 法师和重生怪物.   
   <p>　　假如你在恢复骷髅上花费了很多点数, 那么在花费些点数在支配骷髅上会提升骷髅的生命值和伤害力. 
   如果你使用重生技能，那么支配骷髅也是非常有用的.   你重生的怪物也会相应的提升生命值和伤害力.
 */
public class SkeletonMastery extends AbstractSkill{

	public SkeletonMastery(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>70: </span>"+"骷髅生命: +"+getSummonPlusHP()+"<br>"
				+"<span color=black>70: </span>"+"骷髅伤害: +"+getSummonPlusMaxDamage()+"<br>"
				+"<span color=black>70: </span>"+"骷髅法师生命: +"+getSummonPlusHP()+"<br>"
				+"<span color=black>33: </span>"+"骷髅法师投射伤害<br>"
				+"<span color=black>32: </span>"+"怪物生命: +"+getSummonHPPercent()+"%<br>"
				+"<span color=black>32: </span>"+"怪物伤害: +"+getSummonSkillED()+"%";
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"</span>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{RAISE_SKELETON_ID};
	}

	@Override
	public int getSummonHPPercent() {
		return lvl(SKELETON_MASTERY_ID)*5;
	}

	@Override
	public int getSummonPlusHP() {
		return lvl(SKELETON_MASTERY_ID)*8;
	}

	@Override
	public int getSummonPlusMinDamage() {
		return lvl(SKELETON_MASTERY_ID)*2;
	}

	@Override
	public int getSummonPlusMaxDamage() {
		return lvl(SKELETON_MASTERY_ID)*2;
	}

	@Override
	public int getSummonPlusCastMinDamage() {
		return lvl(SKELETON_MASTERY_ID)*2;
	}

	@Override
	public int getSummonPlusCastMaxDamage() {
		return lvl(SKELETON_MASTERY_ID)*2;
	}

	@Override
	public int getSummonSkillED() {
		return lvl(SKELETON_MASTERY_ID)*10;
	}

}
