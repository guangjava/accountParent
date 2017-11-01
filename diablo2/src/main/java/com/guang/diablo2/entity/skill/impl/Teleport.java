package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;

/**
 * <b>传送</b><BR>
   <strong>须要等级:</strong> 18<BR>
   <strong>须要技能</strong>: {@link Telekinesis}心灵传动
   <p>　　法师们训练这项不可思议的魔法, 使自己可以在空间中随心所欲地移动, 瞬间到达其他地方. 
   不用路标点或时空卷轴, 她就可以在邻近的空间内任意空梭. 虽然这个距离并不很长, 但她们可以利用它来逃脱追杀, 
   或者到达一些难以达到的地方.
   <p><strong>效果</strong>: 在两点间迅速地移动.   
   <p>　　传送对每个法师来说都是必修的课程, 用它可以节省时间, 也可以从怪物身边逃脱.
   <p>　　注意, 高等级的传送只减少法力消耗. 你当然不愿意把所有的点数都放在传送上. 
   你可以用 +X 法师所有技能之类的装备或用法杖来达到同样的效果.</p>
   <p>　　传送也是控制你雇佣兵的好办法. 你的雇佣兵会与你一起瞬移! 你可以用这个来使他更快地接近怪物, 
   只需要移动到一个怪物的身边, 你的雇佣兵会马上与它开始战斗. 用这个办法你可以很好地控制佣兵攻击确定的目标. 
   如果你的雇佣兵被击晕或是离你太远, 也可以用它来将雇佣兵拉到身边.</p>
   <p><STRONG>逃离战场</STRONG> --    法师在面对面的战斗中天生不占优势. 当被怪物包围时, 
   使用传送可以迅速逃到安全的地方, 远离战斗. 有快速再度攻击的物品在这种情况下十分有用, 
   它会在你受到沉重的打击后提供更多的时间施放传送.
   <p><STRONG>抄</STRONG><STRONG>近路</STRONG> -- 传送最有趣的地方是可以走近路, 
   而不需要过桥、上台阶或是绕迷宫. 这样会比其他角色节约很多花费在路途中的时间, 特别是地下迷宫这样的地方. 试试吧.
   <p><STRONG>与其他玩家赛跑</STRONG><STRONG> </STRONG>--   使用传送动可以迅速离开战场, 
   或其他恶意的玩家, 到达安全的地方或回到城镇里. 想象这种景象: 一个队友跑出很长的一段路, 
   然后法师用传送赶到他前头, 挺有趣的.
 */
public class Teleport extends AbstractSkill{

	public Teleport(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
		type = INITIATIVE_CAST;
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
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
	public double getManaCost() {
		return dec(max(ln(lvl(TELEPORT_ID),24,-1)<<8,1<<8)/256d,1);
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{TELEKINESIS_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 18;
	}

}
