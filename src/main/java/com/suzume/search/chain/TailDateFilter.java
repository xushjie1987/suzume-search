/**
 * Project Name:suzume-search
 * File Name:TailDateFilter.java
 * Package Name:com.suzume.search.chain
 * Date:2016年4月3日下午9:13:22
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.chain;

import java.io.File;

import com.suzume.search.util.FormatedDate;

/**
 * ClassName:TailDateFilter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午9:13:22 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class TailDateFilter implements Filter {
    
    private FormatedDate tailDate;
    
    private Filter       next;
    
    public static Filter build(FormatedDate tailDate) {
        TailDateFilter filter = new TailDateFilter();
        filter.next = null;
        filter.tailDate = tailDate;
        return filter;
    }
    
    @Override
    public boolean filter(String file) {
        return next == null
                           ? true
                           : next.filter(file);
    }
    
    @Override
    public boolean filter(File file) {
        if (file.lastModified() <= tailDate.getTime()) {
            return next == null
                               ? true
                               : next.filter(file);
        }
        return false;
    }
    
    @Override
    public Filter link(Filter filter) {
        this.next = filter;
        return this;
    }
    
}
