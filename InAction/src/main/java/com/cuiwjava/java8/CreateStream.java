package com.cuiwjava.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Classname CreateStream
 * @Description TODO
 * @Date 2019/7/29 19:02
 * @Created by cuiwei34
 */
public class CreateStream {

	public static void main(String[] args) {
		createStreamPromCollection().forEach(System.out::println);

	}

	/**
	 * Generate the stream object from collection.
	 * @return
	 */
	private static Stream<String> createStreamPromCollection(){
		List<String> list = Arrays.asList("hello", "alex", "wangwang", "world", "cuiwjava");
		return list.stream();
	}

	private static Stream<String> createStreamFromCollection(){
		return Stream.of("hello", "alex", "cuiwjava", "world");
	}

	private static Stream<String> createStreamFromArrays(){
		String[] strings = {"hello", "alex", "wangwenjun", "world", "stream"};
		return Arrays.stream(strings);
	}

	private static Stream<String> createStreamFromFile(){
		Path path = Paths.get("");
		try(Stream<String> streamFromFile = Files.lines(path)){
			streamFromFile.forEach(System.out::println);
		} catch (IOException e){
			throw new RuntimeException(e);
		}
		return null;
	}

	private static Stream<Integer> createStreamFromIterator(){
		Stream<Integer> stream = Stream.iterate(0, n -> n + 2).limit(10);
		return stream;
	}

	private static Stream<Double> createStreamFromGenerate(){
		return Stream.generate(Math::random).limit(10);
	}

	private static Stream<Obj> createObjStreamFromGenerate(){
		return Stream.generate(new ObjSupplier()).limit(10);
	}

	static class ObjSupplier implements Supplier<Obj> {
		private  int index = 0;
		private Random random = new Random(System.currentTimeMillis());


		@Override
		public Obj get() {
			index = random.nextInt(100);
			return new Obj(index, "Name->" + index);
		}
	}

	static class Obj {
		private int id;
		private String name;

		public Obj(int id, String name){
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Obj{" +
					"id=" + id +
					", name='" + name + '\'' +
					'}';
		}
	}
}
