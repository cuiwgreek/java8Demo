package com.day03;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @Classname TestForkJoin
 * @Description TODO
 * @Date 2019/6/23/023 0:50
 * @Created by cuiwjava
 */
public class TestForkJoin {

    @Test
    public void test1(){
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoincalculate(0, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).getSeconds());

    }



}
