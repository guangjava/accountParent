package com.guang.diablo2.entity.speed;

import java.util.Comparator;

import net.sourceforge.pinyin4j.PinyinHelper;

public class WeaponZhComparator implements Comparator<Weapon> {
	StringBuilder sb = new StringBuilder();
	@Override
	public int compare(Weapon a, Weapon b) {
		String a_name_zh = a.getName_zh();
		String b_name_zh = b.getName_zh();
		if (a==null || b==null || a_name_zh==null || b_name_zh==null) {
			throw new IllegalArgumentException("weapon is null");
		}
		if (a_name_zh.equals(b_name_zh)) return 0;
		char[] a_char_zh = a.getName_zh().toCharArray();
		char[] b_char_zh = b.getName_zh().toCharArray();
		
		int minLen = Math.min(a_char_zh.length, b_char_zh.length);
		for (int i = 0; i < minLen; i++) {
			String[] a_pinyin = PinyinHelper.toHanyuPinyinStringArray(a_char_zh[i]);
			String[] b_pinyin = PinyinHelper.toHanyuPinyinStringArray(b_char_zh[i]);
			if (a_pinyin == null) return -1;
			if (b_pinyin == null) return 1;
			for (int j = 0; j < a_pinyin.length; j++) {
				sb.append(a_pinyin[j]);
			}
			String a_pinyin_str = sb.toString();
			sb.delete(0, sb.length());
			for (int j = 0; j < b_pinyin.length; j++) {
				sb.append(b_pinyin[j]);
			}
			String b_pinyin_str = sb.toString();
			sb.delete(0, sb.length());
			int compare = a_pinyin_str.compareTo(b_pinyin_str);
			if (compare > 0) {
				return 1;
			}else if (compare < 0) {
				return -1;
			}
		}
		if (a_char_zh.length < b_char_zh.length) {
			return 1;
		}else if (a_char_zh.length > b_char_zh.length) {
			return -1;
		}
		if (a_name_zh.compareTo(b_name_zh) > 0) return 1;
		if (a_name_zh.compareTo(b_name_zh) < 0) return -1;
		return 0;
	}
}
