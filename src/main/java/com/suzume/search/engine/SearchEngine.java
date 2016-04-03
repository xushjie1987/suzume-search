/**
 * Project Name:suzume-search
 * File Name:SearchEngine.java
 * Package Name:com.suzume.search.engine
 * Date:2016年4月3日下午4:55:22
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.engine;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suzume.search.chain.ContainsFilter;
import com.suzume.search.chain.EqualsFilter;
import com.suzume.search.chain.ExFileFilter;
import com.suzume.search.chain.ExPathFilter;
import com.suzume.search.chain.FilterChain;
import com.suzume.search.chain.HeadDateFilter;
import com.suzume.search.chain.MaxSizeFilter;
import com.suzume.search.chain.MinSizeFilter;
import com.suzume.search.chain.RegexFilter;
import com.suzume.search.chain.TailDateFilter;
import com.suzume.search.pool.ResultSetPool;
import com.suzume.search.task.ScannerTask;
import com.suzume.search.util.FormatedDate;

/**
 * ClassName:SearchEngine <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午4:55:22 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class SearchEngine {
    
    private static final Logger log          = LoggerFactory.getLogger(SearchEngine.class);
    
    private String              pathRoot;
    
    private Integer             deepth;
    
    private ResultSetPool       resultSet    = null;
    
    private FilterChain         filterChain  = null;
    
    private ForkJoinPool        scanTaskPool = null;
    
    /**
     * build: <br/>
     * @author shengjie
     * @param pathRoot
     * @param headDate
     * @param tailDate
     * @param subName
     * @param regex
     * @param isEquals
     * @param isContains
     * @param isCaseSensitive
     * @param deepth
     * @param isPath
     * @param isFile
     * @param minSize
     * @param maxSize
     * @param resultFile
     * @param parallelism
     * @param writeThreads
     * @param blockLines
     * @return
     * @throws IOException
     * @since JDK 1.7
     */
    public static SearchEngine build(String pathRoot,
                                     FormatedDate headDate,
                                     FormatedDate tailDate,
                                     String subName,
                                     String regex,
                                     Boolean isEquals,
                                     Boolean isContains,
                                     Boolean isCaseSensitive,
                                     Integer deepth,
                                     Boolean isPath,
                                     Boolean isFile,
                                     Long minSize,
                                     Long maxSize,
                                     String resultFile,
                                     Integer parallelism,
                                     Integer writeThreads,
                                     Integer blockLines) throws IOException {
        SearchEngine engine = new SearchEngine();
        engine.pathRoot = pathRoot;
        engine.deepth = deepth;
        engine.scanTaskPool = new ForkJoinPool(parallelism);
        engine.resultSet = ResultSetPool.build(writeThreads,
                                               resultFile,
                                               blockLines);
        engine.filterChain = (FilterChain) FilterChain.build()
                                                      .link(HeadDateFilter.build(headDate))
                                                      .link(TailDateFilter.build(tailDate))
                                                      .link(MinSizeFilter.build(minSize))
                                                      .link(MaxSizeFilter.build(maxSize))
                                                      .link(RegexFilter.build(regex,
                                                                              isCaseSensitive))
                                                      .link(isFile
                                                                  ? null
                                                                  : ExFileFilter.build())
                                                      .link(isPath
                                                                  ? null
                                                                  : ExPathFilter.build())
                                                      .link(isEquals
                                                                    ? EqualsFilter.build(subName,
                                                                                         isCaseSensitive)
                                                                    : null)
                                                      .link(isContains
                                                                      ? ContainsFilter.build(subName,
                                                                                             isCaseSensitive)
                                                                      : null);
        return engine;
    }
    
    /**
     * startup: <br/>
     * @author shengjie
     * @throws InterruptedException
     * @throws ExecutionException
     * @since JDK 1.7
     */
    public void startup() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        ScannerTask task = new ScannerTask(new File(pathRoot),
                                           deepth,
                                           0,
                                           filterChain,
                                           resultSet);
        scanTaskPool.execute(task);
        while (!task.isDone()) {
            System.out.println(scanTaskPool);
            Thread.sleep(5000);
        }
        // task.join();
        resultSet.flush();
        long end = System.currentTimeMillis();
        log.info("扫描工作执行完成，耗时{}，扫描得到{}条结果记录",
                 end - start,
                 task.get());
    }
    
    /**
     * shutdown: <br/>
     * @author shengjie
     * @throws IOException
     * @throws InterruptedException
     * @since JDK 1.7
     */
    public void shutdown() throws IOException, InterruptedException {
        scanTaskPool.shutdown();
        resultSet.shutdown();
    }
    
}
