package com.consumers;

import java.util.function.Consumer;

/**
 * @Classname TestConsumer
 * @Description TODO
 * @Created by cuiwei34
 */
public class TestConsumer {
	public static void main(String[] args) {
		Consumer<Integer> consumer = x ->{
			int a = x+2;
			System.out.println(a);
		};
		consumer.accept(10);
	}
}

	/**传入一个Consumer类型的参数，
	 *他的泛型类型，
	 *跟本接口是一致的T，先做本接口的accept操作，
	 *然后在做传入的Consumer类型的参数的accept操作
	 */
//	default Consumer<T> andThen(Consumer<? super T> after) {
//		Objects.requireNonNull(after);
//		return (T t) -> { accept(t); after.accept(t); };
//	}



