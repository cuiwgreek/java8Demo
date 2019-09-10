package com.cuiwjava.reflects;

import java.math.BigDecimal;

/**
 * @Classname StringUtils
 * @Description TODO
 * @Date 2019/9/10 15:37
 * @Created by cuiwei34
 */
public class StringUtils {
	/**
	 * 檢查字串是否為null或空白
	 * @param value 傳入字串
	 * @return 為空白或null則回傳true，否則則回傳false
	 */
	public static boolean isEmpty(String value) {
		if (value == null || value.trim().equals(""))
			return true;
		else {
			return false;
		}
	}

	/**
	 * 字串如果為空白或null則使用def取代
	 * @param value 檢查之字串
	 * @param def 如為空白或null 要取代的值
	 * @return 回傳value或是def值
	 */
	public static String nvl(String value, String def) {
		if (isEmpty(value)) {
			return def;
		} else {
			return value.trim();
		}
	}

	/**
	 * 字串為數字格式則轉換成數字回傳，否則則用預設值取代
	 * @param str 要檢查的字串
	 * @param def 不為數字時要回傳的預設值
	 * @return 字串轉換成數字值
	 */
	public static int intNvl(String str, int def) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return def;
		}

	}

	/**
	 * 字串為數字格式則轉換成數字BigDecimal回傳，否則則用預設值取代
	 * @param str 要檢查的字串
	 * @param def 不為數字時要回傳的預設值BigDecimal
	 * @return 字串轉換成數字值BigDecimal
	 */
	public static BigDecimal BigDecimalNvl(String str, BigDecimal def) {
		try {
			return new BigDecimal(str);
		} catch (Exception e) {
			return def;
		}

	}
}
