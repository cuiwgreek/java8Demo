package com.cuiwjava.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/8/20 14:05
 * @Created by cuiwei34
 */
public class Test {
	public static void main(String[] args) {

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDateTime now = LocalDateTime.now();
		String nowText = now.format(df);
		System.out.println("nowText=" + nowText);

	}
}
