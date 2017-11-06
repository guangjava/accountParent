package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>白骨装甲</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无
   <p>　　这项技能从死去的堕落武士的尸体中创造出一道屏幛. 这种装甲将在死灵法师身旁旋转, 保护他不受任何攻击. 
   尽管被施了魔法, 这装甲仍是脆弱的, 吸收了伤害以后会消失.
   <p><STRONG>效果</STRONG>: 创造一个吸收伤害的护盾.   
   <p>　　白骨装甲只能保护死灵法师免受物理伤害.   
   <p>　　白骨装甲在吸收近战伤害的时候十分有用. 如果你有剩余点数的话, 不妨投在这上面. 如果怪物击中了你, 
   而法力又很充足, 可以再施放白骨装甲以保证最大的吸收. </p>
 */
public class BoneArmor extends AbstractSkill{

	public BoneArmor(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_DEFENCE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>3: </span>"+"吸收 "+getAbsorbDamage()+" 伤害<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"白骨装甲 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>67: </span>"+"骨墙: +"+15+" 伤害吸收每一技能等级<br>"
				+"<span color=black>67: </span>"+"骨牢: +"+15+" 伤害吸收每一技能等级<br>";
	}

	@Override
	public int getAbsorbDamage() {
		return ln(lvl(BONE_ARMOR_ID),20,10)+(blvl(BONE_WALL_ID)+blvl(BONE_PRISON_ID))*15;
	}

	@Override
	public double getManaCost() {
		return ln(lvl(BONE_ARMOR_ID),11,1);
	}

}
