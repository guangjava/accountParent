package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>冰封装甲</b><BR>
   <strong>须要等级:</strong> 1<BR>
   <strong>须要技能:</strong> 无
    <p>　　这项防御性技能使初学者在战斗中不会受到危险. 这个冰盾会保护法师, 
    并封住所有试图用刀剑伤害她的敌人的动作. 
   <p><strong>效果</strong>: 给予防御提升并冻住所有攻击你的近战敌人.
   <p><strong>PvP</strong> - 其他玩家会受到减速效果影响.  
   <p>　　在冰封装甲上投放更多的技能点之前, 别忘了冰冻时间在噩梦难度减少至1/2, 在地狱难度减少 3/4. 
   20 级的冰封装甲在地狱难度只能将敌人冻住不到 1 秒.
 */
public class FrozenArmor extends AbstractSkill{

	public FrozenArmor(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>3: </span>"+"防御加成: "+dec(ln(lvl(40),30,5),0)+"%<br>"
				+"<span color=black>12: </span>"+cc("持续时间: ",dec((ln(lvl(40),3000,300)+(blvl(50)+blvl(60))*250)/25,1)," 秒 <br>")
				+"<span color=black>12: </span>"+cc("冰冻时间 ",dec((ln(lvl(40),30,3)*(100+((blvl(50)+blvl(60))*5))/100)/25,1)," 秒 <br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",dec(max(ln(lvl(40),7,0)<<8,1<<8)/256,1),"<br>");
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"冰封装甲 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>67: </span>"+"碎冰甲: +"+dec((250+12)/25,0)+" 秒 每一技能等级<br>"
				+"<span color=black>63: </span>"+"碎冰甲: +5% 冰冻时间每一技能等级<br>"
				+"<span color=black>67: </span>"+"寒冰装甲: +"+dec((250+12)/25,0)+" 秒 每一技能等级<br>"
				+"<span color=black>63: </span>"+"寒冰装甲: +5% 冰冻时间每一技能等级<br>";
	}

}
