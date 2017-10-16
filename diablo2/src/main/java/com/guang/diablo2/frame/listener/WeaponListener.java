package com.guang.diablo2.frame.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.guang.diablo2.frame.Form;

public class WeaponListener implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Form form = Form.getInstance();
			form.getSpeedCalculator().changeEnWeapon(form);
		}
	}
}
