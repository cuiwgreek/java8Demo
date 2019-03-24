package com.day01;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Classname TestLambda
 * @Description TODO
 * @Date 2019/3/24 14:43
 * @Created by cuiwei34
 */
public class TestLambda {
	@Test
	public void test1() {
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		TreeSet<Integer> ts = new TreeSet<>(com);

	}

	@Test
	public void test2() {
		Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
		TreeSet<Integer> ts = new TreeSet<>(com);
	}

	List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99),
			new Employee("李四", 22, 9999.99),
			new Employee("王五", 27, 2343.33),
			new Employee("赵六", 23, 7777.77),
			new Employee("田七", 23, 6666.66)

	);


	// 需求： 获取当前公司中员工年龄大于35的员工信息
	List<Employee> filterEmployee(List<Employee> list){
		List<Employee> emps = new ArrayList();
		for (Employee emp : emps){
			if (emp.getAge() >= 35) {
				emps.add(emp);
			}
		}
		return emps;
	}

	public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
		ArrayList<Employee> emps = new ArrayList<>();
		for (Employee employee : list){
			if (mp.test(employee)){
				emps.add(employee);
			}
		}
		return emps;
	}
	@Test
	public void test3() {
		List<Employee> list = filterEmployee(employees);
		System.out.println(employees);
	}
	//优化方式1 策略涉及模式
	@Test
	public void test4() {
		List<Employee> list = filterEmployee(employees, new FilterEmployeeByAge());

		for (Employee employee:list){
			System.out.println(employee);
		}

		System.out.println(" --------------------------------- ");

		List<Employee> list2 = filterEmployee(employees, new FilterEmployeeBySalary());
		for (Employee employee : list2){
			System.out.println(employee);
		}

	}
	// 需求： 获取当前公司中员工工资大于3500
	public List<Employee> filterEmployee2(List<Employee> list){

		return null;
	}

	//优化方式2 匿名内部类
	@Test
	public void test5(){
		List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getSalary() <= 5000;
			}
		});

		for (Employee employee : list){
			System.out.println(employee);
		}

	}
	// 优化方式三: Lambda 表达式
	@Test
	public void test6(){
		List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() >= 5000);
		list.forEach(System.out::println);
	}

	// 优化方式四 stream API
	@Test
	public void test7(){
		employees.stream()
				.filter((e) -> e.getSalary() >= 5000)
				.limit(2)
				.forEach(System.out::println);

		System.out.println("----------------------------------------");

		employees.stream()
				 .map(Employee:: getName)
				 .forEach(System.out::println);

	}


}
