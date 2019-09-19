package com.cuiwjava.reflects;

import java.math.BigDecimal;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/9/13 16:44
 * @Created by cuiwei34
 */
public class Test {
	public static void main(String[] args) {
		BigDecimal changeLimit = new BigDecimal("1800");

		System.out.println(changeLimit.compareTo(new BigDecimal("0")) <= 0);


	}
}
