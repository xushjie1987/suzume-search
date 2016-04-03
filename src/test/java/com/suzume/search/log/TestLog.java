/**
 * Project Name:suzume-search
 * File Name:TestLog.java
 * Package Name:com.suzume.search.log
 * Date:2016年4月3日上午11:14:23
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:TestLog <br/>
 * Function: <br/>
 * Date: 2016年4月3日 上午11:14:23 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class TestLog {
    
    private static final Logger log = LoggerFactory.getLogger(TestLog.class);
    
    @Test
    public void logMessage() {
        log.info("Hello INFO");
        log.error("Hello ERROR");
    }
    
}
