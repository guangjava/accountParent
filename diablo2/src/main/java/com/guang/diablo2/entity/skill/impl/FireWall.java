package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>火墙</b><BR>
   <strong>施放延迟</strong>: 1.4   秒<BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link Inferno}地狱之火, {@link Blaze}炽烈之径
   <p>　　这技能使法师点燃一个火焰的屏障来保护她的侧翼免受敌人的包围, 使她和她的队友取得战术上的优势. 任何不知情的生物试图穿过这道屏障时会感受到这火焰的强大力量, 并通向灭亡.
   <p><strong>效果</strong>: 创造一道火墙. <BR>
   火墙最好的地方在于它的伤害可以叠加. 你可以在峡谷或河流的另一施放火墙, 被烧的敌人将无法触及你; 你也可以施放一些火墙再把敌人引到火焰里面, 然后绕着火墙转圈, 直到敌人被烤死. 火墙可以结合静力场使用, 也可以往火墙里扔几个陨石. 当组队时, 可以在你近战盟友身边放火墙, 尤其是当有石魔这样的东西吸引敌人的时候极其有效. 如果以上都不管用, 那你可以走到一个怪物身边, 让它攻击你, 然后在它脚下放火墙. 一些聪明的怪物会试着从火墙里逃走.
 */
public class FireWall extends AbstractSkill{

	public FireWall(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>30: </span>"+cc("火焰持续时间: ",getDuration()," 秒 <br>")
		+"<span color=black>27: </span>"+"平均火焰伤害: "+getFireDurationMinDamage()+"-"+getFireDurationMaxDamage()+" 每秒 <br>"
		+"<span color=black>29: </span>"+cc(getRadius()," 码<br>")
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
	public int[] getRequiredSkill() {
		return new int[]{INFERNO_ID,BLAZE_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
	}

	@Override
	public int getFireDurationMinDamage() {
		return ((ln(lvl(FIRE_WALL_ID),15,9,14,21)<<4)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)*75/256;
	}

	@Override
	public int getFireDurationMaxDamage() {
		return ((ln(lvl(FIRE_WALL_ID),20,9,14,21)<<4)*(100+ln(lvl(FIRE_MASTERY_ID),30,7))/100)*75/256;
	}

	@Override
	public double getManaCost() {
		return ln(lvl(FIRE_WALL_ID),22,1);
	}

	@Override
	public double getDuration() {
		return 3.6d;
	}

	@Override
	public double getRadius() {//RENAME 1级范围
		return dec(ln(lvl(FIRE_WALL_ID),7,2)*2/3d,1);
	}

	@Override
	public double getCastingDelay() {
		return 1.4;
	}

}
