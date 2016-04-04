/**
 * Project Name:suzume-search
 * File Name:ResultSetWriter.java
 * Package Name:com.suzume.search.writer
 * Date:2016年4月3日下午4:58:24
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.suzume.search.util.CharacterUtil;

/**
 * ClassName:ResultSetWriter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午4:58:24 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class ResultSetWriter {
    
    private static final Logger log = LoggerFactory.getLogger(ResultSetWriter.class);
    
    private FileWriter          fw  = null;
    
    /**
     * build: <br/>
     * @author shengjie
     * @param resultFile
     * @return
     * @throws IOException
     * @since JDK 1.7
     */
    public static ResultSetWriter build(String resultFile) throws IOException {
        ResultSetWriter writer = new ResultSetWriter();
        writer.fw = new FileWriter(resultFile,
                                   false);
        return writer;
    }
    
    /**
     * build: <br/>
     * @author shengjie
     * @param resultFile
     * @param append
     * @return
     * @throws IOException
     * @since JDK 1.7
     */
    public static ResultSetWriter build(String resultFile,
                                        boolean append) throws IOException {
        ResultSetWriter writer = new ResultSetWriter();
        writer.fw = new FileWriter(resultFile,
                                   append);
        return writer;
    }
    
    /**
     * writeDown: <br/>
     * @author shengjie
     * @param resultset
     * @since JDK 1.7
     */
    public void writeDown(List<String> resultset) {
        if (resultset == null || fw == null) {
            return;
        }
        if (0 == resultset.size()) {
            return;
        }
        StringBuilder data = new StringBuilder();
        for (String result : resultset) {
            data.append(CharacterUtil.formatSysEncode(result + "\r\n"));
        }
        synchronized (this) {
            try {
                fw.write(data.toString());
                fw.flush();
                log.info("线程{}写入{}行结果集",
                         Thread.currentThread()
                               .getId(),
                         resultset.size());
            } catch (IOException e) {
                log.error("线程{}写入结果集异常",
                          Thread.currentThread()
                                .getId(),
                          e);
            }
        }
    }
    
    public void close() throws IOException {
        if (fw != null) {
            fw.close();
        }
    }
    
}
