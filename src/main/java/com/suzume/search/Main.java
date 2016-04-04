/**
 * Project Name:suzume-search
 * File Name:Main.java
 * Package Name:com.suzume.search
 * Date:2016年4月3日上午11:32:45
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search;

import io.airlift.airline.Cli;
import io.airlift.airline.Cli.CliBuilder;
import io.airlift.airline.Help;

import com.suzume.search.command.SearchCommand;

//@formatter:off
/**
 * 
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 1, active = 1, running = 1, steals = 0, tasks = 0, submissions = 1]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 64, active = 60, running = 60, steals = 322, tasks = 1876, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 78, active = 72, running = 72, steals = 605, tasks = 1110, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 103, active = 92, running = 92, steals = 1056, tasks = 575, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 111, active = 92, running = 92, steals = 1378, tasks = 1266, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 121, active = 106, running = 106, steals = 1672, tasks = 1641, submissions = 0]
2016-04-04 02:41:02.020 [pool-1-thread-1] INFO  - com.suzume.search.writer.ResultSetWriter - 线程131写入500行结果集
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 139, active = 120, running = 120, steals = 2115, tasks = 1296, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 197, active = 179, running = 179, steals = 2708, tasks = 842, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 240, active = 224, running = 224, steals = 3419, tasks = 670, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 276, active = 228, running = 228, steals = 4158, tasks = 448, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 316, active = 246, running = 246, steals = 4335, tasks = 486, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 325, active = 260, running = 260, steals = 4463, tasks = 505, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 345, active = 274, running = 274, steals = 4612, tasks = 461, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 366, active = 290, running = 290, steals = 4714, tasks = 467, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 386, active = 312, running = 312, steals = 4844, tasks = 490, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 393, active = 318, running = 318, steals = 4929, tasks = 501, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 424, active = 332, running = 332, steals = 5239, tasks = 317, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 440, active = 345, running = 345, steals = 5435, tasks = 164, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 453, active = 354, running = 354, steals = 5572, tasks = 100, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 464, active = 375, running = 375, steals = 5815, tasks = 4, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 464, active = 251, running = 251, steals = 6025, tasks = 0, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 464, active = 233, running = 233, steals = 6180, tasks = 0, submissions = 0]
java.util.concurrent.ForkJoinPool@1e397ed7[Running, parallelism = 50, size = 464, active = 101, running = 101, steals = 6382, tasks = 0, submissions = 0]
2016-04-04 02:41:20.214 [main] INFO  - com.suzume.search.engine.SearchEngine - 扫描工作执行完成，耗时23511，扫描得到577条结果记录
2016-04-04 02:41:20.215 [pool-1-thread-2] INFO  - com.suzume.search.writer.ResultSetWriter - 线程475写入76行结果集
2016-04-04 02:41:20.264 [main] INFO  - com.suzume.search.pool.ResultSetPool - 开始停止线程池，超时时间10分钟
2016-04-04 02:41:20.264 [main] INFO  - com.suzume.search.pool.ResultSetPool - 线程池已经停止或者10分钟已超时
 * ClassName:Main <br/>
 * Function: <br/>
 * Date: 2016年4月3日 上午11:32:45 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
//@formatter:on
public class Main {
    
    /**
     * main: scan -r "e:/" -o "./tmp/result.csv" -n "suzume" -c -p -f <br/>
     * @author shengjie
     * @param args
     * @since JDK 1.7
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        CliBuilder<Runnable> builder = Cli.<Runnable> builder("search")
                                          .withDescription("文件搜索")
                                          .withDefaultCommand(Help.class)
                                          .withCommands(Help.class,
                                                        SearchCommand.class);
        
        Cli<Runnable> gitParser = builder.build();
        
        gitParser.parse(args)
                 .run();
    }
    
}
