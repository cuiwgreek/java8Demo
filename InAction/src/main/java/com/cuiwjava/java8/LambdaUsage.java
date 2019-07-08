package com.cuiwjava.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
		filter(list, (apple -> apple.getColor().equals("green")));
	}

	private static void process(Runnable r){
		r.run();
	}
}
