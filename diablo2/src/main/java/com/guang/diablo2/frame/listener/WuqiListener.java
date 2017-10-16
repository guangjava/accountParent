package com.guang.diablo2.frame.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.guang.diablo2.frame.Form;

public class WuqiListener implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			Form form = Form.getInstance();
			form.getSpeedCalculator().changeZhWeapon(form);
		}
	}

}
