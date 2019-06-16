package com.consumers;

public interface Animal {
    void eat(String food);
}

class Test{
    /**
     * 函数式接口的实例可以通过
     * lambda表达式、
     * 方法引用、
     * 构造方法引用来创建。
     * @param args
     */
    public static void main(String[] args) {
        Animal fish = f -> System.out.println(f);
        fish.eat("fish eat");
        // lambda表达式

        Animal dog = System.out::println;
        dog.eat(" dog eat");
        // 方法引用

        Animal cat = new Animal() {
            @Override
            public void eat(String food) {
                System.out.println(food);
            }
        };
        // 匿名构造函数
        cat.eat(" cat eat");

    }
/**
 * https://www.cnblogs.com/LeeScofiled/p/7044250.html
  */
}


