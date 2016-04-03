/**
 * Project Name:suzume-search
 * File Name:ContainsFilter.java
 * Package Name:com.suzume.search.chain
 * Date:2016年4月3日下午7:44:46
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.chain;

import java.io.File;

/**
 * ClassName:ContainsFilter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午7:44:46 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class ContainsFilter implements Filter {
    
    private String  subName;
    
    private Boolean isCaseSensitive;
    
    private Filter  next;
    
    public static Filter build(String subName,
                               Boolean isCaseSensitive) {
        ContainsFilter filter = new ContainsFilter();
        filter.next = null;
        filter.subName = subName;
        filter.isCaseSensitive = isCaseSensitive;
        return filter;
    }
    
    @Override
    public boolean filter(String file) {
        if (isCaseSensitive) {
            if (file.contains(subName)) {
                return next == null
                                   ? true
                                   : next.filter(file);
            }
        } else {
            if (file.toLowerCase()
                    .contains(subName.toLowerCase())) {
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
                    .contains(subName)) {
                return next == null
                                   ? true
                                   : next.filter(file);
            }
        } else {
            if (file.getName()
                    .toLowerCase()
                    .contains(subName.toLowerCase())) {
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
