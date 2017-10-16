package com.guang.diablo2.entity;

import java.util.Comparator;

public class WeaponEnComparator implements Comparator<Weapon>{

	@Override
	public int compare(Weapon a, Weapon b) {
		if (a==null || b==null || a.getName_en()==null || b.getName_en()==null) {
			throw new IllegalArgumentException("weapon is null");
		}
		if (a.getName_en().compareTo(b.getName_en()) > 0) return 1;
		if (a.getName_en().compareTo(b.getName_en()) < 0) return -1;
		return 0;
	}

}
