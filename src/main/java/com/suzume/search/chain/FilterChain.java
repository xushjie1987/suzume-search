/**
 * Project Name:suzume-search
 * File Name:FilterChain.java
 * Package Name:com.suzume.search.chain
 * Date:2016年4月3日下午4:56:52
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.chain;

import java.io.File;

/**
 * ClassName:FilterChain <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午4:56:52 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class FilterChain implements Filter {
    
    private Filter head;
    
    private Filter tail;
    
    /**
     * build: <br/>
     * @author shengjie
     * @return
     * @since JDK 1.7
     */
    public static Filter build() {
        FilterChain chain = new FilterChain();
        chain.head = null;
        chain.tail = null;
        return chain;
    }
    
    @Override
    public Filter link(Filter filter) {
        if (filter != null) {
            if (null == head) {
                head = filter;
                tail = head;
            }
            if (tail != null) {
                tail.link(filter);
                tail = filter;
            }
        }
        return this;
    }
    
    @Override
    public boolean filter(String file) {
        return head == null
                           ? true
                           : head.filter(file);
    }
    
    @Override
    public boolean filter(File file) {
        return head == null
                           ? true
                           : head.filter(file);
    }
    
}
