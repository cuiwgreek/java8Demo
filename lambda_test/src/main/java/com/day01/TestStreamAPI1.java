package com.day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname TestStreamAPI1
 * @Description TODO
 * @Date 2019/6/17/017 1:38
 * @Created by cuiwjava
 */
/*
 * 一、Stream API 的操作步骤：
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作(终端操作)
 */
public class TestStreamAPI1 {

    @Test
    public void test1(){
        //1. Collection 提供了两个方法  stream() 与 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        //2. 通过 Arrays 中的 stream() 获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream2 = Arrays.stream(nums);

        //3. 通过 Stream 类中静态方法 of()
        Stream<Integer> stream3 = Stream.of(1,2,3,4,5,6);

        //4. 创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2).limit(10);
        stream4.forEach(System.out::println);

        //生成
        Stream<Double> stream5 = Stream.generate(Math::random).limit(2);
        stream5.forEach(System.out::println);


    }

    //2. 中间操作
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
/*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */
    @Test
    public void test2(){
        Stream<Employee> stream = emps.stream().filter(e -> {
            System.out.println("测试中间操作");
            return e.getAge() <= 35;
        });
    //只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
        stream.forEach(System.out::println);

    }


    //外部迭代
    @Test
    public void test3(){
        Iterator<Employee> it = emps.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void test4(){
        emps.stream()
                .filter((e) -> {
                    System.out.println("短路！"); // &&  ||
                    return e.getSalary() >= 5000;
                }).limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void test5(){
        emps.parallelStream()
                .filter((e) -> e.getSalary() >= 5000)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void test6(){
        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test7(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream().map(str -> str.toUpperCase())
                .forEach(System.out::println);

        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");

//        Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI1::filterCharacter);
//        stream.forEach(sm ->{
//            sm.forEach(System.out::println);
//        });

        System.out.println("----------------------------------------------");
        Stream<Character> sm = list.stream().flatMap(TestStreamAPI1::filterCharacter);
        sm.forEach(System.out::println);


    }

     public static Stream<Character> filterCharacter(String str){
         ArrayList<Character> list = new ArrayList<>();
         for (Character ch: str.toCharArray()) {
             list.add(ch);
         }
         return list.stream();
     }
     @Test
     public void test8(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        List list2 = new ArrayList<>();
        list2.add(11);
        list2.add(22);
//        list2.addAll(list);
//       [11, 22, aaa, bbb, ccc, ddd, eee]

        // 将整个集合添加入
         list2.add(list);
         // [11, 22, [aaa, bbb, ccc, ddd, eee]]
         System.out.println(list2);
     }
// 中间操作

    /**
     * 排序
     * sorted() -自然排序Comparable
     * sorted(Comparator com)-定制排序
     */
    @Test
    public void test9(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        emps.stream()
                .sorted((e1,e2) ->{
                   if (e1.getAge()==e2.getAge()){
                       return e1.getName().compareTo(e2.getName());
                   }else {
                       return -1;
                   }
                }).forEach(System.out::println);

    }

}
