/**
 * Project Name:suzume-search
 * File Name:ScannerTask.java
 * Package Name:com.suzume.search.task
 * Date:2016年4月3日下午10:03:24
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.task;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import com.suzume.search.chain.FilterChain;
import com.suzume.search.pool.ResultSetPool;
import com.suzume.search.util.TimeUtil;

/**
 * ClassName:ScannerTask <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午10:03:24 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class ScannerTask extends RecursiveTask<Long> {
    
    /**
     * serialVersionUID:
     * @since JDK 1.7
     */
    private static final long serialVersionUID = -1545531685528091126L;
    
    private File              directory;
    
    private Integer           deepth;
    
    private Integer           level;
    
    private FilterChain       filterChain;
    
    private ResultSetPool     resultSet;
    
    public ScannerTask(File directory,
                       Integer deepth,
                       Integer level,
                       FilterChain filterChain,
                       ResultSetPool resultSet) {
        this.directory = directory;
        this.deepth = deepth;
        this.level = level;
        this.filterChain = filterChain;
        this.resultSet = resultSet;
    }
    
    /**
     * @see java.util.concurrent.RecursiveTask#compute()
     */
    @Override
    protected Long compute() {
        Long total = 0L;
        if (level.intValue() > deepth.intValue() && deepth > 0) {
            return 0L;
        }
        if (filterChain.filter(directory)) {
            resultSet.submit(getFileRow());
            total++;
        }
        if (directory.isDirectory()) {
            File[] childs = directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir,
                                      String name) {
                    // name.equalsIgnoreCase("Application Data")
                    // name.equalsIgnoreCase("Config.Msi")
                    // name.equalsIgnoreCase("Documents and Settings")
                    // 排除掉典型的无意义系统路径
                    if (name.equals(".") ||
                        name.equals("..") ||
                        name.equalsIgnoreCase("$RECYCLE.BIN") ||
                        name.equalsIgnoreCase("System Volume Information") ||
                        name.equalsIgnoreCase("RECYCLER")) {
                        return false;
                    }
                    return true;
                }
            });
            // 如果路径可以访问且路径下有内容，防止频繁发生的<code>java.lang.NullPointerException</code>
            if (childs != null && childs.length > 0) {
                List<ScannerTask> tasks = new ArrayList<ScannerTask>();
                for (File f : childs) {
                    if (f.isDirectory()) {
                        ScannerTask task = new ScannerTask(f,
                                                           deepth,
                                                           level + 1,
                                                           filterChain,
                                                           resultSet);
                        task.fork();
                        tasks.add(task);
                    } else {
                        if (filterChain.filter(f)) {
                            resultSet.submit(getFileRow(f));
                            total++;
                        }
                    }
                }
                for (ScannerTask task : tasks) {
                    total += task.join();
                }
            }
        }
        return total;
    }
    
    private String getFileRow() {
        return getFileRow(directory);
    }
    
    private String getFileRow(File f) {
        return (f.isDirectory()
                               ? "DIRECTORY"
                               : "FILE") +
               "," +
               humanSize(f.length()) +
               "," +
               f.getName() +
               "," +
               f.getAbsolutePath() +
               "," +
               TimeUtil.humanDate(f.lastModified()) +
               "," +
               (f.isHidden()
                            ? "HIDDEN"
                            : "NORMAL");
    }
    
    /**
     * humanSize: <br/>
     * @author shengjie
     * @param size
     * @return
     * @since JDK 1.7
     */
    private String humanSize(long size) {
        if (size / 1024 / 1024 / 1024 > 0) {
            return String.valueOf(size / 1024 / 1024 / 1024) + "GB";
        }
        if (size / 1024 / 1024 > 0) {
            return String.valueOf(size / 1024 / 1024) + "MB";
        }
        if (size / 1024 > 0) {
            return String.valueOf(size / 1024) + "KB";
        }
        return String.valueOf(size) + "B";
    }
    
}
