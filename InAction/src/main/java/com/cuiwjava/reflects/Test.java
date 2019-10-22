package com.cuiwjava.reflects;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/9/13 16:44
 * @Created by cuiwei34
 */
public class Test {
	public static void main(String[] args) {
//		BigDecimal changeLimit = new BigDecimal("1800");
//
//		System.out.println(changeLimit.compareTo(new BigDecimal("0")) <= 0);
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("passwdType", null);
//		System.out.println("   map   ="+map);
		String sourceType = "BT-NOPWD";
		System.out.println(!"JDZF-SC".equals(sourceType) && !"BT-PC".equals(sourceType) && !"BT-NOPWD".equals(sourceType));

	}
}
