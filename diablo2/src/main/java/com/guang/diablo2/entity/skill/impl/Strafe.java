package com.guang.diablo2.entity.skill.impl;

import com.guang.diablo2.entity.skill.AbstractSkill;
import com.guang.diablo2.entity.speed.Weapon;

/**
 * <b>炮轰</b><BR>
   <strong>须要等级:</strong> 24<BR>
   <strong>须要技能</strong>: {@link MagicArrow}魔法箭, {@link MultipleShot}多重箭, 
   {@link ColdArrow}冰箭, {@link GuidedArrow}导引箭
   <p>　　当一个战士获得了这个能力之后, 便能以惊人的速度和准确率发射箭矢, 并且能精准的命中目标. 
   老兵们经常谈起新兵在头一次遇到亚马逊的这个技能时几乎晕倒. 不要相信这些话, 因为最终被吓倒的往往是老兵自己.   
   <p><strong>效果</strong>: 让射出的箭矢自动分裂攻击, 并瞄准数个靠近的敌人. 
   <p>　　炮轰是很多高等级弓系亚马逊喜欢的技能, 尽管多重箭也是一个不错的选择.   
   <p>　　炮轰会自动瞄准屏幕范围之内的目标并射击. 技能等级越高, 可以攻击的目标就越多.  
   <p>　　炮轰可以有不错的怪物报警效果. 你在某一地区开始使用炮轰后, 就可以大概知道周围怪物的位置. 
   或者是出现了新的怪物.
   <p>　　试着将一群怪物尽量的引诱到一起, 这样可以更好的利用穿刺的效果, 也可以使你不用总是后退来获得距离, 
   提升攻击效率.  
   <p>　　炮轰对于单个怪物不是个很好的攻击手段.   你会消耗很多的法力. 最好使用其他更有效的技能.   
   <p>　　炮轰有时也能攻击到屏幕外不远的地方, 不过多重箭在这方面更强一些.  
   <p>炮轰和冰冻伤害配合起来效果很好. 寻找带有冰冻伤害的物品来使得你的攻击带有冰冻属性. 这将会把怪物冻住, 
   杀死怪物也可能不会留下尸体. 冻结之箭和炮轰配合在普通和恶梦里面效果相当好. 到了地狱难度后冻结时间会有所减少, 
   效果不是很明显了. 冻结之箭和炮轰可以设置两个快捷键来使用, 先用冻结箭使得怪物冻住, 然后用炮轰将其打碎.
   <p>　　最好将炮轰设为右键技能, 这样在你逃跑的时候不会因为错误点击了炮轰而无法移动.
   <p>炮轰在圣骑士的专注灵气下的作用公式如下:<BR>
                        伤害 = 弓伤害*(1 + 敏捷奖励 + 专注奖励 + 炮轰奖励)     
   <p>　　炮轰有隐藏的 "最小射击次数" 效果. 这意味着炮轰在攻击单个怪物时可能会产生最少射击效果, 
   但是当多余一个怪物, 那么可能就会有更好的射击效果. 这对于面对单个怪物时, 设法进行多次射击非常有帮助, 
   可以将怪物锁定进行攻击.   
   <BLOCKQUOTE>公式如下: 射击次数 = 2 + 技能等级 / 4 四舍五入.<BR>
                        这以为着, 当等级 4, 3 次射击; 当等级 20, 2 + 20/4 等于 7 次射击. </BLOCKQUOTE>
                      <strong>炮轰锁定</strong><BR>
        当施展炮轰的时候, 你使用的角色将无法移动, 直到一次炮轰完全施放完毕. 炮轰的等级越高, 攻击的敌人就越多, 
        而锁定的时间也就越长. 专家级的玩家一般都不在这个技能上面加太多的技能点, 而对普通的玩家则没有什么. 
        只需要注意逃跑的时候不要使用这个技能就可以了.
 */
public class Strafe extends AbstractSkill{

	public Strafe(int id, String name_en, String name_zh, String describe) {
		super(id, name_en, name_zh, describe);
	}

	@Override
	public String getDetail() {
		return ""+"<span color=black>3: </span>"+"攻击目标数 "+getCount()+"<br>"
				+"<span color=black>2: </span>"+cc("伤害: ",getSkillED(),"%<br>")
				+"<span color=black>1: </span>"+cc("魔法消耗: ",getManaCost(),"<br>");
	}

	@Override
	public String getDesc2() {
		return ""+"<span color=black>73: </span>"+(3)+"/"+(4)+" 武器伤害<br>";
	}

	@Override
	public String getPlus() {
		return ""+"<span color=#00ff00>"+"</span>";
	}

	@Override
	public int[] getRequiredSkill() {
		return new int[]{MAGIC_ARROW_ID,MULTIPLE_SHOT_ID,COLD_ARROW_ID,GUIDED_ARROW_ID};
	}

	@Override
	public int getRequiredLevel() {
		return 24;
	}

	@Override
	public int[] getRequiredWeapon() {
		return new int[]{Weapon.type_bow,Weapon.type_crossbow};
	}

	@Override
	public int getSkillED() {
		return lvl(STRAFE_ID)*5;
	}

	@Override
	public int getPunish() {
		return 75;
	}

	@Override
	public double getManaCost() {
		return 11d;
	}

	@Override
	public int getCount() {
		return min(lvl(STRAFE_ID)+4,10);
	}

}
