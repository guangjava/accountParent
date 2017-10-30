package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>诱饵</b><BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能</strong>: {@link InnerSight}内视, {@link SlowMissiles}慢速箭
   <p>　　在家乡的雨林中作战时, 亚马逊战士学会了通过制造幻影来误导和欺骗敌人的技能, 通过这个技能来迷惑敌人, 
   使得敌人为了一个虚幻的目标而空耗时间与力量. 
   <p><strong>效果</strong>: 你所创造出来的分身, 可以吸引敌人的攻击.
   <UL>
   <LI>诱饵使你可以避免很多伤害. 使用诱饵的时候, 它将在你鼠标点击的地方出现. 
   诱饵看起来很像你但是不能移动如果它遭受了很多攻击, 那么它可能看起来好像移动了一下. 
   <LI>如果诱饵距离怪物很近，大部分的怪物将会攻击你的诱饵，在你的前面召唤一个诱饵，然后躲在它的后面，
   你可以把它当作人盾来利用。这样大部分的怪物都不会攻击你，特别是诱饵距离它们更近的时候。
   有的时候怪物也会不理睬诱饵，这也没有办法。只要有人攻击它，它便起了作用。很多金色怪物是不会被诱饵所愚弄的。   
   <LI>诱饵在你有了女武神之前的 24 -30 级是很有用的. 使用诱饵来吸引火力, 
   把怪物吸引到你身体的一侧然后召唤诱饵. 在有了女武神之后诱饵也会有用, 女武神往往不能吸引所有的火力, 
   这时候你就需要诱饵来帮忙了. 当有很多远程攻击的敌人攻击你的时候, 诱饵可以为你吸收不少伤害. 
   当你面前有许多怪物无法迅速消灭的时候也是使用诱饵的好时机.
   <LI>诱饵设置为热键可以比较容易施放.   
   <LI>诱饵可以很方便的探测怪物的位置. 在你前方施放一个诱饵来观察是否有怪物来攻击, 
   这样你就能预知怪物的所在, 始终站在诱饵的后面, 它将成为你的保护伞.
   <LI>如果你正在施放诱饵, 你的法术施放被打断的话, 诱饵就不会出现. 如果你仍然需要诱饵, 
   那么就再次施放诱饵. 装备 % 击中偷取法力 物品可以快速恢复法力.   
   <LI>诱饵施放后会有生命值. 诱饵和施放的亚马逊一样的生命. 诱饵在受到一定的伤害后就会消失.   
   持续时间只是表明在没有受到足够伤害的情况下, 只要时间到了依然会消失.   
   <LI>使用炮轰时诱饵可以很好的保证你的安全.   
   <LI>有些玩家会在 PVP 时被诱饵所迷惑. 不是每个人都知道这个技能的.   
   <LI>诱饵有抗性和技能, 类似回避和闪避.   
   <LI>诱饵的抗性 = 等级 * 4, 上限 85. </LI>
   </UL>
 */
public class Decoy extends AbstractSkill{

	public Decoy(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>2: </span>"+cc("生命: ",getSummonHPPercent(),"%<br>")
		+"<span color=black>12: </span>"+cc("持续时间: ",dec((ln(lvl(DECOY_ID),250,125))/25,1)," 秒 <br>")
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
		return new int[]{INNER_SIGHT_ID,SLOW_MISSILES_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int getSummonHPPercent() {
		return lvl(DECOY_ID)*10;
	}

	@Override
	public double getManaCost() {
		return dec(max(ln(lvl(DECOY_ID),76,-3)<<6,1<<8)/256d,1);
	}

	@Override
	public double getDuration() {
		return dec(ln(lvl(DECOY_ID),250,125)/25d,1);
	}

	@Override
	public int getCount() {
		return 1;
	}

}
