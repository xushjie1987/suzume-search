/**
 * Project Name:suzume-search
 * File Name:TestExecutor.java
 * Package Name:com.suzume.search.executor
 * Date:2016年4月2日下午8:58:23
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;

/**
 * ClassName:TestExecutor <br/>
 * Function: <br/>
 * Date: 2016年4月2日 下午8:58:23 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class TestExecutor {
    
    @Test
    public void executorInfo() {
        ExecutorService es = Executors.newFixedThreadPool(10);
        System.out.println(es.isShutdown());
        System.out.println(((ThreadPoolExecutor) es).getActiveCount());// 0
        System.out.println(((ThreadPoolExecutor) es).getCorePoolSize());// 10
        System.out.println(((ThreadPoolExecutor) es).getLargestPoolSize());// 0
        System.out.println(((ThreadPoolExecutor) es).getMaximumPoolSize());// 10
        System.out.println(((ThreadPoolExecutor) es).getPoolSize());// 0
        System.out.println(((ThreadPoolExecutor) es).getTaskCount());// 0
    }
    
}
