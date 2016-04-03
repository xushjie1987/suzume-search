/**
 * Project Name:suzume-search
 * File Name:MinSizeFilter.java
 * Package Name:com.suzume.search.chain
 * Date:2016年4月3日下午8:55:05
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.chain;

import java.io.File;

/**
 * ClassName:MinSizeFilter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午8:55:05 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class MinSizeFilter implements Filter {
    
    private Long   minSize;
    
    private Filter next;
    
    public static Filter build(Long minSize) {
        MinSizeFilter filter = new MinSizeFilter();
        filter.next = null;
        filter.minSize = minSize;
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
            if (file.length() < minSize) {
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
