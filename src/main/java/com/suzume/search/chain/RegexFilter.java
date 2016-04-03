/**
 * Project Name:suzume-search
 * File Name:RegexFilter.java
 * Package Name:com.suzume.search.chain
 * Date:2016年4月3日下午7:44:58
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.chain;

import java.io.File;
import java.util.regex.Pattern;

/**
 * ClassName:RegexFilter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午7:44:58 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class RegexFilter implements Filter {
    
    private Pattern regex;
    
    private Filter  next;
    
    public static Filter build(String regex,
                               Boolean isCaseSensitive) {
        RegexFilter filter = new RegexFilter();
        filter.next = null;
        filter.regex = isCaseSensitive
                                      ? Pattern.compile(regex)
                                      : Pattern.compile(regex,
                                                        Pattern.CASE_INSENSITIVE);
        return filter;
    }
    
    @Override
    public boolean filter(String file) {
        if (regex.matcher(file)
                 .find()) {
            return next == null
                               ? true
                               : next.filter(file);
        }
        return false;
    }
    
    @Override
    public boolean filter(File file) {
        if (regex.matcher(file.getName())
                 .find()) {
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
