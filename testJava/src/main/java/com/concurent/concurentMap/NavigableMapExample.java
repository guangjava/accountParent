package com.concurent.concurentMap;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class NavigableMapExample {
	public static void main(String[] args) {
		ConcurrentNavigableMap<String, String> map = new ConcurrentSkipListMap<>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		ConcurrentNavigableMap<String, String> headMap = map.headMap("2");
		ConcurrentNavigableMap<String, String> tailMap = map.tailMap("2");
		ConcurrentNavigableMap<String, String> subMap = map.subMap("1", "3");
	}
}
