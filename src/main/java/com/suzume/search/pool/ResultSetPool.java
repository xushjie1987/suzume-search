/**
 * Project Name:suzume-search
 * File Name:ResultSetPool.java
 * Package Name:com.suzume.search.pool
 * Date:2016年4月3日下午4:57:50
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.pool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suzume.search.writer.ResultSetWriter;

/**
 * ClassName:ResultSetPool <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午4:57:50 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class ResultSetPool {
    
    private static final Logger log        = LoggerFactory.getLogger(ResultSetPool.class);
    
    private ExecutorService     threadPool = null;
    
    private ResultSetWriter     fileWriter = null;
    
    private List<String>        pool       = null;
    
    private Integer             threshold  = Integer.MAX_VALUE;
    
    /**
     * build: <br/>
     * @author shengjie
     * @param writeThreads
     * @param resultFile
     * @param blockLines
     * @return
     * @throws IOException
     * @since JDK 1.7
     */
    public static ResultSetPool build(Integer writeThreads,
                                      String resultFile,
                                      Integer blockLines) throws IOException {
        ResultSetPool dataPool = new ResultSetPool();
        dataPool.threadPool = Executors.newFixedThreadPool(writeThreads);
        dataPool.fileWriter = ResultSetWriter.build(resultFile);
        dataPool.pool = new ArrayList<String>();
        dataPool.threshold = blockLines;
        return dataPool;
    }
    
    /**
     * submit: <br/>
     * @author shengjie
     * @param line
     * @since JDK 1.7
     */
    public synchronized void submit(String line) {
        if (pool == null) {
            return;
        }
        if (isFull()) {
            flush();
        }
        pool.add(line);
    }
    
    /**
     * isFull: <br/>
     * @author shengjie
     * @return
     * @since JDK 1.7
     */
    private boolean isFull() {
        return pool.size() >= threshold
                                       ? true
                                       : false;
    }
    
    /**
     * flush: <br/>
     * @author shengjie
     * @since JDK 1.7
     */
    public synchronized void flush() {
        if (null == pool) {
            return;
        }
        if (0 == pool.size()) {
            return;
        }
        if (threadPool != null) {
            threadPool.execute(new Worker(pool));
            pool = new ArrayList<String>();
        }
    }
    
    /**
     * ClassName: Worker <br/>
     * Function: <br/>
     * date: 2016年4月3日 下午7:35:10 <br/>
     * @author shengjie
     * @version ResultSetPool
     * @since JDK 1.7
     */
    private class Worker implements Runnable {
        private List<String> block = new ArrayList<String>();
        
        /**
         * Creates a new instance of Worker.
         * @param block
         */
        public Worker(List<String> block) {
            if (block != null) {
                this.block = block;
            }
        }
        
        /**
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            fileWriter.writeDown(block);
        }
    }
    
    /**
     * shutdown: <br/>
     * @author shengjie
     * @throws IOException
     * @throws InterruptedException
     * @since JDK 1.7
     */
    public void shutdown() throws IOException, InterruptedException {
        log.info("开始停止线程池，超时时间10分钟");
        threadPool.shutdown();
        threadPool.awaitTermination(10,
                                    TimeUnit.MINUTES);
        log.info("线程池已经停止或者10分钟已超时");
        fileWriter.close();
    }
    
}
