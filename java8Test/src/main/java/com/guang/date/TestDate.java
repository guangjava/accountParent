package com.guang.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TestDate {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		localDate = localDate.minus(1, ChronoUnit.MONTHS);
		System.out.println("localDate:"+localDate);
		DayOfWeek dayOfWeek = LocalDate.parse("2017-07-20").getDayOfWeek();
		System.out.println(dayOfWeek);
		int dayOfMonth = LocalDate.parse("2017-07-20").getDayOfMonth();
		System.out.println(dayOfMonth);
		localDate.isLeapYear();
		LocalDate.now().isBefore(localDate);
		LocalDate firstDayOfMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("firstDayOfMonth:"+firstDayOfMonth);
		LocalDate withDayOfMonth = firstDayOfMonth.withDayOfMonth(1);
		System.out.println("withDayOfMonth:"+withDayOfMonth);
		localDate = LocalDate.of(2001, 1, 11);
		MonthDay birthday = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
		MonthDay.from(LocalDate.now()).equals(birthday);
		LocalTime now = LocalTime.now();
		System.out.println("localnow:"+now);
		now = LocalTime.parse("11:22");
		System.out.println(now);
		LocalTime.of(11, 22);
		now.plus(1, ChronoUnit.HOURS);
		now = LocalTime.MAX;
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime.of(localDate, now);
		LocalDateTime.parse("2017-01-14T11:11:24");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(localDateTime.format(formatter));
		LocalDateTime.parse("2017-12-04 11:14:45", formatter);
		formatter.format(localDateTime);
	}

}
