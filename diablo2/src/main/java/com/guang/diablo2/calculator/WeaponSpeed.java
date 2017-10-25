package com.guang.diablo2.calculator;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.guang.diablo2.entity.base.Character;
import com.guang.diablo2.entity.speed.Skill;
import com.guang.diablo2.entity.speed.Weapon;
import com.guang.diablo2.entity.speed.WeaponEnComparator;
import com.guang.diablo2.entity.speed.WeaponZhComparator;
import com.guang.diablo2.frame.listener.WeaponListener;
import com.guang.diablo2.frame.listener.WuqiListener;
import com.guang.diablo2.frame.speed.Form;
import com.guang.diablo2.frame.speed.Option;
import com.guang.diablo2.frame.speed.TRCheckBox;
import com.guang.diablo2.frame.speed.TRoneTD;

public class WeaponSpeed {
	private static final String LANG = Form.properties.getProperty("LANG");
	private static final Logger logger = LoggerFactory.getLogger(WeaponSpeed.class);
	int capped    = 0;
	int lastSkill = 0;
	int lastType  = 0;
	int lastC2H   = 0;
	boolean firstCall = true;
	private List<Weapon> weaponlist;
	private Character character = null;
	private Double min = 1d;
	private Double max = 2d;
	private DecimalFormat df = new DecimalFormat("#.00");
	private Double fps;
	/**
	 * 
	 */
	public WeaponSpeed() {
		initWeaponlist();
	}

	private void initWeaponlist() {
		weaponlist = Weapon.getWeaponList(Form.properties.getProperty("weaponlist"));
	}


	public void setCharValues(Form form) {
		try {
			if (firstCall){
				firstCall = false;
				Collections.sort(weaponlist, new WeaponEnComparator());
				JComboBox<Option> weapon = form.getWeapon();
				for (int i = 0; i < weaponlist.size(); i++) {
					Option entry = new Option(weaponlist.get(i).getName_en(), i);
					weapon.addItem(entry);
					weaponlist.get(i).setIndex(i);
				}
				weapon.addItemListener(new WeaponListener());
				Collections.sort(weaponlist, new WeaponZhComparator());
				JComboBox<Option> wuqi = form.getWuqi();
				for (int i = 0; i < weaponlist.size(); i++) {
					Option entry = new Option(weaponlist.get(i).getName_zh(), weaponlist.get(i).getIndex());
					wuqi.addItem(entry);
				}
				wuqi.addItemListener(new WuqiListener());
				Collections.sort(weaponlist, new WeaponEnComparator());
				JComboBox<Option> critStrike = form.getCS();
				for(int i=0; i<=100; i++){
					critStrike.addItem(new Option(i+"", i));
				}
				JComboBox<Option> deadlystrike = form.getDS();
				for(int i=0; i<=100; i++){
					deadlystrike.addItem(new Option(i+"", i));
				}
			}
			Option selectedUchar = form.getSelectedUchar();
			int uchar = selectedUchar.getValue();
			if (uchar > Character.CHAR_ASN) {
				form.getSkillTree().setEnabled(false);
			}else {
				form.getSkillTree().setEnabled(true);
			}
			character = new Character(selectedUchar, form.getStrengthText(), form.getDexterityText());
			JComboBox<Option> skill = form.getSkill();
			if (skill.getItemCount() > 0) skill.removeAllItems();
			switch (uchar) {
			case Character.CHAR_AMA://亚马逊(Amazon)
				skill.addItem(new Option(Skill.SKILL_AMA_0_STR, 0));
				skill.addItem(new Option(Skill.SKILL_AMA_1_STR, 1));
				skill.addItem(new Option(Skill.SKILL_AMA_2_STR, 2));
				skill.addItem(new Option(Skill.SKILL_AMA_3_STR, 3));
				skill.addItem(new Option(Skill.SKILL_AMA_4_STR, 4));
				break;
			case Character.CHAR_BAR://野蛮人(Barbarian)
				skill.addItem(new Option(Skill.SKILL_BAR_0_STR, 0));
				skill.addItem(new Option(Skill.SKILL_BAR_1_STR, 1));
				skill.addItem(new Option(Skill.SKILL_BAR_2_STR, 2));
				skill.addItem(new Option(Skill.SKILL_BAR_3_STR, 3));
				skill.addItem(new Option(Skill.SKILL_BAR_4_STR, 4));
				skill.addItem(new Option(Skill.SKILL_BAR_5_STR, 5));
				skill.addItem(new Option(Skill.SKILL_BAR_6_STR, 6));
				skill.addItem(new Option(Skill.SKILL_BAR_7_STR, 7));
				skill.addItem(new Option(Skill.SKILL_BAR_8_STR, 8));
				break;
			case Character.CHAR_PAL://圣骑士(Paladin)
				skill.addItem(new Option(Skill.SKILL_PAL_0_STR, 0));
				skill.addItem(new Option(Skill.SKILL_PAL_1_STR, 1));
				skill.addItem(new Option(Skill.SKILL_PAL_2_STR, 2));
				break;
			case Character.CHAR_SOR://法师(Sorceress)
				skill.addItem(new Option(Skill.SKILL_SOR_0_STR, 0));
				skill.addItem(new Option(Skill.SKILL_SOR_1_STR, 1));
				break;
			case Character.CHAR_DRU://德鲁伊(Druid)
				skill.addItem(new Option(Skill.SKILL_DRU_0_STR, 0));
				skill.addItem(new Option(Skill.SKILL_DRU_1_STR, 1));
				skill.addItem(new Option(Skill.SKILL_DRU_2_STR, 2));
				skill.addItem(new Option(Skill.SKILL_DRU_3_STR, 3));
				skill.addItem(new Option(Skill.SKILL_DRU_4_STR, 4));
				skill.addItem(new Option(Skill.SKILL_DRU_5_STR, 5));
				skill.addItem(new Option(Skill.SKILL_DRU_6_STR, 6));
				skill.addItem(new Option(Skill.SKILL_DRU_7_STR, 7));
				skill.addItem(new Option(Skill.SKILL_DRU_8_STR, 8));
				skill.addItem(new Option(Skill.SKILL_DRU_9_STR, 9));
				skill.addItem(new Option(Skill.SKILL_DRU_10_STR, 10));
				break;
			case Character.CHAR_ASN://刺客(Assassin)
				skill.addItem(new Option(Skill.SKILL_ASN_0_STR, 0));
				skill.addItem(new Option(Skill.SKILL_ASN_1_STR, 1));
				skill.addItem(new Option(Skill.SKILL_ASN_2_STR, 2));
				skill.addItem(new Option(Skill.SKILL_ASN_3_STR, 3));
				skill.addItem(new Option(Skill.SKILL_ASN_4_STR, 4));
				skill.addItem(new Option(Skill.SKILL_ASN_5_STR, 5));
				skill.addItem(new Option(Skill.SKILL_ASN_6_STR, 6));
				skill.addItem(new Option(Skill.SKILL_ASN_7_STR, 7));
				skill.addItem(new Option(Skill.SKILL_ASN_8_STR, 8));
				skill.addItem(new Option(Skill.SKILL_ASN_9_STR, 9));
				break;
			case Character.CHAR_ACT2://佣兵(Mercenary) - Act 2
				skill.addItem(new Option(Skill.SKILL_ACT2_0_STR, 0));
				break;
			default:
				skill.addItem(new Option(Skill.SKILL_STANDARD_STR, 0));
				break;
			}
			changeSkill(form, true);
			changeWeapon(form);
			thrownCheck(form);
		} catch (Exception e) {
			TRoneTD error = form.getError();
			error.setText(e.getMessage());
		}
	}

	public void thrownCheck(Form form) {
		Weapon weapon = weaponlist.get(((Option) form.getWeapon().getSelectedItem()).getValue());
		TRCheckBox thrown = form.getThrown();
		if (weapon.getMinB()>0 && (weapon.getType()==Weapon.type_throw || weapon.getType()==Weapon.type_javelin)) {
			thrown.setEnabled(true);
		}else {
			thrown.setEnabled(false);
		}
		doBaseDamage(form);
	}
	
	public void doBaseDamage(Form form) {
		try {
			Weapon weapon = weaponlist.get(((Option) form.getWeapon().getSelectedItem()).getValue());
			TRCheckBox thrown = form.getThrown();
			JComboBox<Option> h2h = form.getH2h();
			int baseMin,baseMax;
			if ((h2h.getItemCount()>1 && h2h.getSelectedIndex()==Weapon.h2h_two_handed) || (thrown.isEnabled() && thrown.isSelected())) {
				baseMin = weapon.getMinB();
				baseMax = weapon.getMaxB();
			}else {
				baseMin = weapon.getMin();
				baseMax = weapon.getMax();
			}
			double eth = form.getEthereal().isSelected() ? 1.5 : 1;
			double weapon_enhanced_damage = form.getWeaponEDText()/100d + 1;
			//on-weapon ED
			min = Math.floor(eth * baseMin * weapon_enhanced_damage);
			max = Math.floor(eth * baseMax * weapon_enhanced_damage);
			// +min/max damage
			int plus_min = form.getPlusMinDamageText();
			int plus_max = form.getPlusMaxDamageText();
			min += plus_min;
			max += plus_max;
			max = min >= max ? min +1 : max;
			form.getWeaponBaseDamage().setText(min.intValue()+" - "+max.intValue());
			calc_final_damage(form);
		} catch (Exception e) {
			logger.error("",e);
		}
	}

	public void calc_final_damage(Form form) {
		try {
			Weapon weapon = weaponlist.get(((Option) form.getWeapon().getSelectedItem()).getValue());
			TRCheckBox thrown = form.getThrown();
			int non_weapon_ed = form.getNonWeaponEDText();
			int skill_ed = form.getSkillEDText();
			double dex_mod,str_mod;
			if (thrown.isEnabled() && thrown.isSelected()) {
				dex_mod = weapon.getDexCoefB()/100d;
				str_mod = weapon.getStrCoefB()/100d;
			}else {
				dex_mod = weapon.getDexCoef()/100d;
				str_mod = weapon.getStrCoef()/100d;
			}
			int dex = form.getDexterityText();
			int str = form.getStrengthText();
			character.setDexterity(dex);
			character.setStrength(str);
			double dex_bonus = dex_mod * dex / 100;
			double str_bonus = str_mod * str / 100;
			Double total_min = min;
			Double total_max = max;
			total_min += Math.floor(min*skill_ed/100 + min*non_weapon_ed/100 + min*dex_bonus + min*str_bonus);
			total_max += Math.floor(max*skill_ed/100 + max*non_weapon_ed/100 + max*dex_bonus + max*str_bonus);
			double phys_average_damage = Math.ceil((total_max + total_min)/2);
			int elem_min = form.getColdMinDamageText()+form.getLightningMinDamageText()+form.getFireMinDamageText();
			int elem_max = form.getColdMaxDamageText()+form.getLightningMaxDamageText()+form.getFireMaxDamageText();
			int poisonDamage = form.getPoisonDamageText();
			int poisonTime = form.getPoisonTimeText();
			double elem_average_damage = Math.ceil((elem_min + elem_max)/2);
			total_min += elem_min;
		    total_max += elem_max;
		    if (total_min > total_max) {
		      total_max = total_min + 1;
		    }
			int CS = form.getCS().getSelectedIndex();
			int DS = form.getDS().getSelectedIndex();
			double doublechance = CS + (DS/100d)*(100-CS);
			doublechance = doublechance > 100 ? 100 : doublechance;
			double final_damage = Math.ceil(phys_average_damage * (1 + (doublechance/100))) + elem_average_damage;
			String damageString1 = df.format(final_damage) + Form.properties.getProperty("DAMAGE_SUFFIX_1")+total_min.intValue()+" - "+total_max.intValue();
			double final_damage_per_sec = 25/fps*final_damage;
			if (poisonDamage>0 && poisonTime>0) {
				final_damage_per_sec += (double)poisonDamage/poisonTime;
			}
			String damageString2 = df.format(final_damage_per_sec) + Form.properties.getProperty("DAMAGE_SUFFIX_2");
			form.getFinalDamage1().setText(damageString1);
			form.getFinalDamage2().setText(damageString2);
			
			String json = form.geTextArea().getText();
			JSONObject jsonObject = null;
			if (json==null || "".equals(json)) {
				jsonObject = new JSONObject();
			}else {
				jsonObject = new JSONObject(json);
			}
			boolean eth = form.getEthereal().isSelected();
			boolean thrownBool = thrown.isEnabled() && thrown.isSelected();
			int plus_min_damage = form.getPlusMinDamageText();
			int plus_max_damage = form.getPlusMaxDamageText();
			int weapon_ed = form.getWeaponEDText();
			int fd_min = form.getFireMinDamageText();
			int fd_max = form.getFireMaxDamageText();
			int ld_min = form.getLightningMinDamageText();
			int ld_max = form.getLightningMaxDamageText();
			int cd_min = form.getColdMinDamageText();
			int cd_max = form.getColdMaxDamageText();
			int pd = poisonDamage;
			int pd_time = poisonTime;
			int cs = form.getCS().getSelectedIndex();
			int ds = form.getDS().getSelectedIndex();
			//转json
			json = printDamageJson(jsonObject,eth,thrownBool, plus_min_damage, plus_max_damage,
					 weapon_ed,non_weapon_ed,skill_ed,fd_min,fd_max,ld_min,ld_max,cd_min,cd_max,
						pd,pd_time,cs,ds);
			form.geTextArea().setText(json);
			form.getError().setText("正常");
		} catch (Exception e) {
			logger.error("",e);
		}
		
	}

	public void changeWeapon(Form form) {
		int uchar = form.getSelectedUchar().getValue();
		Weapon weapon = weaponlist.get(((Option) form.getWeapon().getSelectedItem()).getValue());
		if (weapon.getName_en().equals("-")) {
			form.getEthereal().setEnabled(false);
		}else {
			form.getEthereal().setEnabled(true);
		}
		int type = weapon.getType();
		JComboBox<Option> h2h = form.getH2h();
		if (h2h.getItemCount()>1 && ((uchar != Character.CHAR_BAR) || (type != Weapon.type_2H_sword))) {
			h2h.removeAllItems();
			h2h.addItem(new Option("-", 0));
		}else if ((uchar == Character.CHAR_BAR) && (type == Weapon.type_2H_sword) && (h2h.getItemCount() < 2)){
			h2h.removeAllItems();
			h2h.addItem(new Option(Form.properties.getProperty("GUI_BABA_2H"), 0));
			h2h.addItem(new Option(Form.properties.getProperty("GUI_BABA_1H"), 1));
		}
		changeH2h(form);
	}
	
	public void changeH2h(Form form) {
		int uchar = form.getSelectedUchar().getValue();
		Weapon weapon = weaponlist.get(((Option) form.getWeapon().getSelectedItem()).getValue());
		int type = weapon.getType();
		JComboBox<Option> h2h = form.getH2h();
		JComboBox<Option> c2h = form.getC2h();
		if (((uchar == Character.CHAR_ASN) && (type == Weapon.type_claw))
				|| ((uchar == Character.CHAR_BAR) &&  ((type <= Weapon.type_1H_sword) || (type == Weapon.type_dagger) || (type == Weapon.type_throw) || (type == Weapon.type_javelin) ||
						((type == Weapon.type_2H_sword) && ((h2h.getItemCount() < 2) || (((Option)h2h.getSelectedItem()).getValue() == Weapon.h2h_one_handed)))))){
			if (c2h.getItemCount() > 0) c2h.removeAllItems();

			if (uchar == Character.CHAR_ASN){
				c2h.addItem(new Option("["+Form.properties.getProperty("GUI_ASSA_NONE")+"]",0));

				if (Form.properties.getProperty("LANG").equals("中文"))
					Collections.sort(weaponlist, new WeaponZhComparator());
				for (int i=0; i < weaponlist.size(); i++){
					Weapon c2hWeapon = weaponlist.get(i);
					if (c2hWeapon.getType() == Weapon.type_claw)
					{
						if (LANG.equals("中文"))
							c2h.addItem(new Option(c2hWeapon.getName_zh()+"("+c2hWeapon.getName_en()+")",c2hWeapon.getIndex()));
						else
							c2h.addItem(new Option(c2hWeapon.getName_en()+"("+c2hWeapon.getName_zh()+")",c2hWeapon.getIndex()));
					}
				}
				Collections.sort(weaponlist, new WeaponEnComparator());
			}else{
				c2h.addItem(new Option("["+Form.properties.getProperty("GUI_ASSA_NONE")+"]",0));

				if (LANG.equals("中文"))
					Collections.sort(weaponlist, new WeaponZhComparator());
				for (int i=0; i < weaponlist.size(); i++){
					Weapon c2hWeapon = weaponlist.get(i);
					if ((c2hWeapon.getType() <= Weapon.type_1H_sword) || (c2hWeapon.getType() == Weapon.type_dagger)
							|| (c2hWeapon.getType() == Weapon.type_2H_sword) || (c2hWeapon.getType() == Weapon.type_throw) || (c2hWeapon.getType() == Weapon.type_javelin)){
						if (LANG.equals("中文"))
							c2h.addItem(new Option(c2hWeapon.getName_zh()+"("+c2hWeapon.getName_en()+")",c2hWeapon.getIndex()));
						else
							c2h.addItem(new Option(c2hWeapon.getName_en()+"("+c2hWeapon.getName_zh()+")",c2hWeapon.getIndex()));
					}
				}
				Collections.sort(weaponlist, new WeaponEnComparator());
			}
		}else{
			if (c2h.getItemCount() > 0) c2h.removeAllItems();
			c2h.addItem(new Option("-",0));
		}
		changeLeftWeapon(form);
		changeSkill(form, false);
	}

	public void changeLeftWeapon(Form form) {
		JComboBox<Option> c2h = form.getC2h();
		JComboBox<Option> cwias = form.getCwias();
		if (((c2h.getItemCount() > 1) && (((Option)c2h.getSelectedItem()).getValue() == 0)) || (c2h.getItemCount() < 2)){
			if (cwias.getItemCount() > 0) {
				cwias.removeAllItems();
			}
			cwias.addItem(new Option("-", 0));
		}else if ((c2h.getItemCount() > 1) && (lastC2H == 0)){
			if (cwias.getItemCount() > 0) {
				cwias.removeAllItems();
			}
			for(int i = 0; i < 25; i++){
				cwias.addItem(new Option(i*5+"", i*5));
			}
		}

		lastC2H = ((Option)c2h.getSelectedItem()).getValue();
	}
	
	public void changeZhWeapon(Form form) {
		JComboBox<Option> weapon = form.getWeapon();
		JComboBox<Option> wuqi = form.getWuqi();
		Option selectedItem = (Option)wuqi.getSelectedItem();
		if (weapon.getSelectedIndex() != selectedItem.getValue()) {
			weapon.setSelectedIndex(selectedItem.getValue());
			changeWeapon(form);
		}
	}
	
	public void changeEnWeapon(Form form) {
		JComboBox<Option> weapon = form.getWeapon();
		JComboBox<Option> wuqi = form.getWuqi();
		Option selectedItem = (Option)weapon.getSelectedItem();
		for(int i=0; i<weaponlist.size();i++){
			if (wuqi.getItemAt(i).getValue() == selectedItem.getValue()) {
				if (wuqi.getSelectedIndex() == i) {
					return;
				}
				wuqi.setSelectedIndex(i);
			}
		}
		changeWeapon(form);
	}

	/**
	 * @param form
	 * @param newChar 是否为新角色
	 * @author zhouchenguang
	 * @date 2017年9月30日下午11:06:44
	 * @since 1.0.0
	 */
	public void changeSkill(Form form,boolean newChar) {
		int uchar = form.getSelectedUchar().getValue();
		int skill = ((Option) form.getSkill().getSelectedItem()).getValue();
		Option weapon = (Option) form.getWeapon().getSelectedItem();
		int type = weaponlist.get(weapon.getValue()).getType();
		// ***********************IAS************************************
		JComboBox<Option> ias = form.getIas();
		if (!(uchar==Character.CHAR_BAR && skill==Skill.SKILL_BAR_WHIRLWIND_NO)){ //旋风野蛮人除外
			if (newChar || (uchar==Character.CHAR_BAR && lastSkill==Skill.SKILL_BAR_WHIRLWIND_NO)) {
				if (ias.getItemCount() > 0) ias.removeAllItems();
				for(int i = 0; i < 61; i++) ias.addItem(new Option(i*5+"", i*5));
			}
		}else {//旋风野蛮人
			if (ias.getItemCount() > 0) ias.removeAllItems();
			ias.addItem(new Option("-", 0));
		}
		// *********************Weapon-IAS	*******************************
		JComboBox<Option> weaponIas = form.getWeaponIas();
		// weredruid/baba/assa left claw
		if ((uchar==Character.CHAR_DRU && skill!=Skill.SKILL_DRU_STANDARD_NO) ||
				uchar==Character.CHAR_BAR ||
				(uchar==Character.CHAR_ASN && type==Weapon.type_claw)) {
			if (newChar ||
					(uchar==Character.CHAR_DRU && lastSkill==Skill.SKILL_DRU_STANDARD_NO) ||
					(uchar==Character.CHAR_BAR && lastSkill!=Skill.SKILL_BAR_WHIRLWIND_NO) ||
					(uchar==Character.CHAR_ASN && lastType!=Weapon.type_claw)) {
				if (weaponIas.getItemCount() > 0) weaponIas.removeAllItems();
				for(int i=0; i<25; i++) weaponIas.addItem(new Option(i*5+"", i*5));
			}
		}else {// others
			if (weaponIas.getItemCount() > 0) weaponIas.removeAllItems();
			weaponIas.addItem(new Option("-", 0));
		}
		// ********************Werewolf	*******************************
		JComboBox<Option> ww = form.getWW();
		if (uchar==Character.CHAR_DRU &&
				skill>Skill.SKILL_DRU_STANDARD_NO &&
				skill<Skill.SKILL_DRU_WEREBEAR_NO) {
			if (newChar ||
					(lastSkill!=Skill.SKILL_DRU_WEREWOLF_NO && lastSkill!=Skill.SKILL_DRU_WEREWOLF_FERAL_RAGE_NO)) {
				if (ww.getItemCount() > 0) ww.removeAllItems();
				Option[] sdWereWolf = Option.getOptionsValue(Form.properties.getProperty("SD_werwolf"));
				for (Option option : sdWereWolf) ww.addItem(option);
			}
		}else {
			if (ww.getItemCount() > 0) ww.removeAllItems();
			ww.addItem(new Option("-", 0));
		}
		// ********************Burst Of Speed*******************************
		JComboBox<Option> burst = form.getBurst();
		if (uchar==Character.CHAR_ASN && newChar) {
			if (burst.getItemCount() > 0) burst.removeAllItems();
			Option[] sdBurst = Option.getOptionsValue(Form.properties.getProperty("SD_burstofspeed"));
			for (Option option : sdBurst) burst.addItem(option);
		}else if (uchar != Character.CHAR_ASN) {
			if (burst.getItemCount() > 0) burst.removeAllItems();
			burst.addItem(new Option("-", 0));
		}
		// ********************Frenzy*******************************
		JComboBox<Option> frenzy = form.getFrenzy();
		if (uchar==Character.CHAR_BAR && newChar) {
			if (frenzy.getItemCount() > 0) frenzy.removeAllItems();
			Option[] sdFrenzy = Option.getOptionsValue(Form.properties.getProperty("SD_frenzy"));
			for (Option option : sdFrenzy) frenzy.addItem(option);
		}else if (uchar !=Character.CHAR_BAR) {
			if (frenzy.getItemCount() > 0) frenzy.removeAllItems();
			frenzy.addItem(new Option("-", 0));
		}
		// ********************Fanaticism*******************************
		JComboBox<Option> fana = form.getFana();
		if (newChar) {
			if (fana.getItemCount() > 0) fana.removeAllItems();
			Option[] sdFana = Option.getOptionsValue(Form.properties.getProperty("SD_fanaticism"));
			for (Option option : sdFana) fana.addItem(option);
		}
		lastSkill = skill;
		lastType = type;
		compute(form);
	}

	public void compute(Form form) {
		try {
			capped        = 0;
			Weapon l_weapon  = null;
			int l_ias     = 0;
			int skill_ias = 0;
			Option uchar = form.getSelectedUchar();
			Option skill = (Option) form.getSkill().getSelectedItem();
			Option fanaOption = (Option) form.getFana().getSelectedItem();
			int fana = fanaOption.getValue();
			Option wwOption = (Option) form.getWW().getSelectedItem();
			int ww = wwOption.getValue();
			Option burstOption = (Option) form.getBurst().getSelectedItem();
			int burst = burstOption.getValue();
			Option frenzyOption = (Option) form.getFrenzy().getSelectedItem();
			int frenzyval = frenzyOption.getValue();
			Option selectedH2h = (Option) form.getH2h().getSelectedItem();
			if (selectedH2h == null) {//初始化h2h会误触发compute
				return;
			}
			int h2h = selectedH2h.getValue();
			Option c2h = (Option) form.getC2h().getSelectedItem();
			Weapon r_weapon = weaponlist.get(((Option) form.getWeapon().getSelectedItem()).getValue());
			r_weapon.setEthereal(form.getEthereal().isSelected());
			Option weaponIas = (Option) form.getWeaponIas().getSelectedItem();
			int r_ias = weaponIas.getValue();
			int item_ias = ((Option) form.getIas().getSelectedItem()).getValue();
			if (c2h.getValue() > 0) {
				l_weapon = weaponlist.get(c2h.getValue());
				l_ias = ((Option) form.getCwias().getSelectedItem()).getValue();
			}
			skill_ias = fana + frenzyval + ww + burst;
			//------------ calculate fps -------------//
			fps =   calculateFps(uchar.getValue(), skill.getValue(), r_weapon, l_weapon, item_ias, r_ias, l_ias, skill_ias, h2h);
			// print results
			String weapontype = "";
			String weapontype2 = "";
			String fpsString1 = df.format(fps) + Form.properties.getProperty("FPS_SUFFIX_1");
			String fpsString2 = "";
			String spsString  = df.format(25/fps) + Form.properties.getProperty("FPS_SUFFIX_2");
			if (Double.isNaN(fps)) {
				fpsString1 = Form.properties.getProperty("FPS_NOT_AVAIL");
				spsString = Form.properties.getProperty("FPS_NOT_AVAIL");
			}
			weapontype = printWeaponType(r_weapon);
			if (l_weapon != null) {
				weapontype2 = printWeaponType(l_weapon);
			}
			if (capped > 0) fpsString2 = Form.properties.getProperty("FPS_IAS_CAP");
			form.getWeaponType1().setText(weapontype + " [" + r_weapon.getSpeed() + "]");
			if (l_weapon != null) {
				form.getWeaponType2().setText(weapontype2 + " [" + l_weapon.getSpeed() + "]");
			}
			form.getFps1().setText(fpsString1);
			form.getFps2().setText(fpsString2);
			form.getSps1().setText(spsString);
			
			//转json
			String json = printSpeedJson(l_weapon, l_ias, skill, fanaOption, wwOption, burstOption,
					frenzyOption, selectedH2h, r_weapon, r_ias, item_ias);
			form.geTextArea().setText(json);
			
			calc_final_damage(form);
		} catch (Exception e) {
			TRoneTD error = form.getError();
			logger.error("",e);
			error.setText(e.getMessage());
		}
	}
	
	public void jsonCalc(Form form) {
		String json = form.geTextArea().getText();
		if (json==null || "".equals(json)) {
			return;
		}
		TRoneTD error = form.getError();
		JSONObject jsonObject = new JSONObject(json);
		JSONObject uchar = (JSONObject) jsonObject.get("人物");
		if (jsonSelect(uchar, "名称", form.getUchar()) == false) {
			error.setText("\"人物\"错误");
			return;
		}
		if (jsonInput(uchar, "敏捷", form.getDexterity()) == false) {
			error.setText("\"敏捷\"错误");
			return;
		}
		if (jsonInput(uchar, "力量", form.getStrength()) == false) {
			error.setText("\"力量\"错误");
			return;
		}
		if (jsonObject.has("右手武器")) {
			JSONObject rightWeapon = (JSONObject) jsonObject.get("右手武器");
			if (jsonSelect(rightWeapon, "名称", form.getWeapon()) == false) {
				error.setText("\"右手武器名称\"错误");
				return;
			}
			if (jsonSelect(rightWeapon, "无形", form.getEthereal()) == false) {
				error.setText("\"无形\"错误");
				return;
			}
			if (jsonSelect(rightWeapon, "手持", form.getH2h()) == false) {
				error.setText("\"右手武器手持\"错误");
				return;
			}
			if (jsonSelect(rightWeapon, "武器提速", form.getWeaponIas()) == false) {
				error.setText("\"右手武器提速\"错误");
				return;
			}
			if (jsonInput(rightWeapon, "武器增加伤害", form.getWeaponED()) == false) {
				error.setText("\"武器增加伤害\"错误");
				return;
			}
		}
		if (jsonObject.has("左手武器")) {
			JSONObject leftWeapon = (JSONObject) jsonObject.get("左手武器");
			if (jsonSelect(leftWeapon, "名称", form.getC2h()) == false) {
				error.setText("\"左手武器名称\"错误");
				return;
			}
			if (jsonSelect(leftWeapon, "武器提速", form.getCwias()) == false) {
				error.setText("\"左手武器提速\"错误");
				return;
			}
		}
		if (jsonSelect(jsonObject, "装备提速", form.getIas()) == false) {
			error.setText("\"装备提速\"错误");
			return;
		}
		if (jsonInput(jsonObject, "非武器增加伤害", form.getNonWeaponED()) == false) {
			error.setText("\"非武器增加伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "技能增加伤害", form.getSkillED()) == false) {
			error.setText("\"技能增加伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "最小加成伤害", form.getPlusMinDamage()) == false) {
			error.setText("\"最小加成伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "最大加成伤害", form.getPlusMaxDamage()) == false) {
			error.setText("\"最大加成伤害\"错误");
			return;
		}
		if (jsonSelect(jsonObject, "双倍打击", form.getCS()) == false) {
			error.setText("\"双倍打击\"错误");
			return;
		}
		if (jsonSelect(jsonObject, "致命一击", form.getDS()) == false) {
			error.setText("\"致命一击\"错误");
			return;
		}
		if (jsonInput(jsonObject, "火焰最小伤害", form.getFireMinDamage()) == false) {
			error.setText("\"火焰最小伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "火焰最大伤害", form.getFireMaxDamage()) == false) {
			error.setText("\"火焰最大伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "闪电最小伤害", form.getLightningMinDamage()) == false) {
			error.setText("\"闪电最小伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "闪电最大伤害", form.getLightningMaxDamage()) == false) {
			error.setText("\"闪电最大伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "冰冻最小伤害", form.getColdMinDamage()) == false) {
			error.setText("\"冰冻最小伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "冰冻最大伤害", form.getColdMaxDamage()) == false) {
			error.setText("\"冰冻最大伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "毒素伤害", form.getPoisonDamage()) == false) {
			error.setText("\"毒素伤害\"错误");
			return;
		}
		if (jsonInput(jsonObject, "毒素持续时间", form.getPoisonTime()) == false) {
			error.setText("\"毒素持续时间\"错误");
			return;
		}
		if (jsonObject.has("技能")) {
			String skill = jsonObject.getString("技能");
			if (skill.equals("投掷")) {
				form.getSkill().setSelectedIndex(Skill.SKILL_STANDARD_NO);
				TRCheckBox thrown = form.getThrown();
				if (!thrown.isEnabled()) {
					error.setText("\"投掷\"错误");
					return;
				}else {
					thrown.setSelected(true);
				}
			}else if (skill.equals(Skill.SKILL_STANDARD_STR)) {
				form.getSkill().setSelectedIndex(Skill.SKILL_STANDARD_NO);
				TRCheckBox thrown = form.getThrown();
				thrown.setSelected(false);
			}else if (jsonSelect(jsonObject, "技能", form.getSkill()) == false) {
				error.setText("\"技能\"错误");
				return;
			}
		}
		if (jsonSelect(jsonObject, "狂热灵气", form.getFana()) == false) {
			error.setText("\"狂热灵气\"错误");
			return;
		}
		if (jsonSelect(jsonObject, "狂乱", form.getFrenzy()) == false) {
			error.setText("\"狂乱\"错误");
			return;
		}
		if (jsonSelect(jsonObject, "狼人", form.getWW()) == false) {
			error.setText("\"狼人\"错误");
			return;
		}
		if (jsonSelect(jsonObject, "速度爆发", form.getBurst()) == false) {
			error.setText("\"速度爆发\"错误");
			return;
		}
	}
	
	private boolean jsonSelect(JSONObject jsonObject, String key, JComboBox<Option> box) {
		if (jsonObject.has(key) == false) {
			return true;
		}
		String name = jsonObject.getString(key);
		for(int i=0; i<box.getItemCount(); i++){
			Option option = box.getItemAt(i);
			if (name.equals(option.getLable())) {
				box.setSelectedItem(option);
				return true;
			}
		}
		return false;
	}
	
	private boolean jsonSelect(JSONObject jsonObject, String key, TRCheckBox box) {
		try {
			if (jsonObject.has(key) == false) {
				return true;
			}
			if (!box.isEnabled()) {
				return false;
			}
			boolean name = jsonObject.getBoolean(key);
			box.setSelected(name);
			return true;
		} catch (JSONException e) {
			logger.error("",e);
			return false;
		}
	}
	
	private boolean jsonInput(JSONObject jsonObject, String key, JTextField textField) {
		try {
			if (jsonObject.has(key) == false) {
				return true;
			}
			String name = jsonObject.getString(key);
			textField.setText(name);
			return true;
		} catch (JSONException e) {
			logger.error("",e);
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	private String printFullJson(Weapon l_weapon, int l_ias, Option skill, Option fanaOption,
			Option wwOption, Option burstOption, Option frenzyOption,
			Option selectedH2h, Weapon r_weapon, int r_ias, int item_ias,int plus_min_damage,int plus_max_damage,
			int weapon_ed,int non_weapon_ed,int skill_ed,int fd_min,int fd_max,int ld_min,int ld_max,int cd_min,int cd_max,
			int pd,int pd_time,int cs,int ds) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("人物", character.toMap());
		if (!r_weapon.getName_en().equals("-")) {
			Map<String, String> rightWeapon = new HashMap<>();
			rightWeapon.put("名称", r_weapon.getName_en());
			rightWeapon.put("无形", Boolean.toString(r_weapon.isEthereal()));
			if (selectedH2h.getValue() > 0) {
				rightWeapon.put("手持", selectedH2h.getLable());
			}
			if (r_ias > 0) {
				rightWeapon.put("武器提速", r_ias+"");
			}
			if (weapon_ed > 0) {
				rightWeapon.put("武器增加伤害", weapon_ed+"");
			}
			jsonObject.put("右手武器", rightWeapon);
		}
		if (l_weapon != null) {
			Map<String, String> leftWeapon = new HashMap<>();
			leftWeapon.put("名称", l_weapon.getName_zh());
			if (l_ias > 0) {
				leftWeapon.put("武器提速", l_ias+"");
			}
			jsonObject.put("左手武器", leftWeapon);
		}
		putJsonObject(jsonObject, "装备提速", item_ias);
		putJsonObject(jsonObject, "非武器增加伤害", non_weapon_ed);
		putJsonObject(jsonObject, "技能增加伤害", skill_ed);
		putJsonObject(jsonObject, "最小加成伤害", plus_min_damage);
		putJsonObject(jsonObject, "最大加成伤害", plus_max_damage);
		putJsonObject(jsonObject, "双倍打击", cs);
		putJsonObject(jsonObject, "致命一击", ds);
		putJsonObject(jsonObject, "火焰最小伤害", fd_min);
		putJsonObject(jsonObject, "火焰最大伤害", fd_max);
		putJsonObject(jsonObject, "闪电最小伤害", ld_min);
		putJsonObject(jsonObject, "闪电最大伤害", ld_max);
		putJsonObject(jsonObject, "冰冻最小伤害", cd_min);
		putJsonObject(jsonObject, "冰冻最大伤害", cd_max);
		putJsonObject(jsonObject, "毒素伤害", pd);
		putJsonObject(jsonObject, "毒素持续时间", pd_time);
		if (skill.getValue() > 0) {
			jsonObject.put("技能", skill.getLable());
		}else if (skill.getValue() == 0) {
			if (character.getId()<Character.CHAR_ACT2 && (r_weapon.getType()==Weapon.type_throw || r_weapon.getType()==Weapon.type_javelin) && r_weapon.isThrown()) {
				jsonObject.put("技能", "投掷");
			}else {
				jsonObject.put("技能", skill.getLable());
			}
		}
		putJsonObject(jsonObject, "狂热灵气", fanaOption);
		putJsonObject(jsonObject, "狂乱", frenzyOption);
		putJsonObject(jsonObject, "狼人", wwOption);
		putJsonObject(jsonObject, "速度爆发", burstOption);
		return jsonObject.toString();
	}
	
	private String printSpeedJson(Weapon l_weapon, int l_ias, Option skill, Option fanaOption, Option wwOption,
			Option burstOption, Option frenzyOption, Option selectedH2h, Weapon r_weapon, int r_ias, int item_ias) {
		JSONObject jsonObject = new JSONObject();
		if (!r_weapon.getName_en().equals("-")) {
			Map<String, String> rightWeapon = new HashMap<>();
			rightWeapon.put("名称", r_weapon.getName_en());
			rightWeapon.put("无形", Boolean.toString(r_weapon.isEthereal()));
			if (selectedH2h.getValue() > 0) {
				rightWeapon.put("手持", selectedH2h.getLable());
			}
			if (r_ias > 0) {
				rightWeapon.put("武器提速", r_ias+"");
			}
			jsonObject.put("右手武器", rightWeapon);
		}
		if (l_weapon != null) {
			Map<String, String> leftWeapon = new HashMap<>();
			leftWeapon.put("名称", l_weapon.getName_zh());
			if (l_ias > 0) {
				leftWeapon.put("武器提速", l_ias+"");
			}
			jsonObject.put("左手武器", leftWeapon);
		}
		putJsonObject(jsonObject, "装备提速", item_ias);
		jsonObject.put("技能", skill.getLable());
		putJsonObject(jsonObject, "狂热灵气", fanaOption);
		putJsonObject(jsonObject, "狂乱", frenzyOption);
		putJsonObject(jsonObject, "狼人", wwOption);
		putJsonObject(jsonObject, "速度爆发", burstOption);
		return jsonObject.toString();
	}
	
	private String printDamageJson(JSONObject jsonObject, boolean eth, boolean thrownBool, int plus_min_damage, int plus_max_damage, int weapon_ed,
			int non_weapon_ed, int skill_ed, int fd_min, int fd_max, int ld_min, int ld_max, int cd_min, int cd_max,
			int pd, int pd_time, int cs, int ds) {
		jsonObject.put("人物", character.toMap());
		if (jsonObject.has("右手武器")) {
			JSONObject rightWeapon = (JSONObject) jsonObject.get("右手武器");
			rightWeapon.put("无形", Boolean.toString(eth));
			if (weapon_ed > 0) {
				rightWeapon.put("武器增加伤害", weapon_ed+"");
			}
		}
		putJsonObject(jsonObject, "非武器增加伤害", non_weapon_ed);
		putJsonObject(jsonObject, "技能增加伤害", skill_ed);
		putJsonObject(jsonObject, "最小加成伤害", plus_min_damage);
		putJsonObject(jsonObject, "最大加成伤害", plus_max_damage);
		putJsonObject(jsonObject, "双倍打击", cs);
		putJsonObject(jsonObject, "致命一击", ds);
		putJsonObject(jsonObject, "火焰最小伤害", fd_min);
		putJsonObject(jsonObject, "火焰最大伤害", fd_max);
		putJsonObject(jsonObject, "闪电最小伤害", ld_min);
		putJsonObject(jsonObject, "闪电最大伤害", ld_max);
		putJsonObject(jsonObject, "冰冻最小伤害", cd_min);
		putJsonObject(jsonObject, "冰冻最大伤害", cd_max);
		putJsonObject(jsonObject, "毒素伤害", pd);
		putJsonObject(jsonObject, "毒素持续时间", pd_time);
		if (thrownBool) {
			jsonObject.put("技能", "投掷");
		}
		return jsonObject.toString();
	}
	
	private void putJsonObject(JSONObject jsonObject,String key,int value) {
		jsonObject.remove(key);
		if (value > 0) {
			jsonObject.put(key, value+"");
		}
	}
	
	private void putJsonObject(JSONObject jsonObject,String key,Option option) {
		jsonObject.remove(key);
		if (option.getValue() > 0) {
			jsonObject.put(key, option.getLable());
		}
	}
	
	/**
	 * @param r_weapon
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月7日上午12:20:49
	 * @since 1.0.0
	 */
	private String printWeaponType(Weapon r_weapon ) {
		String weapontype = "";
		switch (r_weapon.getType())
		{
		case Weapon.type_wand: weapontype = Form.properties.getProperty("DYN_WEAPON_1"); break;
		case Weapon.type_scepter: weapontype = Form.properties.getProperty("DYN_WEAPON_2"); break;
		case Weapon.type_1H_axe: weapontype = Form.properties.getProperty("DYN_WEAPON_3"); break;
		case Weapon.type_orb: weapontype = Form.properties.getProperty("DYN_WEAPON_4"); break;
		case Weapon.type_1H_mace: weapontype = Form.properties.getProperty("DYN_WEAPON_5"); break;
		case Weapon.type_1H_sword: weapontype = Form.properties.getProperty("DYN_WEAPON_6"); break;
		case Weapon.type_dagger: weapontype = Form.properties.getProperty("DYN_WEAPON_7"); break;
		case Weapon.type_2H_sword: weapontype = Form.properties.getProperty("DYN_WEAPON_8"); break;
		case Weapon.type_spear: weapontype = Form.properties.getProperty("DYN_WEAPON_9"); break;
		case Weapon.type_2H_axe: weapontype = Form.properties.getProperty("DYN_WEAPON_10"); break;
		case Weapon.type_staff: weapontype = Form.properties.getProperty("DYN_WEAPON_11"); break;
		case Weapon.type_2H_mace: weapontype = Form.properties.getProperty("DYN_WEAPON_12"); break;
		case Weapon.type_polearm: weapontype = Form.properties.getProperty("DYN_WEAPON_13"); break;
		case Weapon.type_bow: weapontype = Form.properties.getProperty("DYN_WEAPON_14"); break;
		case Weapon.type_crossbow: weapontype = Form.properties.getProperty("DYN_WEAPON_15"); break;
		case Weapon.type_javelin: weapontype = Form.properties.getProperty("DYN_WEAPON_16"); break;
		case Weapon.type_throw: weapontype = Form.properties.getProperty("DYN_WEAPON_17"); break;
		case Weapon.type_claw: weapontype = Form.properties.getProperty("DYN_WEAPON_18"); break;
		}
		return weapontype;
	}

	private Double calculateFps(int uchar, int skill, Weapon r_weapon, Weapon l_weapon, int item_ias, int r_ias,
			int l_ias, int skill_ias, int h2h) {
		double fps = Double.NaN;
		// general initialization
		int r_base = -r_weapon.getSpeed();
		int l_base = r_base;
		double effias = skill_ias + r_base + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
		int type = r_weapon.getType();
		int l_type = type;
		if (l_weapon != null) {
			l_base = -l_weapon.getSpeed();
			l_type = l_weapon.getType();
			if (l_weapon.getStandby()>=0 && l_weapon.getStandby()!=uchar) {
				return Double.NaN;
			}
		}
		if (r_weapon.getStandby()>=0 && r_weapon.getStandby()!=uchar) {
			return Double.NaN;
		}
		// Smite weapon check 其他类型都是双手武器，不能使用盾击
		if (uchar==Character.CHAR_PAL && skill==Skill.SKILL_PAL_SMITE_NO &&
				type>=Weapon.type_1H_sword && type!=Weapon.type_dagger && type!=Weapon.type_throw && type!=Weapon.type_javelin) {
			return Double.NaN;
		}
		// set proper base frames
		int baseframe = -1;
		if (uchar < Character.CHAR_ACT2) {
			baseframe = Weapon.baseframes[type-1][uchar];
		}
		// skill specific attack baseframes
		// Zeal
		if ((uchar == Character.CHAR_PAL) && (skill == Skill.SKILL_PAL_ZEAL_NO)) baseframe = 6;
		// Smite
		if ((uchar ==Character.CHAR_PAL) && (skill == Skill.SKILL_PAL_SMITE_NO)) baseframe = 11;
		// 2H Zeal
		if ((uchar == Character.CHAR_PAL) && (skill == Skill.SKILL_PAL_ZEAL_NO) && ((type == Weapon.type_2H_sword) || (type == Weapon.type_spear))) baseframe = 7;
		if ((uchar == Character.CHAR_PAL) && (skill == Skill.SKILL_PAL_ZEAL_NO) && (type >= Weapon.type_2H_axe && type <= Weapon.type_polearm)) baseframe = 8;
		// Strafe + Bow
		if ((uchar == Character.CHAR_AMA) && (skill == Skill.SKILL_AMA_STRAFE_NO) && (type == Weapon.type_bow)) baseframe = 3;
		// Strafe + XBow
		if ((uchar == Character.CHAR_AMA) && (skill == Skill.SKILL_AMA_STRAFE_NO) && (type == Weapon.type_crossbow)) baseframe = 5;
		// Fend
		if ((uchar == Character.CHAR_AMA) && (skill == Skill.SKILL_AMA_FEND_NO)) baseframe = 6;
		// Paladin with 2H swords
		if ((uchar == Character.CHAR_PAL) && (skill == Skill.SKILL_PAL_STANDARD_NO) && (type == Weapon.type_2H_sword))
		{
			effias = cap (effias, -100, 75);
			Double fps1 = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256))-1;
			Double fps2 = Math.ceil(256*(baseframe+2)/Math.floor((100+effias)/100*256))-1;
			fps = (fps1+fps2)/2;
		}
		// Zeal
		else if ((uchar == Character.CHAR_PAL) && (skill == Skill.SKILL_PAL_ZEAL_NO))
		{
			effias = cap (effias, -100, 75);
			if ((type == Weapon.type_bow)||(type == Weapon.type_crossbow)||(type == Weapon.type_claw))
			{
				fps = Double.NaN;
			}
			else
			{
				fps = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256));
			}
		}
		// Strafe
		else if ((uchar == Character.CHAR_AMA) && (skill == Skill.SKILL_AMA_STRAFE_NO))
		{
			effias = cap (effias, -100, 75);
			if (type == Weapon.type_bow)
			{
				fps = Math.ceil(baseframe/((100+effias)/100));
			}
			else if (type == Weapon.type_crossbow)
			{
				fps = baseframe/((100+effias)/100);
				if (fps > (Math.floor(fps)+0.5)) fps = Math.floor(fps) + 1;
				else if (fps > Math.floor(fps)) fps = Math.floor(fps) + 0.5;
			}
			else if (baseframe > 5)
			{
				fps = Double.NaN;
			}
		}
		// Fend
		else if ((uchar == Character.CHAR_AMA) && (skill == Skill.SKILL_AMA_FEND_NO))
		{
			if (type == Weapon.type_spear) //spears
			{
				fps = 10;
				for (int i=0; i < Skill.SD_fend_spear.length; i++)
				{
					if (effias >= Skill.SD_fend_spear[i]) fps -= 1;
				}
				if (fps <= 5)
				{
					fps    = 5;
					capped = 1;
				}
			}
			else if (type == Weapon.type_javelin) // javelins
			{
				fps = 10;
				for (int i=0; i < Skill.SD_fend_jav.length; i++)
				{
					if (effias >= Skill.SD_fend_jav[i]) fps -= 1;
				}
				if (fps <= 5)
				{
					fps    = 5;
					capped = 1;
				}
			}
			else
			{
				fps = Double.NaN;
			}
		}
		// Jab with spears
		else if ((uchar == Character.CHAR_AMA) && (skill == Skill.SKILL_AMA_JAB_NO) && (type != Weapon.type_javelin))
		{
			fps = 14;
			for (int i=0; i < Skill.SD_jab.length; i++)
			{
				if (effias >= Skill.SD_jab[i]) fps -= 0.5;
			}

			if (type != Weapon.type_spear)
			{
				fps = Double.NaN;
			}
			else if (fps <= 4)
			{
				fps    = 4;
				capped = 1;
			}
		}
		else if ((uchar == Character.CHAR_AMA) && (skill == Skill.SKILL_AMA_IMPALE_NO))
		{
			if (effias > 104)
			{
				effias = 75;
				capped = 1;
			}
			fps = Math.ceil(128*(35+1)/Math.floor((69+effias)/69*128));
		}
		// Barbar normal
		else if ((uchar == Character.CHAR_BAR) && (skill == Skill.SKILL_BAR_STANDARD_NO))
		{
			if ((type <= Weapon.type_1H_sword) || (type == Weapon.type_dagger) || (type == Weapon.type_throw) || (type == Weapon.type_javelin) || ((type == Weapon.type_2H_sword) && (h2h > Weapon.h2h_two_handed)))
			{
				effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
				Double speed_inc = cap(100 + (r_base + l_base) / 2 + effias, 15, 175);
				Double fps1 = Math.ceil(256 * 16 / Math.floor(256 * speed_inc / 100)) - 1;

				effias = skill_ias + Math.floor(120*(item_ias+l_ias)/(120+item_ias+l_ias));
				speed_inc = cap(100 + (r_base + l_base) / 2  + l_base - r_base + effias, 15, 175);
				Double fps2 = Math.ceil(256 * 12 / Math.floor(256 * speed_inc / 100)) - 1;

				fps = (fps1 + fps2) / 2;
			}
			else
			{
				effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
				Double speed_inc = cap(100 + (r_base + l_base) / 2 + effias, 15, 175);
				fps = Math.ceil(256 * (baseframe+1) / Math.floor(256 * speed_inc / 100)) - 1;
			}
		}
		// DOUBLE_SWING
		else if ((uchar == Character.CHAR_BAR) && (skill == Skill.SKILL_BAR_DOUBLE_SWING_NO))
		{
			effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
			Double speed_inc = cap(120 + (r_base + l_base) / 2 + effias, 15, 175);
			fps = Math.ceil(256 * 17 / Math.floor(256 * speed_inc / 100)) / 2;
		}
		//专心(Concentrate)狂战士(Berserk)重击(Bash)击晕(Stun)
		else if ((uchar == Character.CHAR_BAR) && (skill > Skill.SKILL_BAR_WHIRLWIND_NO))
		{
			if ((type == Weapon.type_2H_sword) && (h2h > Weapon.h2h_two_handed))
			{
				baseframe = 15;
			}
			effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
			Double speed_inc = cap(100 + (r_base + l_base) / 2 + effias, 15, 175);
			fps = Math.ceil(256 * (baseframe+1) / Math.floor(256 * speed_inc / 100)) - 1;
		}
		// DOUBLE_THROW / Jab with javelins
		else if (((uchar == Character.CHAR_BAR) && (skill == Skill.SKILL_BAR_DOUBLE_THROW_NO)) || ((uchar == Character.CHAR_AMA) && (skill == Skill.SKILL_AMA_JAB_NO) && (type == Weapon.type_javelin)))
		{
			effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
			Double speed_inc = cap(70 + (r_base + l_base) / 2 + effias, 15, 175);
			fps = Math.ceil(256 * 12 / Math.floor(256 * speed_inc / 100)) / 2;
		}
		// FRENZY
		else if ((uchar == Character.CHAR_BAR) && (skill == Skill.SKILL_BAR_FRENZY_NO))
		{
			effias = skill_ias + Math.floor(120*(item_ias+r_ias)/(120+item_ias+r_ias));
			Double speed_inc = cap(70 + (r_base + l_base) / 2 + effias, 15, 175);
			fps = Math.ceil(256 * 17 / Math.floor(256 * speed_inc / 100)) / 2;
		}
		// WHIRLWIND
		else if ((uchar == Character.CHAR_BAR) && (skill == Skill.SKILL_BAR_WHIRLWIND_NO))
		{
			int fps1;
			Double speed_inc = cap(100 + r_ias + r_base, 15, 175);
			if ((type < Weapon.type_spear) || (type == Weapon.type_throw) || (type == Weapon.type_javelin))
				fps1 = ww_cap(Math.floor(256 * 16 / Math.floor(256 * speed_inc /100)));
			else
				fps1 = ww_cap(Math.floor(256 * 19 / Math.floor(256 * speed_inc /100)));

			int fps2 = fps1;
			if (l_weapon != null)
			{
				speed_inc = cap(100 + l_ias + l_base, 15, 175);
				if ((l_type < Weapon.type_spear) || (type == Weapon.type_throw) || (type == Weapon.type_javelin))
					fps2 = ww_cap(Math.floor(256 * 16 / Math.floor(256 * speed_inc /100)));
				else
					fps2 = ww_cap(Math.floor(256 * 19 / Math.floor(256 * speed_inc /100)));
			}

			fps = (fps1 + fps2) / 2;

			if (l_weapon != null)
			{
				fps = fps / 2;
			}
		}
		// 变身
		else if ((uchar == Character.CHAR_DRU) && (skill > Skill.SKILL_DRU_STANDARD_NO))
		{
			int prev ;
			int base ;
			effias   = cap (effias, -100, 75);

			if (skill < Skill.SKILL_DRU_WEREBEAR_NO) // Werwolf
			{
				baseframe = Weapon.baseframes[type-1][uchar+1];
				prev = 9;
				base = 13;
				if ((skill == Skill.SKILL_DRU_WEREWOLF_HUNGER_NO) || (skill == Skill.SKILL_DRU_WEREWOLF_RABIES_NO)) // Hunger/RABIES
				{
					base = 10;
				}
				else if (skill == Skill.SKILL_DRU_WEREWOLF_FURY_NO) // Fury
				{
					base = 7;
				}
			}
			else // WEREBEAR
			{
				baseframe = Weapon.baseframes[type-1][uchar+2];
				prev = 10;
				base = 12;
				if (skill == 10)
				{
					base = 10;
				}
			}

			Double delay = Math.floor(256 * baseframe / Math.floor(256 * (100 + r_ias + r_base) / 100));
			Double anim_speed = Math.floor(prev * 256 / delay);
			if (skill == Skill.SKILL_DRU_WEREWOLF_FURY_NO)
			{
				fps = Math.ceil(256 * base / Math.floor((100 + effias) / 100 * anim_speed));
			}
			else
			{
				fps = Math.ceil(256 * base / Math.floor((100 + effias) / 100 * anim_speed)) - 1;
			}
		}
		// Assassin
		else if (uchar == Character.CHAR_ASN)
		{
			int fps1;
			int fps2;
			int fps3;
			baseframe = Weapon.baseframes[type-1][uchar+2];
			double ceffias;
			if ((skill > Skill.SKILL_ASN_PHOENIX_STRIKE_NO) && (l_weapon != null))
			{
				effias  = (r_base + l_base) / 2 + skill_ias + Math.floor(120 * (item_ias + r_ias) / (120 + item_ias + r_ias));
				ceffias = (r_base + l_base) / 2 + skill_ias + Math.floor(120 * (item_ias + l_ias) / (120 + item_ias + l_ias));
			}
			else
			{
				effias  = r_base + skill_ias + Math.floor(120 * (item_ias + r_ias) / (120 + item_ias + r_ias));
				ceffias = l_base + skill_ias + Math.floor(120 * (item_ias + l_ias) / (120 + item_ias + l_ias));
			}

			if ((((skill > Skill.SKILL_ASN_PHOENIX_STRIKE_NO) && (skill < Skill.SKILL_ASN_DRAGON_TAIL_NO)) && (type != Weapon.type_claw)) ||
					((skill < Skill.SKILL_ASN_FISTS_OF_FIRE_NO) && (skill != Skill.SKILL_ASN_STANDARD_NO) && ((type == Weapon.type_bow) || (type == Weapon.type_crossbow))))
			{
				fps = Double.NaN;
			}
			else if (skill == Skill.SKILL_ASN_STANDARD_NO) // standard
			{
				if (type != Weapon.type_claw)
				{
					fps = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256))-1;
				}
				else
				{
					fps1 = 16;
					fps2 = 17;
					fps3 = 17;
					for (int i=0; i < Weapon.SD_clawslash_right.length; i++)
					{
						if (effias >= Weapon.SD_clawslash_right[i]) fps1--;
					}
					for (int i=0; i < Weapon.SD_clawthrust_right.length; i++)
					{
						if (effias >= Weapon.SD_clawthrust_right[i]) fps2--;
					}
					for (int i=0; i < Weapon.SD_clawslash_left.length; i++)
					{
						if (ceffias >= Weapon.SD_clawslash_left[i]) fps3--;
					}
					if (l_weapon == null) // 1H
					{
						fps = (fps1+fps2)/2;
						if ((fps1 <= 7) && (fps2 <= 8))
						{
							fps    = (7+8)/2;
							capped = 1;
						}
					}
					else // 2H
					{
						fps = (fps1+fps2+2*fps3)/4;
						if ((fps1 <= 7) && (fps2 <= 8) && (fps3 <= 8))
						{
							fps    = (7+8+2*8)/4;
							capped = 1;
						}
					}
				}
			}
			else if (skill < Skill.SKILL_ASN_FISTS_OF_FIRE_NO) // strike charger
			{
				if (type != Weapon.type_claw)
				{
					fps = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256))-1;
				}
				else
				{
					fps = 16;
					for (int i=0; i < Weapon.SD_clawslash_right.length; i++)
					{
						if (effias >= Weapon.SD_clawslash_right[i]) fps--;
					}
					if (fps <= 7)
					{
						fps    = 7;
						capped = 1;
					}
				}
			}
			else if (skill < Skill.SKILL_ASN_DRAGON_TAIL_NO) // claw charger/finisher
			{
				if (l_weapon == null) // 1H
				{
					if (skill == Skill.SKILL_ASN_DRAGON_CLAW_NO)
					{
						fps = Double.NaN;
					}
					else
					{
						fps = 22;
						for (int i=0; i < Weapon.SD_clawcharge_1H.length; i++)
						{
							if (effias >= Weapon.SD_clawcharge_1H[i]) fps--;
						}
						if (fps <= 7)
						{
							fps    = 7;
							capped = 1;
						}
					}
				}
				else // 2H
				{
					fps = 28;
					for (int i=0; i < Weapon.SD_clawcharge_2H.length; i++)
					{
						if (effias >= Weapon.SD_clawcharge_2H[i]) fps--;
					}
					if (fps <= 10)
					{
						fps    = 10;
						capped = 1;
					}
					fps = fps/2;
				}
			}
			else if (skill == Skill.SKILL_ASN_DRAGON_TAIL_NO) // dragon tail
			{
				fps = 26;
				for (int i=0; i < Skill.SD_dragontail.length; i++)
				{
					if (effias >= Skill.SD_dragontail[i]) fps--;
				}
				if (fps <= 7)
				{
					fps    = 7;
					capped = 1;
				}
			}
			else // traps
			{
				fps = Math.ceil(256*(15+1)/Math.floor((100+effias)/100*256))-1;
				if (fps <= 9)
				{
					fps    = 9;
					capped = 1;
				}
			}
		}
		// Chainlightning
		else if ((uchar == Character.CHAR_SOR) && (skill == Skill.SKILL_SOR_CHAIN_LIGHTNING_NO))
		{
			if (type != Weapon.type_claw)
			{
				fps = 38;
				for (int i=0; i < Skill.SD_chainlightning.length; i++)
				{
					if (effias > Skill.SD_chainlightning[i]) fps--;
				}
				if (fps <= 11)
				{
					fps    = 11;
					capped = 1;
				}
			}
		}
		// Act 2 mercenary (Jab)
		else if (uchar == Character.CHAR_ACT2)
		{
			if (r_weapon.getMercenary() != 2)
				return Double.NaN;

			fps = 21;
			for (int i=0; i < Character.SD_act2_jab.length; i++)
			{
				if (effias >= Character.SD_act2_jab[i]) fps -= 1;
			}
			fps = fps/2.0;

			if (fps <= 5)
			{
				fps    = 5;
				capped = 1;
			}
		}
		// Act 1 mercenary
		else if (uchar == Character.CHAR_ACT1)
		{
			if (r_weapon.getMercenary() != 1)
				return Double.NaN;

			fps = 18;
			for (int i=0; i < Character.SD_act1_standard.length; i++)
			{
				if (effias >= Character.SD_act1_standard[i]) fps -= 1;
			}

			if (fps <= 9)
			{
				fps    = 9;
				capped = 1;
			}
		}
		// Act 5 mercenary
		else if (uchar == Character.CHAR_ACT5)
		{
			if (r_weapon.getMercenary() != 3)
				return Double.NaN;

			fps = 22;
			for (int i=0; i < Character.SD_act5_standard.length; i++)
			{
				if (effias >= Character.SD_act5_standard[i]) fps -= 1;
			}

			if (fps <= 10)
			{
				fps    = 10;
				capped = 1;
			}
		}
		else
		{
			effias = cap (effias, -100, 75);
			fps    = Math.ceil(256*(baseframe+1)/Math.floor((100+effias)/100*256))-1;
		}
		return fps;
	}

	private int ww_cap(double val) {
		if (val < 12)
			return 4;
		if (val < 15)
			return 6;
		if (val < 18)
			return 8;
		if (val < 20)
			return 10;
		if (val < 23)
			return 12;
		if (val < 26)
			return 14;
		else
			return 16;
	}

	private double cap(double effias, int min, int max) {
		if (effias >= max)
		{
			capped = 1;
			return max;
		}
		else if (effias < min)
			return min;
		return effias;
	}

	/**
	 * 返回 #{bare_field_comment}
	 * @return the weaponlist
	 */
	public List<Weapon> getWeaponlist() {
		return weaponlist;
	}

	/**
	 * 设置 #{bare_field_comment}
	 * @param weaponlist the weaponlist to set
	 */
	public void setWeaponlist(List<Weapon> weaponlist) {
		this.weaponlist = weaponlist;
	}

}
