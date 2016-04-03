/**
 * Project Name:suzume-search
 * File Name:EqualsFilter.java
 * Package Name:com.suzume.search.chain
 * Date:2016年4月3日下午7:43:57
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.chain;

import java.io.File;

/**
 * ClassName:EqualsFilter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午7:43:57 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class EqualsFilter implements Filter {
    
    private String  subName;
    
    private Boolean isCaseSensitive;
    
    private Filter  next;
    
    /**
     * build: <br/>
     * @author shengjie
     * @param subName
     * @return
     * @since JDK 1.7
     */
    public static Filter build(String subName,
                               Boolean isCaseSensitive) {
        EqualsFilter filter = new EqualsFilter();
        filter.next = null;
        filter.subName = subName;
        filter.isCaseSensitive = isCaseSensitive;
        return filter;
    }
    
    @Override
    public boolean filter(String file) {
        if (isCaseSensitive) {
            if (file.equals(subName)) {
                return next == null
                                   ? true
                                   : next.filter(file);
            }
        } else {
            if (file.equalsIgnoreCase(subName)) {
                return next == null
                                   ? true
                                   : next.filter(file);
            }
        }
        return false;
    }
    
    @Override
    public boolean filter(File file) {
        if (isCaseSensitive) {
            if (file.getName()
                    .equals(subName)) {
                return next == null
                                   ? true
                                   : next.filter(file);
            }
        } else {
            if (file.getName()
                    .equalsIgnoreCase(subName)) {
                return next == null
                                   ? true
                                   : next.filter(file);
            }
        }
        return false;
    }
    
    @Override
    public Filter link(Filter filter) {
        this.next = filter;
        return this;
    }
    
}
