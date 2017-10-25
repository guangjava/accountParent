package com.guang.diablo2.frame.base;

import java.awt.Component;
import java.awt.Container;

public class Util {
	public static void setEnable(Container container,boolean enable) {
		container.setEnabled(enable);
		Component[] components = container.getComponents();
		for (Component component : components) {
			if (!(component instanceof Container)) {
				component.setEnabled(enable);
			}else {
				setEnable((Container) component, enable);
			}
		}
	}
}
