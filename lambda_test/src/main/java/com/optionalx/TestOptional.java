package com.optionalx;

import com.day01.Employee;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @Classname TestOptional
 * @Description TODO
 * @Date 2019/7/6/006 16:33
 * @Created by cuiwjava
 */
/*
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {

    @Test
    public void test1(){
        Optional<Employee> op = Optional.of(new Employee());
        // of();  里面不能为空
        Employee emp = op.get();
        System.out.println(emp);

    }

    @Test
    public void test2(){
//        Optional<Employee> op = Optional.empty();
//        System.out.println(op.get());

        Optional<Employee> op = Optional.of(null);
        System.out.println(op.get());
    }

    @Test
    public void test3(){
        Optional<Employee> op = Optional.ofNullable(new Employee());
//       if (op.isPresent()){
//           System.out.println(op.get());
//       }
//        Employee emp = op.orElse(new Employee("zhangsan", 17, 888.88));
//        System.out.println(emp);

        Employee emp = op.orElseGet(() -> new Employee());
        System.out.println(emp);

    }

    @Test
    public void test4(){
        Optional<Employee> op = Optional.ofNullable(new Employee("zhangsan", 18, 555.55));
//        Optional<String> str = op.map(e -> e.getName());
        Optional<String> str2 = op.flatMap(e -> Optional.of(e.getName()));


    }

    @Test
    public void test5(){
        Man man = new Man();
        String n = getGodnessName(man);
        System.out.println(n);

    }

    public String getGodnessName(Man man){
        if (man != null){
            Godness g = man.getGod();
            if (g != null){
                return g.getName();
            }
        }
        return "cang";
    }


}
