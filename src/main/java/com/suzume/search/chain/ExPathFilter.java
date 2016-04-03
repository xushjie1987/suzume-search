/**
 * Project Name:suzume-search
 * File Name:PathFilter.java
 * Package Name:com.suzume.search.chain
 * Date:2016年4月3日下午11:42:44
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.chain;

import java.io.File;

/**
 * ClassName:ExPathFilter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午11:42:44 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class ExPathFilter implements Filter {
    
    private Filter next;
    
    public static Filter build() {
        ExPathFilter filter = new ExPathFilter();
        filter.next = null;
        return filter;
    }
    
    @Override
    public Filter link(Filter filter) {
        this.next = filter;
        return this;
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
            return next == null
                               ? true
                               : next.filter(file);
        }
        return false;
    }
    
}
