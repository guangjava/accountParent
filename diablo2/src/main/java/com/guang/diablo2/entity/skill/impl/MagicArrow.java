package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>魔法箭</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无
 * <p>　　远古时代, 亚马逊们发现她们美丽繁荣的坦奥苏拉城遭受了双海海盗的围攻, 
 * 这些海盗试图占领亚马逊岛作为他们的基地. 战争持续了数年, 海盗们也做好了持久战的准备. 
 * 在战斗中, 供应物资短缺, 亚马逊的射手们发现她们弹尽粮绝了. 她们意识到防御只有依靠射手的能力才能抵御海盗, 
 * 城中的祭司向奥苏拉祈祷希望获得援助, 结果奥苏拉将自然界的精神能量注入到亚马逊人的意念中去, 
 * 一个接着一个的射手们把她们的意念和力量融合在一起并用他们的弓释放出去, 坚决的把海盗们赶回到海上. 
                      <p><strong>效果</strong>: 创造魔法箭或魔法弹, 造成额外的伤害. 
                      <p>魔法箭不需要有箭矢 (可以节省很多物品栏). 当你箭矢刚好用完时这个技能就非常有用.   
                      <p>实际游戏中法力消耗并没有小数点, 具体数字以游戏中数据为准. 
 */
public class MagicArrow extends AbstractSkill{

	public MagicArrow(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>66: </span>"+"转化 "+getConvertMagicDamage()+"% 物理伤害为魔法伤害<br>"
				+"<span color=black>8: </span>"+cc("命中率: +",getAR(),"%<br>")
				+"<span color=black>9: </span>"+cc("伤害: +",getPlusMinDamage(),"<br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
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
	public int getConvertMagicDamage() {
		return lvl(MAGIC_ARROW_ID);
	}

	@Override
	public int getAR() {
		return ln(lvl(MAGIC_ARROW_ID),10,9);
	}

	@Override
	public int getPlusMinDamage() {
		return lvl(MAGIC_ARROW_ID);
	}

	@Override
	public int getPlusMaxDamage() {
		return getPlusMinDamage();
	}

	@Override
	public double getManaCost() {
		return dec(max(ln(lvl(MAGIC_ARROW_ID),12,-1)<<5,0)/256d,1);
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_crossbow,Weapon.type_bow};
	}

}
