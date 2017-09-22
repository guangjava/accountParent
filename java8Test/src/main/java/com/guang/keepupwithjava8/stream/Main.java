package com.guang.keepupwithjava8.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		Property p1 = new Property("叫了个鸡", 1000, 500, 2);
		Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
		Property p3 = new Property("永和大王", 580, 3000, 1);
		Property p4 = new Property("肯德基", 6000, 200, 4);
		List<Property> list = Arrays.asList(p1,p2,p3,p4);
		List<Property> collectList = list.stream().sorted(Comparator.comparingInt(p->p.distance)).limit(2).collect(Collectors.toList());
		for (Property property : collectList) {
			System.out.println(property.name);
		}
		Collections.sort(list,(x,y)->x.distance.compareTo(y.distance));
		System.out.println("距离我最近的店铺是:" +list.get(0).getName());
		String name = list.stream().sorted(Comparator.comparingInt(x->x.sales)).findFirst().get().getName();
		System.out.println("销量最低："+name);
		long count = list.stream().filter(x->x.sales>1000).count();
		System.out.println("销量大于1000数量："+count);
		String context = Files.readAllLines(Paths.get(Main.class.getClassLoader().getResource("test-dianxiao2.json").toURI())).stream().collect(Collectors.joining("\n"));
		System.out.println(context);
		String firstName = list.stream().map(p->p.name).findFirst().get();
		System.out.println(firstName);
		String name2 = list.stream().max(Comparator.comparingInt(p->p.priceLevel)).get().getName();
		System.out.println("价格最高："+name2);
		List<List<String>> lists = new ArrayList<>();
		lists.add(Arrays.asList("apple", "click"));
		lists.add(Arrays.asList("boss", "dig", "qq", "vivo"));
        lists.add(Arrays.asList("c#", "biezhi"));
        long count2 = lists.stream().flatMap(Collection::stream).filter(str->str.length()>2).count();
        System.out.println(count2);
	}

}
