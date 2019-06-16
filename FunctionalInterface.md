/**
 * An informative annotation type used to indicate that an interface
 * type declaration is intended to be a <i>functional interface</i> as
 * defined by the Java Language Specification.
 *这是一个通知性的注解类型，用于去表示某一个接口声明，它指在规定一个函数式接口，
 *这个接口由JAVA语言规范去定义的。（也就是说如果一个接口被加上@FunctionalInterface，
 *则表示这个接口是一个函数式接口）
 * Conceptually, a functional interface has exactly one abstract
 * method.  Since {@linkplain java.lang.reflect.Method#isDefault()
 * default methods} have an implementation, they are not abstract.  If
 * an interface declares an abstract method overriding one of the
 * public methods of {@code java.lang.Object}, that also does
 * <em>not</em> count toward the interface's abstract method count
 * since any implementation of the interface will have an
 * implementation from {@code java.lang.Object} or elsewhere.
 *从概念上来说，一个函数式接口只有一个抽象方法，由于java.lang.reflect.Method的方法sDefault()有一个实现，它们不是抽象的。如果一个接口声明了一个接口的方法，重写了java.lang.Object类里面的一个public方法，那么它也没有计入接口的抽象方法加1，
 *因为接口的任意一个实现都会有一个来自于java.lang.Object类或其它地方的一个实现。
 * <p>Note that instances of functional interfaces can be created with
 * lambda expressions, method references, or constructor references.
 *注意，含数式接口的实例可以通过lambda表达式、方法引用、或者构造方法引用来创建。
 * <p>If a type is annotated with this annotation type, compilers are
 * required to generate an error message unless:
 *如果一个注解类型带上了这个@FunctionalInterface，编译器会生成一个错误消息，除非以下几种情况：
 * <ul>
 * <li> The type is an interface type and not an annotation type, enum, or class.
 * <li> The annotated type satisfies the requirements of a functional interface.
 * </ul>
 *这个类型是一个接口类型，并且不是注解、枚举或class类型
 *被注解的类型满足了函数式接口的要求
 * <p>However, the compiler will treat any interface meeting the
 * definition of a functional interface as a functional interface
 * regardless of whether or not a {@code FunctionalInterface}
 * annotation is present on the interface declaration.
 *然而，编译器将会对待满足函数式接口定义的任义的接口，都会把它当成是一个函数式接口而不管是否在它的声明上增加了@FunctionalInterface注解类型。
 * @jls 4.3.2. The Class Object
 * @jls 9.8 Functional Interfaces
 * @jls 9.4.3 Interface Method Body
 * @since 1.8
 
 @Documented
 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.TYPE)
 public @interface FunctionalInterface {}
 */
 
 什么是函数式接口：
 
 1、接口被加上了@FunctionalInterface，表示它是一个函数式接口。
 
 2、如果一个接口只有一个抽象方法，那么表示它是一个函数式接口。
 
 3、如果一个接口有一个抽象方法和一些重写了java.lang.Object类公共方法的方法，那么表示它是一个函数式接口。
 
 https://www.cnblogs.com/LeeScofiled/p/6921337.html