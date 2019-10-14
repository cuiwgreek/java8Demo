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
//		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
//		LocalDateTime now = LocalDateTime.now();
//		String nowText = now.format(df);
//		System.out.println("nowText=" + nowText);
//		String str = "868382034023468-1c151fee8a48,868382034023468-1C151FEE8A48";
//		String[] devs = str.split(",");
//
//		for (int i = 0; i < devs.length ; i++) {
//			System.out.println(devs[i].contains("1"));
//		}
//
//		System.out.println("nowText=" + nowText);

		String result = "1571062785";
		Integer hour = 72;
		Long time = Long.parseLong(result);
		Long rightTime = System.currentTimeMillis() - hour * 60 * 60 * 1000;
		System.out.println(" time is "+time + " rightTime is "+rightTime + " ====  ");
		if (time * 1000 > rightTime) {

		}
	}
}
