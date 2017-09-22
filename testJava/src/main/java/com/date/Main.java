package com.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 8, 14);
		calendar.add(Calendar.DATE, -13);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		System.out.println(dateFormat.format(calendar.getTime()));
	}

}
