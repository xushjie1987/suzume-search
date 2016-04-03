/**
 * Project Name:suzume-search
 * File Name:Filter.java
 * Package Name:com.suzume.search.chain
 * Date:2016年4月3日下午4:55:58
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.chain;

import java.io.File;

/**
 * ClassName:Filter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午4:55:58 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public interface Filter {
    
    public Filter link(Filter filter);
    
    public boolean filter(String file);
    
    public boolean filter(File file);
    
}
