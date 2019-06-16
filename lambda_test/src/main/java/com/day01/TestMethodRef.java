package com.day01;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @Classname TestMethodRef
 * @Description TODO
 * @Date 2019/6/16/016 16:28
 * @Created by cuiwjava
 */
/*
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 *
 * 1. 对象的引用 :: 实例方法名
 *
 * 2. 类名 :: 静态方法名
 *
 * 3. 类名 :: 实例方法名
 *
 * 注意：
 * 	 ①方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 ②若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 *
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 *
 * 1. 类名 :: new
 *
 * 三、数组引用
 *
 * 	类型[] :: new;
 *
 *
 */
public class TestMethodRef {

    @Test
    public void test(){
        PrintStream ps1 = System.out;
        Consumer<String> con = (x)->ps1.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("abcdef");

    }

    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        Integer num = sup2.get();
        System.out.println(num);


    }
    @Test
    public void test3(){

        Comparator<Integer> com = (x,y)-> Integer.compare(x,y);
        Comparator<Integer> com1 = Integer::compare;

    }

    @Test
    public void test4(){
        BiPredicate<String,String> bp = (x,y)->x.equals(y);
        BiPredicate<String,String> bp2 =  String::equals;

    }

    @Test
    public void test5(){
        Supplier<Employee> sup = () -> new Employee();

        Supplier<Employee> sup2 = Employee::new;
        Employee emp =  sup2.get();
    }

    @Test
    public void test6(){
        Supplier<Employee> sup = () -> new Employee();
        System.out.println(sup.get());

        System.out.println("------------------------------------");

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    //构造器引用
    @Test
    public void test7(){
        Function<String, Employee> fun = Employee::new;

        BiFunction<String, Integer, Employee> fun2 = Employee::new;
    }

    //数组引用
    @Test
    public void test8(){
        Function<Integer, String[]> fun = (args) -> new String[args];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        System.out.println("--------------------------");

        Function<Integer, Employee[]> fun2 = Employee[] :: new;
        Employee[] emps = fun2.apply(20);
        System.out.println(emps.length);
    }
}
