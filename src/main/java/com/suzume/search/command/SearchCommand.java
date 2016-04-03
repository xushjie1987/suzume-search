/**
 * Project Name:suzume-search
 * File Name:SearchCommand.java
 * Package Name:com.suzume.search.command
 * Date:2016年4月3日上午11:58:47
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.command;

import io.airlift.airline.Command;
import io.airlift.airline.Option;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import com.suzume.search.engine.SearchEngine;
import com.suzume.search.util.FormatedDate;

/**
 * ClassName:SearchCommand <br/>
 * Function: <br/>
 * Date: 2016年4月3日 上午11:58:47 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
@Command(name = "scan",
         description = "扫描指定路径，搜索符合指定条件的文件/文件夹")
public class SearchCommand implements Runnable {
    
    @Option(name = { "-r", "--root" },
            required = true,
            description = "扫描根路径，绝对路径(e.g. \"/home\" or \"C:/\")")
    public String       pathRoot        = "./";
    
    @Option(name = { "-h", "--head" },
            required = false,
            description = "起始文件日期(e.g. 2000-01-01)，默认日期值January 1, 1970, 00:00:00 GMT")
    public FormatedDate headDate        = new FormatedDate(0);
    
    @Option(name = { "-t", "--tail" },
            required = false,
            description = "截止文件日期(e.g. 2000-12-31)，默认当前时间点")
    public FormatedDate tailDate        = new FormatedDate();
    
    @Option(name = { "-n", "--name" },
            required = false,
            description = "文件名字串，用于匹配，默认是空串，匹配任意文件名")
    public String       subName         = "";
    
    @Option(name = { "-g", "--regex" },
            required = false,
            description = "文件名正则表达式，默认匹配任意文件名")
    public String       regex           = ".*";
    
    @Option(name = { "-e", "--equal" },
            required = false,
            description = "文件名匹配原则，默认为字符串完全匹配")
    public Boolean      isEquals        = false;
    
    @Option(name = { "-c", "--contain" },
            required = false,
            description = "文件名匹配原则，默认为字符串包含匹配")
    public Boolean      isContains      = true;
    
    @Option(name = { "-s", "--sensitive" },
            required = false,
            description = "大小写敏感标识，默认不敏感")
    public Boolean      isCaseSensitive = false;
    
    @Option(name = { "-d", "--deepth" },
            required = false,
            description = "路径递归深度，默认完全递归")
    public Integer      deepth          = 0;
    
    @Option(name = { "-p", "--path" },
            required = false,
            description = "是否扫描路径名，默认扫描")
    public Boolean      isPath          = true;
    
    @Option(name = { "-f", "--file" },
            required = false,
            description = "是否扫描文件名，默认扫描")
    public Boolean      isFile          = true;
    
    @Option(name = { "-i", "--min" },
            required = false,
            description = "文件大小，默认为最小值")
    public Long         minSize         = Long.MIN_VALUE;
    
    @Option(name = { "-a", "--max" },
            required = false,
            description = "文件大小，默认为最大值")
    public Long         maxSize         = Long.MAX_VALUE;
    
    @Option(name = { "-o", "--output" },
            required = true,
            description = "结果.csv文件绝对路径")
    public String       resultFile      = "./tmp/result.csv";
    
    @Option(name = { "-l", "--parall" },
            required = false,
            description = "forkjoin池的并发度，默认50线程")
    public Integer      parallelism     = 50;
    
    @Option(name = { "-w", "--write" },
            required = false,
            description = "I/O写数据的并发度，默认10线程")
    public Integer      writeThreads    = 10;
    
    @Option(name = { "-b", "--block" },
            required = false,
            description = "I/O写数据的块数据行数，默认500行")
    public Integer      blockLines      = 500;
    
    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        SearchEngine engine = null;
        try {
            engine = SearchEngine.build(pathRoot,
                                        headDate,
                                        tailDate,
                                        subName,
                                        regex,
                                        isEquals,
                                        isContains,
                                        isCaseSensitive,
                                        deepth,
                                        isPath,
                                        isFile,
                                        minSize,
                                        maxSize,
                                        resultFile,
                                        parallelism,
                                        writeThreads,
                                        blockLines);
            engine.startup();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (engine != null) {
                try {
                    engine.shutdown();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
