/**
 * Project Name:suzume-search
 * File Name:CharacterUtil.java
 * Package Name:com.suzume.search.util
 * Date:2016年4月4日上午10:50:14
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * ClassName:CharacterUtil <br/>
 * Function: <br/>
 * Date: 2016年4月4日 上午10:50:14 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class CharacterUtil {
    
    /**
     * formatSysEncode: <br/>
     * @author shengjie
     * @param origin
     * @return
     * @since JDK 1.7
     */
    public static String formatSysEncode(String origin) {
        try {
            return new String(origin.getBytes(Charset.defaultCharset()
                                                     .name()));
        } catch (UnsupportedEncodingException ignore) {
        }
        return origin;
    }
    
}
