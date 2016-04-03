/**
 * Project Name:suzume-search
 * File Name:FormatedDate.java
 * Package Name:com.suzume.search.util
 * Date:2016年4月3日下午1:25:12
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:FormatedDate <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午1:25:12 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class FormatedDate {
    
    private static final Logger           log    = LoggerFactory.getLogger(FormatedDate.class);
    
    private static final SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_PATTERN);
    
    private Date                          date   = new Date();
    
    public FormatedDate() {
    }
    
    public FormatedDate(long date) {
        this.date = new Date(date);
    }
    
    public FormatedDate(String date) {
        try {
            this.date = format.parse(date);
        } catch (ParseException ignore) {
            log.error("解析日期字符串\"{}\"失败",
                      date,
                      ignore);
            this.date = new Date();
        }
    }
    
    /**
     * fromString: <br/>
     * @author shengjie
     * @param date
     * @return
     * @since JDK 1.7
     */
    public static FormatedDate fromString(String date) {
        return new FormatedDate(date);
    }
    
    /**
     * Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this
     * <tt>Date</tt> object.
     * @return the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this
     *         date.
     */
    public long getTime() {
        return date.getTime();
    }
    
}
