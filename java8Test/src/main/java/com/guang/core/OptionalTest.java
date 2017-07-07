package com.guang.core;

import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.scene.chart.PieChart;

public class OptionalTest<T> {
	private Optional<T> convertedValue;
	public final Object encode(final Optional<T> value) {
		if (value.isPresent()) {
			value.get();
		}
		value.orElse(createNewKey());
		value.orElseGet(()->createNewKey());
		String string = "";
		Stream.of(string).distinct().map(String::toLowerCase).collect(Collectors.joining(","));
		return null;
	}
	private T createNewKey() {
		return null;
	}
	private void incrementPie(boolean criteria,PieChart.Data portion) {
		if (criteria) {
			portion.setPieValue(portion.getPieValue()+1);
		}
	}
}
