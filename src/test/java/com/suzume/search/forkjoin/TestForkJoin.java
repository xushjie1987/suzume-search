/**
 * Project Name:suzume-search
 * File Name:TestForkJoin.java
 * Package Name:com.suzume.search.forkjoin
 * Date:2016年4月3日上午11:20:38
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.forkjoin;

import java.util.concurrent.ForkJoinPool;

import org.junit.Test;

/**
 * ClassName:TestForkJoin <br/>
 * Function: <br/>
 * Date: 2016年4月3日 上午11:20:38 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class TestForkJoin {
    
    @Test
    public void forkJoinPool() {
        ForkJoinPool pool = new ForkJoinPool(5);
        System.out.println(pool.getActiveThreadCount());// 0
        System.out.println(pool.getAsyncMode());// false
        System.out.println(pool.getParallelism());// 5
        System.out.println(pool.getPoolSize());// 0
        System.out.println(pool.getQueuedSubmissionCount());// 0
        System.out.println(pool.getQueuedTaskCount());// 0
        System.out.println(pool.getRunningThreadCount());// 0
        System.out.println(pool.isQuiescent());// true
        System.out.println(pool.isShutdown());// false
    }
    
}
