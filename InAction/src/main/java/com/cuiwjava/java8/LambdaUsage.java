package com.cuiwjava.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * @Classname LambdaUsage
 * @Description TODO
 * @Date 2019/7/8 19:11
 * @Created by cuiwei34
 */
public class LambdaUsage {

	private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate){
		List<Apple> result = new ArrayList<>();
		for (Apple a:source){
			if (predicate.test(a)){
				result.add(a);
			}
		}
		return result;
	}

	private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate){
		List<Apple> result = new ArrayList<>();
		for (Apple a : source) {
			if (predicate.test(a.getWeight())){
				result.add(a);
			}
		}
		return result;
	}

	private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate){
		List<Apple> result = new ArrayList<>();
		for (Apple a : source) {
			if (predicate.test(a.getColor(), a.getWeight())) {
				result.add(a);
			}
		}
		return result;
	}

	private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer){
		for (Apple a: source) {
			consumer.accept(a);
		}
	}

	private static void simpleTestBiConsumer(String c,List<Apple> source, BiConsumer<Apple,String> consumer){
		for (Apple a: source) {
			consumer.accept(a,c);
		}
	}

	private static String testFunction(Apple apple, Function<Apple,String> fun){
		return fun.apply(apple);
	}

	private static Apple testBiFunction(String color,long weight,BiFunction<String,Long,Apple> fun){
		return fun.apply(color, weight);
	}

	public static void main(String[] args) {
//		Runnable r1 = () -> System.out.print("hello");
//
//		Runnable r2 = new Runnable() {
//			@Override
//			public void run() {
//				System.out.print("Hello");
//			}
//		};
//
//		process(r1);
//		process(r2);
//		process(()->System.out.print("Hello"));
		List<Apple> list = Arrays.asList(new Apple("green", 120), new Apple("red", 150));
		List<Apple> qreenList = filter(list, (apple -> apple.getColor().equals("green")));
		System.out.print(qreenList);

		List<Apple> result = filterByWeight(list, w -> w > 100);
		System.out.print(result);

		List<Apple> result2 = filterByBiPredicate(list, (s, w) -> s.equals("apple") && w > 100);
		System.out.print(result);

		simpleTestConsumer(list,a->System.out.print(a));

		simpleTestBiConsumer("xxx",list,(a,s) -> System.out.print(s + a.getColor() + ":Weight=> " + a.getWeight() ));

		IntFunction<Double> f = i -> i * 100.0;
		Double result4 = f.apply(10);
		System.out.print(" ====================================== ");
		System.out.print(result4);

		Apple a = testBiFunction("Blue",130,(s,w)->new Apple(s,w));

		Supplier<String> s = String::new;
		System.out.print(s.get().getClass());

		Apple a2 = createApple(()->new Apple("Green",100));
		System.out.print(a2);

		int i = 0;
		Runnable r2 = ()->System.out.print(i);
	}

	private static void process(Runnable r){
		r.run();
	}

	private static Apple createApple(Supplier<Apple> supplier){
		return supplier.get();
	}

}
