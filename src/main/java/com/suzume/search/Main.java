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

/**
 * ClassName:Main <br/>
 * Function: <br/>
 * Date: 2016年4月3日 上午11:32:45 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class Main {
    
    /**
     * main: <br/>
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
