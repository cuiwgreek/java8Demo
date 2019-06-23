package com.annotationx;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @Classname MyAnnotation
 * @Description TODO
 * @Date 2019/6/23/023 14:17
 * @Created by cuiwjava
 */

@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {

    String value() default "cuiwjava";

}
