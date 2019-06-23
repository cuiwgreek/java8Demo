package com.annotationx;

import java.lang.reflect.Method;

/**
 * @Classname TestAnnotation
 * @Description TODO
 * @Date 2019/6/23/023 14:18
 * @Created by cuiwjava
 */
public class TestAnnotation {
//check framework
    private/* @NonNull*/ Object obj = null;

    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");

        MyAnnotation[] ma = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation: ma
             ) {
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(@MyAnnotation("abc") String str){

    }
}
