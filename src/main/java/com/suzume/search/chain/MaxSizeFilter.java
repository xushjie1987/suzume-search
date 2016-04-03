/**
 * Project Name:suzume-search
 * File Name:MaxSizeFilter.java
 * Package Name:com.suzume.search.chain
 * Date:2016年4月3日下午8:55:22
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.chain;

import java.io.File;

/**
 * ClassName:MaxSizeFilter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午8:55:22 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class MaxSizeFilter implements Filter {
    
    private Long   maxSize;
    
    private Filter next;
    
    public static Filter build(Long maxSize) {
        MaxSizeFilter filter = new MaxSizeFilter();
        filter.next = null;
        filter.maxSize = maxSize;
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
        if (!file.isDirectory()) {
            if (file.length() > maxSize) {
                return false;
            }
        }
        return next == null
                           ? true
                           : next.filter(file);
    }
    
    @Override
    public Filter link(Filter filter) {
        this.next = filter;
        return this;
    }
    
}
