package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>火焰箭</b><br>
 * <strong>须要等级:</strong> 1<BR>
   <strong>须要技能</strong>: 无
 * <p>   
        荷法依特斯是亚马逊族的火神和复活之神, 他居住在费力奥岛上, 阿那祖斯山深处的火山下. 他是农夫的守护神, 
        也常常召唤守卫岛屿的战士保卫子民的安全. 只有通过祈祷和残酷的训练. 
        勇敢的亚马逊人才能射出这种带有毁灭力量的箭矢.   
        <p><strong>效果</strong>: 在箭矢上附加火焰伤害.   
        <p>　　火焰箭在游戏的初期非常有用. 不过不要投入超过 1 点技能, 
                      注意在后期 爆裂箭 {@link ExplodingArrow}
                      和 牺牲之箭{@link ImmolationArrow}</A> 对高等级玩家来说更有用.  
 */
public class FireArrow extends AbstractSkill{

	public FireArrow(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>66: </span>"+"转化 "+getConvertFireDamage()+"% 物理伤害为元素伤害<br>"
				+"<span color=black>8: </span>"+cc("命中率: +",getAR(),"%<br>")
				+"<span color=black>10: </span>"+"火焰伤害: "+getFireMinDamage()+"-"+getFireMaxDamage()+"<br>"
				+"<span color=black>1: </span>"+cc("魔法消耗: ",dec(max(ln(lvl(7),24,1)<<5,1<<8)/256d,1));
	}

	@Override
	public String getDesc2() {
		return "";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"<span color=black>40: </span>"+"火焰箭 由以下技能得到额外加成:<br>"
				+"</span>"+"<span color=black>63: </span>"+"爆裂箭: +12% 火焰伤害每一技能等级<br>";
	}

	@Override
	public int getConvertFireDamage() {
		return (3+(lvl(FIRE_ARROW_ID)-1)*2);
	}

	@Override
	public int getAR() {
		return ln(lvl(FIRE_ARROW_ID),10,9);
	}

	@Override
	public int getFireMinDamage() {
		int result = ((ln(lvl(FIRE_ARROW_ID),1,2,3,6,12,24)<<8)*(100+((blvl(EXPLODING_ARROW_ID))*12))/100)/256;
		return result;
	}

	@Override
	public int getFireMaxDamage() {
		int d = ((ln(lvl(FIRE_ARROW_ID),4,2,3,7,14,27)<<8)*(100+((blvl(EXPLODING_ARROW_ID))*12))/100)/256;
		return d;
	}

	@Override
	public double getManaCost() {
		return dec((ln(lvl(FIRE_ARROW_ID),24,1)<<5)/256d,1);
	}
	
	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_crossbow,Weapon.type_bow};
	}

}
