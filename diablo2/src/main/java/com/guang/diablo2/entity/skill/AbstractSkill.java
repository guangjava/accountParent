package com.guang.diablo2.entity.skill;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guang.diablo2.entity.base.Character;
import com.guang.diablo2.frame.skill.SkillTree;
import com.guang.diablo2.frame.speed.Form;

/**
 * @comment 用于技能树
 * @author guang
 * @date 2017年10月25日下午11:21:03
 * @version 1.0.2
 */
public abstract class AbstractSkill {
	/**
	 * 魔法箭id
	 */
	public static final int MAGIC_ARROW_ID = 6;
	/**
	 * 火焰箭id
	 */
	public static final int FIRE_ARROW_ID = 7;
	/**
	 * 内视id
	 */
	public static final int INNER_SIGHT_ID = 8;
	/**
	 * 双倍打击id
	 */
	public static final int CRITICAL_STRIKE_ID = 9;
	/**
	 * 戳刺id
	 */
	public static final int JAB_ID = 10;
	/**
	 * 冰箭id
	 */
	public static final int COLD_ARROW_ID = 11;
	/**
	 * 多重箭id
	 */
	public static final int MULTIPLE_SHOT_ID = 12;
	/**
	 * 闪避id
	 */
	public static final int DODGE_ID = 13;
	/**
	 * 威力一击id
	 */
	public static final int POWER_STRIKE_ID = 14;
	/**
	 * 毒枪id
	 */
	public static final int POISON_JAVELIN_ID = 15;
	/**
	 * 爆裂箭id
	 */
	public static final int EXPLODING_ARROW_ID = 16;
	/**
	 * 慢速箭id
	 */
	public static final int SLOW_MISSILES_ID = 17;
	/**
	 * 躲避id
	 */
	public static final int AVOID_ID = 18;
	/**
	 * 刺爆id
	 */
	public static final int IMPALE_ID = 19;
	/**
	 * 闪电球id
	 */
	public static final int LIGHTNING_BOLT_ID = 20;
	/**
	 * 急冻箭id
	 */
	public static final int ICE_ARROW_ID = 21;
	/**
	 * 导引箭id
	 */
	public static final int GUIDED_ARROW_ID = 22;
	/**
	 * 刺入id
	 */
	public static final int PENETRATE_ID = 23;
	/**
	 * 充能一击id
	 */
	public static final int CHARGED_STRIKE_ID = 24;
	/**
	 * 瘟疫标枪id
	 */
	public static final int PLAGUE_JAVELIN_ID = 25;
	/**
	 * 炮轰id
	 */
	public static final int STRAFE_ID = 26;
	/**
	 * 祭奠之箭id
	 */
	public static final int IMMOLATION_ARROW_ID = 27;
	/**
	 * 诱饵id
	 */
	public static final int DECOY_ID = 28;
	/**
	 * 回避id
	 */
	public static final int EVADE_ID = 29;
	/**
	 * 击退id
	 */
	public static final int FEND_ID = 30;
	/**
	 * 冻结之箭id
	 */
	public static final int FREEZING_ARROW_ID = 31;
	/**
	 * 女武神id
	 */
	public static final int VALKYRIE_ID = 32;
	/**
	 * 穿透id
	 */
	public static final int PIERCE_ID = 33;
	/**
	 * 闪电攻击id
	 */
	public static final int LIGHTNING_STRIKE_ID = 34;
	/**
	 * 闪电之怒id
	 */
	public static final int LIGHTNING_FURY_ID = 35;
	/**
	 * 火弹id
	 */
	public static final int FIRE_BOLT_ID = 36;
	/**
	 * 热情id
	 */
	public static final int WARMTH_ID = 37;
	/**
	 * 充能弹id
	 */
	public static final int CHARGED_BOLT_ID = 38;
	/**
	 * 冰弹id
	 */
	public static final int ICE_BOLT_ID = 39;
	/**
	 * 冰封装甲id
	 */
	public static final int FROZEN_ARMOR_ID = 40;
	/**
	 * 地狱之火id
	 */
	public static final int INFERNO_ID = 41;
	/**
	 * 静态力场id
	 */
	public static final int STATIC_FIELD_ID = 42;
	/**
	 * 心灵传动id
	 */
	public static final int TELEKINESIS_ID = 43;
	/**
	 * 霜之新星id
	 */
	public static final int FROST_NOVA_ID = 44;
	/**
	 * 冰风暴id
	 */
	public static final int ICE_BLAST_ID = 45;
	/**
	 * 炽烈之径id
	 */
	public static final int BLAZE_ID = 46;
	/**
	 * 火球id
	 */
	public static final int FIREBALL_ID = 47;
	/**
	 * 新星id
	 */
	public static final int NOVA_ID = 48;
	/**
	 * 闪电id
	 */
	public static final int LIGHTNING_ID = 49;
	/**
	 * 碎冰甲id
	 */
	public static final int SHIVER_ARMOR_ID = 50;
	/**
	 * 火墙id
	 */
	public static final int FIRE_WALL_ID = 51;
	/**
	 * 火焰强化id
	 */
	public static final int ENCHANT_ID = 52;
	/**
	 * 连锁闪电id
	 */
	public static final int CHAIN_LIGHTNING_ID = 53;
	/**
	 * 传送id
	 */
	public static final int TELEPORT_ID = 54;
	/**
	 * 冰尖柱id
	 */
	public static final int GLACIAL_SPIKE_ID = 55;
	/**
	 * 陨石id
	 */
	public static final int METEOR_ID = 56;
	/**
	 * 雷云风暴id
	 */
	public static final int THUNDER_STORM_ID = 57;
	/**
	 * 能量护盾id
	 */
	public static final int ENERGY_SHIELD_ID = 58;
	/**
	 * 暴风雪id
	 */
	public static final int BLIZZARD_ID = 59;
	/**
	 * 寒冰装甲id
	 */
	public static final int CHILLING_ARMOR_ID = 60;
	/**
	 * 支配之焰id
	 */
	public static final int FIRE_MASTERY_ID = 61;
	/**
	 * 九头海蛇id
	 */
	public static final int HYDRA_ID = 62;
	/**
	 * 支配闪电id
	 */
	public static final int LIGHTNING_MASTERY_ID = 63;
	/**
	 * 冰封球id
	 */
	public static final int FROZEN_ORB_ID = 64;
	/**
	 * 支配冰冷id
	 */
	public static final int COLD_MASTERY_ID = 65;
	/**
	 * 伤害加深id
	 */
	public static final int AMPLIFY_DAMAGE_ID = 66;
	/**
	 * 牙id
	 */
	public static final int TEETH_ID = 67;
	/**
	 * 白骨装甲id
	 */
	public static final int BONE_ARMOR_ID = 68;
	/**
	 * 支配骷髅id
	 */
	public static final int SKELETON_MASTERY_ID = 69;
	/**
	 * 骷髅复生id
	 */
	public static final int RAISE_SKELETON_ID = 70;
	/**
	 * 微弱暗视id
	 */
	public static final int DIM_VISION_ID = 71;
	/**
	 * 削弱id
	 */
	public static final int WEAKEN_ID = 72;
	/**
	 * 淬毒匕首id
	 */
	public static final int POISON_DAGGER_ID = 73;
	/**
	 * 尸体爆炸id
	 */
	public static final int CORPSE_EXPLOSION_ID = 74;
	/**
	 * 粘土石魔id
	 */
	public static final int CLAY_GOLEM_ID = 75;
	/**
	 * 攻击反噬id
	 */
	public static final int IRON_MAIDEN_ID = 76;
	/**
	 * 恐惧id
	 */
	public static final int TERROR_ID = 77;
	/**
	 * 骨墙id
	 */
	public static final int BONE_WALL_ID = 78;
	/**
	 * 石魔掌握id
	 */
	public static final int GOLEM_MASTERY_ID = 79;
	/**
	 * 骷髅法师id
	 */
	public static final int RAISE_SKELETAL_MAGE_ID = 80;
	/**
	 * 迷乱id
	 */
	public static final int CONFUSE_ID = 81;
	/**
	 * 生命偷取id
	 */
	public static final int LIFE_TAP_ID = 82;
	/**
	 * 毒爆id
	 */
	public static final int POISON_EXPLOSION_ID = 83;
	/**
	 * 骨矛id
	 */
	public static final int BONE_SPEAR_ID = 84;
	/**
	 * 鲜血石魔id
	 */
	public static final int BLOOD_GOLEM_ID = 85;
	/**
	 * 吸引id
	 */
	public static final int ATTRACT_ID = 86;
	/**
	 * 衰老id
	 */
	public static final int DECREPIFY_ID = 87;
	/**
	 * 骨牢id
	 */
	public static final int BONE_PRISON_ID = 88;
	/**
	 * 召唤抵抗id
	 */
	public static final int SUMMON_RESIST_ID = 89;
	/**
	 * 钢铁石魔id
	 */
	public static final int IRON_GOLEM_ID = 90;
	/**
	 * 降低抵抗id
	 */
	public static final int LOWER_RESIST_ID = 91;
	/**
	 * 剧毒新星id
	 */
	public static final int POISON_NOVA_ID = 92;
	/**
	 * 骨魂id
	 */
	public static final int BONE_SPIRIT_ID = 93;
	/**
	 * 火焰石魔id
	 */
	public static final int FIRE_GOLEM_ID = 94;
	/**
	 * 重生id
	 */
	public static final int REVIVE_ID = 95;
	/**
	 * 牺牲id
	 */
	public static final int SACRIFICE_ID = 96;
	/**
	 * 重击id
	 */
	public static final int SMITE_ID = 97;
	/**
	 * 力量id
	 */
	public static final int MIGHT_ID = 98;
	/**
	 * 祈祷id
	 */
	public static final int PRAYER_ID = 99;
	/**
	 * 火焰抵抗id
	 */
	public static final int RESIST_FIRE_ID = 100;
	/**
	 * 圣光弹id
	 */
	public static final int HOLY_BOLT_ID = 101;
	/**
	 * 圣火id
	 */
	public static final int HOLY_FIRE_ID = 102;
	/**
	 * 荆棘id
	 */
	public static final int THORNS_ID = 103;
	/**
	 * 蔑视id
	 */
	public static final int DEFIANCE_ID = 104;
	/**
	 * 冰冷抵抗id
	 */
	public static final int RESIST_COLD_ID = 105;
	/**
	 * 热诚id
	 */
	public static final int ZEAL_ID = 106;
	/**
	 * 冲锋id
	 */
	public static final int CHARGE_ID = 107;
	/**
	 * 祝福瞄准id
	 */
	public static final int BLESSED_AIM_ID = 108;
	/**
	 * 净化id
	 */
	public static final int CLEANSING_ID = 109;
	/**
	 * 闪电抵抗id
	 */
	public static final int RESIST_LIGHTNING_ID = 110;
	/**
	 * 复仇id
	 */
	public static final int VENGEANCE_ID = 111;
	/**
	 * 祝福之槌id
	 */
	public static final int BLESSED_HAMMER_ID = 112;
	/**
	 * 专注id
	 */
	public static final int CONCENTRATION_ID = 113;
	/**
	 * 圣洁寒冰id
	 */
	public static final int HOLY_FREEZE_ID = 114;
	/**
	 * 活力id
	 */
	public static final int VIGOR_ID = 115;
	/**
	 * 转化id
	 */
	public static final int CONVERSION_ID = 116;
	/**
	 * 神圣护盾id
	 */
	public static final int HOLY_SHIELD_ID = 117;
	/**
	 * 神圣冲击id
	 */
	public static final int HOLY_SHOCK_ID = 118;
	/**
	 * 庇护所id
	 */
	public static final int SANCTUARY_ID = 119;
	/**
	 * 冥想id
	 */
	public static final int MEDITATION_ID = 120;
	/**
	 * 天堂之拳id
	 */
	public static final int FIST_OF_THE_HEAVENS_ID = 121;
	/**
	 * 狂热id
	 */
	public static final int FANATICISM_ID = 122;
	/**
	 * 审判id
	 */
	public static final int CONVICTION_ID = 123;
	/**
	 * 救赎id
	 */
	public static final int REDEMPTION_ID = 124;
	/**
	 * 拯救id
	 */
	public static final int SALVATION_ID = 125;
	/**
	 * 重击id
	 */
	public static final int BASH_ID = 126;
	/**
	 * 剑系掌握id
	 */
	public static final int SWORD_MASTERY_ID = 127;
	/**
	 * 斧系掌握id
	 */
	public static final int AXE_MASTERY_ID = 128;
	/**
	 * 锤系掌握id
	 */
	public static final int MACE_MASTERY_ID = 129;
	/**
	 * 狂嗥id
	 */
	public static final int HOWL_ID = 130;
	/**
	 * 寻找药剂id
	 */
	public static final int FIND_POTION_ID = 131;
	/**
	 * 跳跃id
	 */
	public static final int LEAP_ID = 132;
	/**
	 * 双手挥击id
	 */
	public static final int DOUBLE_SWING_ID = 133;
	/**
	 * 长棍掌握id
	 */
	public static final int POLEARM_MASTERY_ID = 134;
	/**
	 * 投掷掌握id
	 */
	public static final int THROWING_MASTERY_ID = 135;
	/**
	 * 矛系掌握id
	 */
	public static final int SPEAR_MASTERY_ID = 136;
	/**
	 * 嘲弄id
	 */
	public static final int TAUNT_ID = 137;
	/**
	 * 大叫id
	 */
	public static final int SHOUT_ID = 138;
	/**
	 * 击晕id
	 */
	public static final int STUN_ID = 139;
	/**
	 * 双手投掷id
	 */
	public static final int DOUBLE_THROW_ID = 140;
	/**
	 * 增加耐力id
	 */
	public static final int INCREASED_STAMINA_ID = 141;
	/**
	 * 寻找物品id
	 */
	public static final int FIND_ITEM_ID = 142;
	/**
	 * 跳跃攻击id
	 */
	public static final int LEAP_ATTACK_ID = 143;
	/**
	 * 专心id
	 */
	public static final int CONCENTRATE_ID = 144;
	/**
	 * 铁布衫id
	 */
	public static final int IRON_SKIN_ID = 145;
	/**
	 * 战嗥id
	 */
	public static final int BATTLE_CRY_ID = 146;
	/**
	 * 狂乱id
	 */
	public static final int FRENZY_ID = 147;
	/**
	 * 加速id
	 */
	public static final int INCREASED_SPEED_ID = 148;
	/**
	 * 战斗体制id
	 */
	public static final int BATTLE_ORDERS_ID = 149;
	/**
	 * 残酷吓阻id
	 */
	public static final int GRIM_WARD_ID = 150;
	/**
	 * 旋风id
	 */
	public static final int WHIRLWIND_ID = 151;
	/**
	 * 狂暴id
	 */
	public static final int BERSERK_ID = 152;
	/**
	 * 自然抵抗id
	 */
	public static final int NATURAL_RESISTANCE_ID = 153;
	/**
	 * 战斗狂嗥id
	 */
	public static final int WAR_CRY_ID = 154;
	/**
	 * 战斗指挥id
	 */
	public static final int BATTLE_COMMAND_ID = 155;
	/**
	 * 乌鸦id
	 */
	public static final int RAVEN_ID = 221;
	/**
	 * 毒藤id
	 */
	public static final int POISON_CREEPER_ID = 222;
	/**
	 * 狼人变化id
	 */
	public static final int WEREWOLF_ID = 223;
	/**
	 * 变形术id
	 */
	public static final int LYCANTHROPY_ID = 224;
	/**
	 * 火风暴id
	 */
	public static final int FIRESTORM_ID = 225;
	/**
	 * 橡木智者id
	 */
	public static final int OAK_SAGE_ID = 226;
	/**
	 * 召唤灵狼id
	 */
	public static final int SUMMON_SPIRIT_WOLF_ID = 227;
	/**
	 * 熊人变化id
	 */
	public static final int WEREBEAR_ID = 228;
	/**
	 * 熔浆巨岩id
	 */
	public static final int MOLTEN_BOULDER_ID = 229;
	/**
	 * 极地风暴id
	 */
	public static final int ARCTIC_BLAST_ID = 230;
	/**
	 * 食腐藤id
	 */
	public static final int CARRION_VINE_ID = 231;
	/**
	 * 野性狂暴id
	 */
	public static final int FERAL_RAGE_ID = 232;
	/**
	 * 大槌id
	 */
	public static final int MAUL_ID = 233;
	/**
	 * 火山爆id
	 */
	public static final int FISSURE_ID = 234;
	/**
	 * 飓风装甲id
	 */
	public static final int CYCLONE_ARMOR_ID = 235;
	/**
	 * 狼獾之心id
	 */
	public static final int HEART_OF_WOLVERINE_ID = 236;
	/**
	 * 召唤狂狼id
	 */
	public static final int SUMMON_DIRE_WOLF_ID = 237;
	/**
	 * 狂犬病id
	 */
	public static final int RABIES_ID = 238;
	/**
	 * 焰爪id
	 */
	public static final int FIRE_CLAWS_ID = 239;
	/**
	 * 飓风id
	 */
	public static final int TWISTER_ID = 240;
	/**
	 * 太阳藤id
	 */
	public static final int SOLAR_CREEPER_ID = 241;
	/**
	 * 饥饿id
	 */
	public static final int HUNGER_ID = 242;
	/**
	 * 震波id
	 */
	public static final int SHOCK_WAVE_ID = 243;
	/**
	 * 火山id
	 */
	public static final int VOLCANO_ID = 244;
	/**
	 * 龙卷风id
	 */
	public static final int TORNADO_ID = 245;
	/**
	 * 棘灵id
	 */
	public static final int SPIRIT_OF_BARBS_ID = 246;
	/**
	 * 召唤灰熊id
	 */
	public static final int SUMMON_GRIZZLY_ID = 247;
	/**
	 * 狂怒id
	 */
	public static final int FURY_ID = 248;
	/**
	 * 末日战场id
	 */
	public static final int ARMAGEDDON_ID = 249;
	/**
	 * 暴风id
	 */
	public static final int HURRICANE_ID = 250;
	/**
	 * 火焰爆震id
	 */
	public static final int FIRE_BLAST_ID = 251;
	/**
	 * 利爪掌握id
	 */
	public static final int CLAW_MASTERY_ID = 252;
	/**
	 * 心灵战锤id
	 */
	public static final int PSYCHIC_HAMMER_ID = 253;
	/**
	 * 虎击id
	 */
	public static final int TIGER_STRIKE_ID = 254;
	/**
	 * 龙爪id
	 */
	public static final int DRAGON_TALON_ID = 255;
	/**
	 * 闪电网id
	 */
	public static final int SHOCK_WEB_ID = 256;
	/**
	 * 刃之守护id
	 */
	public static final int BLADE_SENTINEL_ID = 257;
	/**
	 * 速度爆发id
	 */
	public static final int BURST_OF_SPEED_ID = 258;
	/**
	 * 焰拳id
	 */
	public static final int FISTS_OF_FIRE_ID = 259;
	/**
	 * 双龙爪id
	 */
	public static final int DRAGON_CLAW_ID = 260;
	/**
	 * 电能守护id
	 */
	public static final int CHARGED_BOLT_SENTRY_ID = 261;
	/**
	 * 火焰复生id
	 */
	public static final int WAKE_OF_FIRE_ID = 262;
	/**
	 * 武器格挡id
	 */
	public static final int WEAPON_BLOCK_ID = 263;
	/**
	 * 魔影斗篷id
	 */
	public static final int CLOAK_OF_SHADOWS_ID = 264;
	/**
	 * 眼镜蛇攻击id
	 */
	public static final int COBRA_STRIKE_ID = 265;
	/**
	 * 刃之怒id
	 */
	public static final int BLADE_FURY_ID = 266;
	/**
	 * 消退id
	 */
	public static final int FADE_ID = 267;
	/**
	 * 影子战士id
	 */
	public static final int SHADOW_WARRIOR_ID = 268;
	/**
	 * 闪电爪id
	 */
	public static final int CLAWS_OF_THUNDER_ID = 269;
	/**
	 * 神龙摆尾id
	 */
	public static final int DRAGON_TAIL_ID = 270;
	/**
	 * 雷光守卫id
	 */
	public static final int LIGHTNING_SENTRY_ID = 271;
	/**
	 * 复生狱火id
	 */
	public static final int WAKE_OF_INFERNO_ID = 272;
	/**
	 * 心灵爆震id
	 */
	public static final int MIND_BLAST_ID = 273;
	/**
	 * 寒冰刃id
	 */
	public static final int BLADES_OF_ICE_ID = 274;
	/**
	 * 飞龙在天id
	 */
	public static final int DRAGON_FLIGHT_ID = 275;
	/**
	 * 亡者守卫id
	 */
	public static final int DEATH_SENTRY_ID = 276;
	/**
	 * 刀刃之盾id
	 */
	public static final int BLADE_SHIELD_ID = 277;
	/**
	 * 毒牙id
	 */
	public static final int VENOM_ID = 278;
	/**
	 * 影子大师id
	 */
	public static final int SHADOW_MASTER_ID = 279;
	/**
	 * 凤翼天翔id
	 */
	public static final int PHOENIX_STRIKE_ID = 280;
	/**
	 * 主动技能 物理
	 */
	public static final int INITIATIVE_ATTACK = 0;
	/**
	 * 主动技能 法术
	 */
	public static final int INITIATIVE_CAST = 1;
	/**
	 * 主动技能 诅咒
	 */
	public static final int INITIATIVE_CURSE = 2;
	/**
	 * 主动技能 召唤
	 */
	public static final int INITIATIVE_SUMMON = 3;
	/**
	 * 主动技能 辅助
	 */
	public static final int INITIATIVE_SUPPORT = 4;
	/**
	 * 主动技能 防御
	 */
	public static final int INITIATIVE_DEFENCE = 5;
	/**
	 * 被动技能
	 */
	public static final int PASSIVE = 6;
	private static final Logger logger = LoggerFactory.getLogger(AbstractSkill.class);
	protected int id;
	protected String name_en;
	protected String name_zh;
	protected String describe;
	protected int type = INITIATIVE_CAST;
	
	protected AbstractSkill(int id, String name_en, String name_zh, String describe) {
		super();
		this.id = id;
		this.name_en = name_en;
		this.name_zh = name_zh;
		this.describe = describe;
	}

	public static Map<Integer, AbstractSkill> getSkillMap(String str) {
		Map<Integer, AbstractSkill> skillMap = new HashMap<Integer, AbstractSkill>();
		if (str==null || "".equals(str)) {
			return skillMap;
		}
		str = str.replace("[", "").replace("'", "");
		String[] skillList = str.split("],");
		for (String skillStr : skillList) {
			String[] skillAttrs = skillStr.split(",|]");
			int id = Integer.parseInt(skillAttrs[0]);
			AbstractSkill skill = AbstractSkill.getSkillImpl(id,skillAttrs[3],skillAttrs[1],skillAttrs[2]);
			skillMap.put(id, skill);
		}
		return skillMap;
	}
	
	/**
	 * @return 技能内容
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:24:10
	 * @since 1.0.2
	 */
	public abstract String getDetail();
	/**
	 * @return 技能介绍2
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:24:21
	 * @since 1.0.2
	 */
	public abstract String getDesc2();
	/**
	 * @return 其他技能对本技能加成效果
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:24:33
	 * @since 1.0.2
	 */
	public abstract String getPlus();
	
	/**
	 * @return 需要技能id
	 * @author zhouchenguang
	 * @date 2017年10月28日上午7:32:47
	 * @since 1.0.2
	 */
	public int[] getRequiredSkill() {
		return new int[]{0};
	}
	
	/**
	 * @return 需要技能等级
	 * @author zhouchenguang
	 * @date 2017年10月28日上午7:32:47
	 * @since 1.0.2
	 */
	public int getRequiredLevel() {
		return 1;
	}
	
	/**
	 * @return 需要武器
	 * @author zhouchenguang
	 * @date 2017年10月29日下午9:03:32
	 * @since 1.0.2
	 */
	public int[] getRequiredWeapon() {
		return new int[]{0};
	}
	
	/**
	 * @return 攻击方式 0-攻击 1-投掷
	 * @author zhouchenguang
	 * @date 2017年10月29日下午9:09:55
	 * @since 1.0.2
	 */
	public int getAttackType() {
		return 0;
	}
	
	/**
	 * @return 火焰最小伤害:
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getFireMinDamage() {
		return 0;
	}
	
	/**
	 * @return 火焰最大伤害:
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getFireMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 冰冻最小伤害:
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getColdMinDamage() {
		return 0;
	}
	
	/**
	 * @return 冰冻最大伤害:
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getColdMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 毒素最小伤害
	 * @author zhouchenguang
	 * @date 2017年10月29日上午10:48:42
	 * @since 1.0.2
	 */
	public int getPoisonMinDamage() {
		return 0;
	}
	
	/**
	 * @return 毒素最大伤害
	 * @author zhouchenguang
	 * @date 2017年10月29日上午10:48:42
	 * @since 1.0.2
	 */
	public int getPoisonMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 闪电最小伤害:
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getLightningMinDamage() {
		return 0;
	}
	
	/**
	 * @return 闪电最大伤害:
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getLightningMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 爆炸最小伤害:
	 * @author zhouchenguang
	 * @date 2017年10月30日上午11:14:13
	 * @since 1.0.2
	 */
	public int getExplodeMinDamage() {
		return 0;
	}
	
	/**
	 * @return 爆炸最大伤害:
	 * @author zhouchenguang
	 * @date 2017年10月30日上午11:14:13
	 * @since 1.0.2
	 */
	public int getExplodeMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 魔法最小伤害
	 * @author zhouchenguang
	 * @date 2017年11月3日下午11:48:43
	 * @since 1.0.2
	 */
	public int getMagicMinDamage() {
		return 0;
	}
	
	/**
	 * @return 魔法最大伤害
	 * @author zhouchenguang
	 * @date 2017年11月3日下午11:48:43
	 * @since 1.0.2
	 */
	public int getMagicMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 火焰持续最小伤害:/秒
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getFireDurationMinDamage() {
		return 0;
	}
	
	/**
	 * @return 火焰持续最大伤害:/秒
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getFireDurationMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 闪电持续最小伤害:/秒
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getLightningDurationMinDamage() {
		return 0;
	}
	
	/**
	 * @return 闪电持续最大伤害:/秒
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getLightningDurationMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 冰冻持续最小伤害:/秒
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getColdDurationMinDamage() {
		return 0;
	}
	
	/**
	 * @return 冰冻持续最大伤害:/秒
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:30:54
	 * @since 1.0.2
	 */
	public int getColdDurationMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 火焰伤害提升%
	 * @author zhouchenguang
	 * @date 2017年11月2日下午11:45:10
	 * @since 1.0.2
	 */
	public int getFirePercent() {
		return 0;
	}
	
	/**
	 * @return 闪电伤害提升%
	 * @author zhouchenguang
	 * @date 2017年11月2日下午11:45:10
	 * @since 1.0.2
	 */
	public int getLightningPercent() {
		return 0;
	}
	
	/**
	 * @return 转化 % 物理伤害为魔法伤害
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:24:52
	 * @since 1.0.2
	 */
	public int getConvertMagicDamage() {
		return 0;
	}
	
	/**
	 * @return 转化 % 物理伤害为火焰伤害
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:25:05
	 * @since 1.0.2
	 */
	public int getConvertFireDamage() {
		return 0;
	}
	
	/**
	 * @return 转化 % 物理伤害为冰冻伤害
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:25:05
	 * @since 1.0.2
	 */
	public int getConvertColdDamage() {
		return 0;
	}
	
	/**
	 * @return 转化 % 物理伤害为闪电伤害
	 * @author zhouchenguang
	 * @date 2017年10月27日下午3:25:05
	 * @since 1.0.2
	 */
	public int getConvertLightningDamage() {
		return 0;
	}
	
	/**
	 * @return 冰冻时间 秒
	 * @author zhouchenguang
	 * @date 2017年11月1日上午12:11:03
	 * @since 1.0.2
	 */
	public double getFreezeTime() {
		return 0d;
	}
	
	/**
	 * @return 命中率: + %
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:33:26
	 * @since 1.0.2
	 */
	public int getAR() {
		return 0;
	}
	
	/**
	 * @return 近战命中率: + %
	 * @author zhouchenguang
	 * @date 2017年10月29日下午10:28:12
	 * @since 1.0.2
	 */
	public int getMelleAR() {
		return getAR();
	}
	
	/**
	 * @return 最小伤害: +增加数值
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:39:08
	 * @since 1.0.2
	 */
	public int getPlusMinDamage() {
		return 0;
	}
	
	/**
	 * @return 最大伤害: +增加数值
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:39:08
	 * @since 1.0.2
	 */
	public int getPlusMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 伤害: %增加比例
	 * @author zhouchenguang
	 * @date 2017年10月28日上午12:31:46
	 * @since 1.0.2
	 */
	public int getSkillED() {
		return 0;
	}
	
	/**
	 * @return 双倍打击 % 概率
	 * @author zhouchenguang
	 * @date 2017年10月28日上午12:14:18
	 * @since 1.0.2
	 */
	public int getCS() {
		return 0;
	}
	
	/**
	 * @return 静态力场降低怪物生命值%
	 * @author zhouchenguang
	 * @date 2017年11月1日上午10:00:03
	 * @since 1.0.2
	 */
	public int getStaticFieldPercent() {
		return 0;
	}
	
	/**
	 * @return 技能惩罚 %
	 * @author zhouchenguang
	 * @date 2017年10月28日上午1:29:36
	 * @since 1.0.2
	 */
	public int getPunish() {
		return 100;
	}
	
	/**
	 * @return 降低敌人防御:
	 * @author zhouchenguang
	 * @date 2017年10月27日下午4:25:38
	 * @since 1.0.2
	 */
	public int getReduceMonsterDefence() {
		return 0;
	}
	
	/**
	 * @return 降低敌人冰抗:
	 * @author zhouchenguang
	 * @date 2017年10月27日下午4:25:38
	 * @since 1.0.2
	 */
	public int getReduceMonsterColdRegist() {
		return 0;
	}
	
	/**
	 * @return 降低敌人物理抵抗:
	 * @author zhouchenguang
	 * @date 2017年10月27日下午4:25:38
	 * @since 1.0.2
	 */
	public int getReduceMonsterPhysicalRegist() {
		return 0;
	}
	
	/**
	 * @return 减缓敌人远距离速度 %
	 * @author zhouchenguang
	 * @date 2017年10月29日下午8:05:26
	 * @since 1.0.2
	 */
	public int getSlowMonsterCast() {
		return 0;
	}
	
	/**
	 * @return 穿透
	 * @author zhouchenguang
	 * @date 2017年10月31日下午2:07:54
	 * @since 1.0.2
	 */
	public int getPierce() {
		return 0;
	}
	
	/**
	 * @return 近战闪避概率
	 * @author zhouchenguang
	 * @date 2017年10月28日上午9:39:01
	 * @since 1.0.2
	 */
	public int getDodge() {
		return 0;
	}
	
	/**
	 * @return 闪避远程攻击概率
	 * @author zhouchenguang
	 * @date 2017年10月29日下午8:22:52
	 * @since 1.0.2
	 */
	public int getDodgeCast() {
		return 0;
	}
	
	/**
	 * @return 防御加成 %
	 * @author zhouchenguang
	 * @date 2017年11月1日上午12:18:42
	 * @since 1.0.2
	 */
	public int getDenfencePercent() {
		return 0;
	}
	
	/**
	 * @return 吸收 比例% 伤害转化为法力损失
	 * @author zhouchenguang
	 * @date 2017年11月1日下午11:59:12
	 * @since 1.0.2
	 */
	public int getAbsorbPercent() {
		return 0;
	}
	
	/**
	 * @return 吸收伤害数值
	 * @author zhouchenguang
	 * @date 2017年11月4日上午12:05:40
	 * @since 1.0.2
	 */
	public int getAbsorbDamage() {
		return 0;
	}
	
	/**
	 * @return 能量护盾伤害转化法力损失效率比例% 1点伤害转化成 比例% 法力损失
	 * @author zhouchenguang
	 * @date 2017年11月2日上午12:00:24
	 * @since 1.0.2
	 */
	public double getRedirectPercent() {
		return 0;
	}
	
	/**
	 * @return 提升法力回复速度+%
	 * @author zhouchenguang
	 * @date 2017年10月31日下午4:10:02
	 * @since 1.0.2
	 */
	public int getManaRegeneratePercent() {
		return 0;
	}
	
	/**
	 * @return 召唤生物生命
	 * @author zhouchenguang
	 * @date 2017年10月30日下午3:28:42
	 * @since 1.0.2
	 */
	public int getSummonHitPoint() {
		return 0;
	}
	
	/**
	 * @return 召唤生物生命 + %
	 * @author zhouchenguang
	 * @date 2017年10月30日下午3:40:28
	 * @since 1.0.2
	 */
	public int getSummonHPPercent() {
		return 0;
	}
	
	/**
	 * @return 召唤生物生命 +
	 * @author zhouchenguang
	 * @date 2017年10月30日下午3:41:10
	 * @since 1.0.2
	 */
	public int getSummonPlusHP() {
		return 0;
	}
	
	/**
	 * @return 召唤生物敏捷
	 * @author zhouchenguang
	 * @date 2017年10月31日上午9:46:53
	 * @since 1.0.2
	 */
	public int getSummonDexterity() {
		return 0;
	}
	
	/**
	 * @return 召唤生物防御
	 * @author zhouchenguang
	 * @date 2017年10月31日上午9:48:05
	 * @since 1.0.2
	 */
	public int getSummonDefence() {
		return 0;
	}
	
	/**
	 * @return 召唤生物命中率
	 * @author zhouchenguang
	 * @date 2017年10月31日上午9:53:09
	 * @since 1.0.2
	 */
	public int getSummonHitRate() {
		return 0;
	}
	
	/**
	 * @return 召唤生物伤害
	 * @author zhouchenguang
	 * @date 2017年10月31日上午9:55:10
	 * @since 1.0.2
	 */
	public int getSummonDamage() {
		return 0;
	}
	
	/**
	 * @return 召唤生物防御 +%
	 * @author zhouchenguang
	 * @date 2017年10月31日上午9:56:06
	 * @since 1.0.2
	 */
	public int getSummonDefencePercent() {
		return 0;
	}
	
	/**
	 * @return 召唤生物命中率 +%
	 * @author zhouchenguang
	 * @date 2017年10月31日上午9:56:54
	 * @since 1.0.2
	 */
	public int getSummonAR() {
		return 0;
	}
	
	/**
	 * @return 召唤生物增加伤害最小值
	 * @author zhouchenguang
	 * @date 2017年11月4日上午7:41:17
	 * @since 1.0.2
	 */
	public int getSummonPlusMinDamage() {
		return 0;
	}
	
	/**
	 * @return 召唤生物增加伤害最大值
	 * @author zhouchenguang
	 * @date 2017年11月4日上午7:41:44
	 * @since 1.0.2
	 */
	public int getSummonPlusMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 召唤生物增加投射伤害最小值
	 * @author zhouchenguang
	 * @date 2017年11月4日上午7:41:17
	 * @since 1.0.2
	 */
	public int getSummonPlusCastMinDamage() {
		return 0;
	}
	
	/**
	 * @return 召唤生物增加投射伤害最大值
	 * @author zhouchenguang
	 * @date 2017年11月4日上午7:41:44
	 * @since 1.0.2
	 */
	public int getSummonPlusCastMaxDamage() {
		return 0;
	}
	
	/**
	 * @return 召唤生物伤害 +%
	 * @author zhouchenguang
	 * @date 2017年10月31日上午9:57:43
	 * @since 1.0.2
	 */
	public int getSummonSkillED() {
		return 0;
	}
	
	/**
	 * @return 召唤生物双倍打击 %
	 * @author zhouchenguang
	 * @date 2017年10月31日上午9:58:58
	 * @since 1.0.2
	 */
	public int getSummonCS() {
		return 0;
	}
	
	/**
	 * @return 召唤生物近战闪避概率
	 * @author zhouchenguang
	 * @date 2017年10月31日上午10:04:41
	 * @since 1.0.2
	 */
	public int getSummonDodge() {
		return 0;
	}
	
	/**
	 * @return 召唤生物闪避远程攻击概率
	 * @author zhouchenguang
	 * @date 2017年10月31日上午10:05:24
	 * @since 1.0.2
	 */
	public int getSummonDodgeCast() {
		return 0;
	}
	
	/**
	 * @return 召唤生物火抗
	 * @author zhouchenguang
	 * @date 2017年10月31日上午10:07:05
	 * @since 1.0.2
	 */
	public int getSummonResistFire() {
		return 0;
	}
	
	/**
	 * @return 召唤生物冰抗
	 * @author zhouchenguang
	 * @date 2017年10月31日上午10:07:42
	 * @since 1.0.2
	 */
	public int getSummonResistCold() {
		return 0;
	}
	
	/**
	 * @return 召唤生物毒抗
	 * @author zhouchenguang
	 * @date 2017年10月31日上午10:08:22
	 * @since 1.0.2
	 */
	public int getSummonResistPoison() {
		return 0;
	}
	
	/**
	 * @return 召唤生物电抗
	 * @author zhouchenguang
	 * @date 2017年10月31日上午10:08:52
	 * @since 1.0.2
	 */
	public int getSummonResistLightning() {
		return 0;
	}
	/**
	 * @return 魔法消耗: 
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:42:32
	 * @since 1.0.2
	 */
	public double getManaCost() {
		return 0d;
	}
	
	/**
	 * @return 持续时间:  秒
	 * @author zhouchenguang
	 * @date 2017年10月27日下午4:07:56
	 * @since 1.0.2
	 */
	public double getDuration() {
		return 0d;
	}
	
	/**
	 * @return 半径:  码
	 * @author zhouchenguang
	 * @date 2017年10月27日下午4:34:24
	 * @since 1.0.2
	 */
	public double getRadius() {
		return 0d;
	}
	
	/**
	 * @return 数量
	 * @author zhouchenguang
	 * @date 2017年10月28日上午1:33:35
	 * @since 1.0.2
	 */
	public int getCount() {
		return 1;
	}
	
	/**
	 * @return 施放延迟
	 * @author zhouchenguang
	 * @date 2017年10月29日上午10:31:14
	 * @since 1.0.2
	 */
	public double getCastingDelay() {
		return 0d;
	}
	
	/**
	 * @return 损失武器耐久度概率 %
	 * @author zhouchenguang
	 * @date 2017年10月29日下午8:46:43
	 * @since 1.0.2
	 */
	public int getLostDurability() {
		return 0;
	}

	/**获取技能等级
	 * @param skillId
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月26日下午1:49:29
	 * @since 1.0.2
	 */
	protected int lvl(int skillId) {
		Character character = Form.getInstance().getSpeedCalculator().getCharacter();
		int tabId = SkillTree.getInstance().getSkillInTab(skillId);
		if (tabId >= 0) {
			return character.getSkillLevel(skillId, tabId);
		}else {
			return 0;
		}
	}
	
	/**获取本身技能等级
	 * @param skillId
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月26日下午1:49:29
	 * @since 1.0.2
	 */
	protected int blvl(int skillId) {
		Character character = Form.getInstance().getSpeedCalculator().getCharacter();
		return character.getBasicSkillLevel(skillId);
	}
	
	/**只要参数中有一个字符串为空或数字为0则返回空字符串
	 * @param objects
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月26日下午1:48:39
	 * @since 1.0.2
	 */
	public String cc(Object... objects ) {
		StringBuilder sb = new StringBuilder();
		for (Object object : objects) {
			if (object == null) {
				return "";
			}else if (object instanceof String) {
				if ("".equals(object)) {
					return "";
				}else {
					sb.append(object.toString());
				}
			}else if (object instanceof Integer) {
				if ((int)object == 0) {
					return "";
				}else {
					sb.append(object.toString());
				}
			}else if (object instanceof Double) {
				if ((double)object == 0) {
					return "";
				}else {
					sb.append(object.toString());
				}
			}else {
				sb.append(object.toString());
			}
		}
		return sb.toString();
	}
	
	/**计算技能数据
	 * @param l 技能等级
	 * @param a 1级数据
	 * @param b 2-8级每级增加数据
	 * @param c 9-16级每级增加数据
	 * @param d 17-22级每级增加数据
	 * @param e 23-28级每级增加数据
	 * @param f 29级以上每级增加数据
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月26日下午1:51:38
	 * @since 1.0.2
	 */
	protected int ln(int l,int a,int b,int c,int d,int e,int f){
		return a+(
				l>28?7*b+8*c+6*d+6*e+(l-28)*f:
					l>22?7*b+8*c+6*d+(l-22)*e:
						l>16?7*b+8*c+(l-16)*d:
							l>8?7*b+(l-8)*c:
								l>0?(l-1)*b:
									-a);
	}
	
	/**计算技能数据
	 * @param l 技能等级
	 * @param a 1级数据
	 * @param b 2-8级每级增加数据
	 * @param c 9-16级每级增加数据
	 * @param d 17-22级每级增加数据
	 * @param e 23级以上每级增加数据
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:25:50
	 * @since 1.0.2
	 */
	protected int ln(int l,int a,int b,int c,int d,int e){
		return ln(l, a, b, c, d, e, e);
	}
	
	/**计算技能数据
	 * @param l 技能等级
	 * @param a 1级数据
	 * @param b 2-8级每级增加数据
	 * @param c 9-16级每级增加数据
	 * @param d 17级以上每级增加数据
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:26:35
	 * @since 1.0.2
	 */
	protected int ln(int l,int a,int b,int c,int d){
		return ln(l, a, b, c, d, d, d);
	}
	
	/**计算技能数据
	 * @param l 技能等级
	 * @param a 1级数据
	 * @param b 2-8级每级增加数据
	 * @param c 9级以上每级增加数据
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:27:04
	 * @since 1.0.2
	 */
	protected int ln(int l,int a,int b,int c){
		return ln(l, a, b, c, c, c, c);
	}
	
	/**计算技能数据
	 * @param l 技能等级
	 * @param a 1级数据
	 * @param b 2级以上每级增加数据
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:27:32
	 * @since 1.0.0
	 */
	protected int ln(int l,int a,int b){
		return ln(l, a, b, b, b, b, b);
	}
	
	/**用来取小数近似位
	 * @param n 小数
	 * @param d 位数
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月26日下午2:09:52
	 * @since 1.0.2
	 */
	protected double  dec(double n, int d){
		double f=Math.pow(10,d);
		return Math.floor(n*f)/f;
	}
	
	protected int max(int a,int b) {
		return Math.max(a, b);
	}
	
	protected int min(int a,int b) {
		return Math.min(a, b);
	}
	
	/**用来计算概率
	 * @param l 技能等级
	 * @param a
	 * @param b
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月28日上午9:58:22
	 * @since 1.0.2
	 */
	protected int dm(int l,int a,int b){
		return a+((b-a)*(110*l/(l+6))/100);
	}
	public int getId() {
		return id;
	}

	public String getName_en() {
		return name_en;
	}

	public String getName_zh() {
		return name_zh;
	}

	/**
	 * @return 技能描述1
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:28:00
	 * @since 1.0.2
	 */
	public String getDesc1() {
		return describe;
	}
	
	/**
	 * @return 技能类型 <br>
	 * 			主动物理 - {@link #INITIATIVE_ATTACK}<br>
	 * 			主动法术 - {@link #INITIATIVE_CAST}<br>
	 * 			主动诅咒 - {@link #INITIATIVE_CURSE}<br>
	 * 			被动 - {@link #PASSIVE}
	 * @author zhouchenguang
	 * @date 2017年10月27日下午2:28:09
	 * @since 1.0.0
	 */
	public int getType() {
		return type;
	}

	private static AbstractSkill getSkillImpl(int id, String name_en, String name_zh, String describe) {
		try {
			@SuppressWarnings("unchecked")
			Class<AbstractSkill> clazz = (Class<AbstractSkill>) Class.forName("com.guang.diablo2.entity.skill.impl."+name_en.replace(" ", ""));
			Constructor<AbstractSkill> constructor = clazz.getConstructor(int.class,String.class,String.class,String.class);
			return constructor.newInstance(id,name_en,name_zh,describe);
		} catch (Exception e) {
			logger.error("",e);
			return null;
		} 
	}
	
}
