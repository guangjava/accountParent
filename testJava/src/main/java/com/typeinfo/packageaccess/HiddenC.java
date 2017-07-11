package com.typeinfo.packageaccess;

import com.typeinfo.interfacea.A;

public class HiddenC {
	public static A makeA() {
		return new C();
	}
}
