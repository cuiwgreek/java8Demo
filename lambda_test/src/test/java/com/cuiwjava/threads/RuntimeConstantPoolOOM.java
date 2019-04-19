package com.cuiwjava.threads;

/**
 * @Classname RuntimeConstantPoolOOM
 * @Description TODO
 * @Date 2019/4/19 9:21
 * @Created by cuiwei34
 */

/**
 *jdk1.6中，首次遇到的字符串实例赋值到永久代中，返回也是永久带中这个字符串实例的引用，而由StringBuilder.toString()创建的字符串实例在Java堆上
 * 必然不是同一个引用 会返回false
 * JDK1.7中，的intern()实现不会在赋值实例，只是在常量池中记录首次出现的实例引用，因此intern()返回的引用和由StringBuilder穿件的那个字符串实例是同一个。
 */

/*(
	方法区用于存放Class的相关区域 类名 访问修饰符 常量池 字段描述 方法描述
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		//jdk1.7 放入到常量池中标记 intern() 第二次出现不符合首次出现原则


	}
}
