package com.cuiwjava.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/7/9 12:31
 * @Created by cuiwei34
 * https://blog.csdn.net/qq_28410283/article/details/80783946
 */
public class Main {
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("a", "a", "a", "a", "b");

		boolean aa = strs.stream().anyMatch(str -> str.equals("a"));
		boolean bb = strs.stream().allMatch(str -> str.equals("a"));
		boolean cc = strs.stream().noneMatch(str -> str.equals("a"));
		long count = strs.stream().filter(str -> str.equals("a")).count();

		System.out.println(aa);// TRUE
		System.out.println(bb);// FALSE
		System.out.println(cc);// FALSE
		System.out.println(count);// 4

	}
	/**
	 * 通过例子可以看到，变量aa的表达式，strs里的元素，任意有“a”，表示true
	 *
	 * 变量bb的表达式，strs里的元素，全部为“a”，表示true，否则false
	 *
	 * 变量cc的表达式，strs里的元素，全部不为“a”，表示true，否则false
	 */
}
