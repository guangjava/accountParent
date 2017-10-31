package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**RENAME 暖气
 * <b>温暖</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无
   <p>　　为了成为一个强大的魔法师, 法师必须修习这种技能. 通过收集周围空气中热量的精华, 
   她可以将这种能量转化成神秘的力量用以加强她的法术. 以此, 她可以迅速从法力的消耗中恢复.   
   <p><strong>被动效果</strong>: 提升法力回复速度.
 <P>暖气对法师是十分有用的技能, 因为大部分法师的技能需要法力. 更快的法力回复速度会使战斗的停工期大大减小, 
 也可以让你少消耗些法力药剂. 另外, 
 有更多的法力(带上加法力的物品, 更高的能量点数, 霜燃, 乔丹之石等)也可以让你的法力更快地回复, 
 所以你不必将暖气升满. 但如果你有空闲的技能点, 可以把它们投到暖气上. 专家们对升多少级暖气的意见并不统一, 
 有些建议升满, 有些说只要有足够的法力和法力药瓶就够了. 但大家公认至少要在上面投放一点技能. 这个由你自己来决定.
 <p><strong>暖气和加快法力回复的物品怎样同时作用?</strong><BR>
                        　　公式为: (基础速度*暖气) + 物品.
 */
public class Warmth extends AbstractSkill{

	public Warmth(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = PASSIVE;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>7: </span>"+getManaRegeneratePercent()+"%<br>";
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
	public int getManaRegeneratePercent() {
		return ln(lvl(WARMTH_ID),30,12);
	}

}
