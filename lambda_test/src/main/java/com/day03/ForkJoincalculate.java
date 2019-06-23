package com.day03;

import java.util.concurrent.RecursiveTask;

/**
 * @Classname ForkJoincalculate
 * @Description TODO
 * @Date 2019/6/23/023 0:22
 * @Created by cuiwjava
 */
public class ForkJoincalculate extends RecursiveTask<Long> {

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    private long start;
    private long end;

    private static final long THRESHOLD = 10000;

    public ForkJoincalculate(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD){
            long sum = 0;
            for (long i = start; i <= end ; i++) {
                sum += i;
            }
            return sum;
        }else{
            long middle = (start + end) / 2;
            ForkJoincalculate left = new ForkJoincalculate(start, middle);
            left.fork();// 拆分子任务 同事压入线程队列

            ForkJoincalculate right = new ForkJoincalculate(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }


}
