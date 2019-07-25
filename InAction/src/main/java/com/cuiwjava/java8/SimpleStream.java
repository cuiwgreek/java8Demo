package com.cuiwjava.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Classname SimpleStream
 * @Description TODO
 * @Date 2019/7/21 17:19
 * @Created by cuiwei34
 */
public class SimpleStream {
	public static void main(String[] args) {
		// have a dish list
		//have a dish list (menu)

		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));

//       	List<String> dishNamesByCollections = getDishNameByColletions(menu);
//        System.out.println(dishNamesByCollections);
//        List<String> dishNamesByStreams = getDishNameByStream(menu);
//        System.out.println(dishNamesByStreams);
			Stream<Dish> stream = menu.stream();
			stream.forEach(System.out::println);
			menu.forEach(System.out::println);

		List<String> result = menu.stream().filter(d -> {
			System.out.println(" filtering-> " + d.getName());
			return d.getCalories() > 300;
		}).map(d -> {
			System.out.println("map-> " + d.getName());
			return d.getName();
		}).limit(3).collect(toList());


	}

	private static List<String> getDishNameByColletions(List<Dish> menu){
		List<Dish> lowCalories = new ArrayList<>();

		for (Dish d:menu){
			if (d.getCalories() < 400) {
				lowCalories.add(d);
			}
		}
// testing cpu core thread run numbers
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// sort
		Collections.sort(lowCalories,(d1,d2)->Integer.compare(d1.getCalories(),d2.getCalories()));
		List<String> dishNameList = new ArrayList<>();
		for (Dish d:lowCalories){
			dishNameList.add(d.getName());
		}

		return dishNameList;
	}

	private static List<String> getDishNameByStream(List<Dish> menu){
		return menu.parallelStream().filter(d->{
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return d.getCalories() < 400;
		}).sorted(Comparator.comparing(Dish::getCalories)).
				map(Dish::getName).collect(toList());

//		return menu.parallelStream().filter(d -> {
//
//					return d.getCalories() < 400;
//				}
//		).sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
	}


}
