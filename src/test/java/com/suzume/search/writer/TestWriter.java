/**
 * Project Name:suzume-search
 * File Name:TestWriter.java
 * Package Name:com.suzume.search.writer
 * Date:2016年4月3日下午5:25:19
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.writer;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * ClassName:TestWriter <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午5:25:19 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class TestWriter {
    
    @Test
    public void appendFile() throws IOException {
        FileWriter fw = new FileWriter("./tmp/result.txt",
                                       false);
        fw.write("line1\r\n");
        fw.flush();
        fw.write("line2\r\n");
        fw.flush();
        fw.close();
    }
    
}
