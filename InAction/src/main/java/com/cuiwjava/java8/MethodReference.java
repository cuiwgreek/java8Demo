package com.cuiwjava.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Classname MethodReference
 * @Description TODO
 * @Date 2019/7/18 21:55
 * @Created by cuiwei34
 */
public class MethodReference {
	public static void main(String[] args) {
		Consumer<String> consumer = (s) -> System.out.print(s);
		useConsumer(consumer,"Hello Alex");
		useConsumer(System.out::println,"Hello cuiwjava");

		List<Apple> list = Arrays.asList(new Apple("Green",110),new Apple("red",200));
		System.out.println(list);

		list.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
		System.out.println(list);

		list.stream().forEach( a -> System.out.print(a));
		list.stream().forEach(System.out::println);

		int value = Integer.parseInt("123");

		Function<String, Integer> f = Integer::parseInt;
		Integer result = f.apply("123");
		System.out.print(result);

		BiFunction<String, Integer, Character> f2 = String::charAt;
		Character c = f2.apply("hello", 10);
		System.out.print(c);

		String string = new String("hello");
		Function<Integer,Character> f3 = string::charAt;
		Character c2 = f3.apply(4);
		System.out.print(c2);


	}

	private static <T> void useConsumer(Consumer<T> consumer, T t){
		consumer.accept(t);
		consumer.accept(t);
	}
}
