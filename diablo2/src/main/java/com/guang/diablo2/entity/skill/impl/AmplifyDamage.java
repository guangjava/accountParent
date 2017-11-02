package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>伤害加深</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无 
   <p>　　这个强大的迷惑性的诅咒可以加速任何伤口的腐败, 
   一般的打击就可以造成相当程度的伤口并且开始腐烂. 
   <p><strong>效果</strong>: 提升目标受到的伤害.   
   <p>　　伤害加深降低怪物的物理抗性 100%. 基本等于使怪物失去物理抵抗力.   
   <p>　　伤害加深可以让你更快地杀伤敌人. 你会发现, 
   在你和你的仆从们试着更快地杀死一个暗金、蓝色或是可以复活其他怪物的家伙时候, 
   伤害加深是多么的有用. 
   <p>　　在团队中使用伤害加深也是相当好的选择, 可以帮助你们对怪物可以造成更大的伤害.   
   <p><strong>伤害加深可以作用于法术伤害吗?</strong><BR>
                        　　No, 只有物理伤害.   
   <p><strong>伤害加深可以对尸爆起作用吗?</strong><BR>
                        　　一部分. 尸爆是 50% 的物理伤害和 50% 火焰伤害.
 */
public class AmplifyDamage extends AbstractSkill{

	public AmplifyDamage(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>19: </span>"+"半径: "+dec(dec(ln(lvl(66),3,1),0)*2/3,1)+" 码<br>"
				+"<span color=black>12: </span>"+cc("持续时间: ",dec((ln(lvl(66),200,75))/25,1)," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",dec(max(ln(lvl(66),4,0)<<8,1<<8)/256,1),"<br>");
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>2: </span>"+cc("伤害增加: ",(dec(100,0)),"%<br>");
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"</span>";
	}

}
