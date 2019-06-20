package com.day02;

import com.day01.Employee;
import com.day01.Employee.Status;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname TestAPI02
 * @Description TODO
 * @Date 2019/6/19/019 7:17
 * @Created by cuiwjava
 */
public class TestAPI02 {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );
    @Test
    public void test0(){
        List<String> list = emps.stream().map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        Set<String> set = emps.stream().map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::print);

        HashSet<String> hs = emps.stream().map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);

    }
    //3. 终止操作
	/*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);

        System.out.println("----------------------------------------");

        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());
    }
    /**
        规约
     reduce(T identity, BinaryOperator)/ reduce(BinaryOperator)
     */
    @Test
    public void test3(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        //可能为0

    }

    @Test
    public void test4(){

    }

}
