package com.day03;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

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

    @Test
    public void test2(){
        Instant start = Instant.now();

        long sum = 0L;
        for (int i = 0; i <= 100000000L  ; i++) {
            sum +=i;
        }

        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());

    }

    @Test
    public void test3(){
        Instant start = Instant.now();

        LongStream.rangeClosed(0,100000000000L)
                    .parallel()
                    .reduce(0,Long::sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }

}
