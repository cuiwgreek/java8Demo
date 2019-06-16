package com.day01;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Classname Test3
 * @Description TODO
 * @Date 2019/3/30 15:41
 * @Created by cuiwei34
 */
public class Test3 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "hello");

		list.stream().map(i -> i.toUpperCase()).forEach(
				i -> System.out.println(i)
		);

		list.stream().map(String::toUpperCase).forEach(
				i -> System.out.println(i)
		);

		Function<String,String> fun = String::toUpperCase;
		System.out.println(fun.apply("hello"));

		System.out.println();

	}

	public static Integer calc1(Integer a, Function<Integer,Integer> fun){
		return fun.apply(a);
	}

	public static Integer calc2(int a, Function<Integer,Integer> fun1,Function<Integer,Integer> fun2){
		return  fun1.compose(fun2).apply(a);
	}

	public static Integer calc3(int a , Function<Integer, Integer> fun1,Function<Integer,Integer> fun2){
		return fun1.andThen(fun2).apply(a);
	}

	public static Integer calc4(int a ,int b ,BiFunction<Integer, Integer, Integer> biFun){
		return biFun.apply(a, b);
	}

	public static Integer calc5(int a ,int b ,BiFunction<Integer, Integer, Integer> biFun,Function<Integer, Integer> fun){
		return biFun.andThen(fun).apply(a, b);
	}


}
