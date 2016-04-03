/**
 * @Title: TestPath.java
 * @Package com.suzume.search.path
 * @Description: 
 * Copyright: Copyright (c) 2016
 * Company: OneAPM
 * 
 * @author shengjie
 * @date 2016年4月2日 下午4:20:56
 */
package com.suzume.search.path;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

import org.junit.Test;

/**
 * @ClassName: TestPath
 * @Description:
 * @author shengjie
 * @date 2016年4月2日 下午4:20:56
 */
public class TestPath {
    
    /**
     * scanPathFiles: <br/>
     * @author shengjie
     * @since JDK 1.7
     */
    @Test
    public void scanPathFiles() {
        File f = new File(".");
        String[] subs = f.list();
        for (String sf : subs) {
            System.out.println(sf);
        }
    }
    
    /**
     * scanPathFilterFiles: <br/>
     * @author shengjie
     * @since JDK 1.7
     */
    @Test
    public void scanPathFilterFiles() {
        File f = new File(".");
        System.out.println(f.getAbsoluteFile()
                            .getName());
        System.out.println("$$$");
        System.out.println(f.getAbsoluteFile()
                            .getAbsolutePath());
        System.out.println("$$$");
        System.out.println(f.getAbsolutePath());
        System.out.println("$$$");
        String[] subs = f.getAbsoluteFile()
                         .list(new FilenameFilter() {
                             @Override
                             public boolean accept(File dir,
                                                   String name) {
                                 System.out.println(dir.getName());
                                 System.out.println(name);
                                 System.out.println("****************");
                                 return true;
                             }
                         });
        for (String sf : subs) {
            System.out.println(sf);
        }
    }
    
    /**
     * scanFilesInPath: <br/>
     * @author shengjie
     * @since JDK 1.7
     */
    @Test
    public void scanFilesInPath() {
        File f = new File(".");
        File[] subs = f.listFiles();
        for (File sf : subs) {
            System.out.println(sf.getName());
            System.out.println(sf.getAbsolutePath());
            System.out.println("###");
        }
    }
    
    /**
     * scanFilterFilesInPath: <br/>
     * @author shengjie
     * @since JDK 1.7
     */
    @Test
    public void scanFilterFilesInPath() {
        File f = new File(".");
        f.getAbsoluteFile()
         .list(new FilenameFilter() {
             @Override
             public boolean accept(File dir,
                                   String name) {
                 System.out.println(dir.getName());
                 System.out.println(name);
                 System.out.println("****************");
                 return true;
             }
         });
    }
    
    /**
     * scanFilterFiles: <br/>
     * @author shengjie
     * @since JDK 1.7
     */
    @Test
    public void scanFilterFiles() {
        File f = new File("./");
        f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                System.out.println(pathname.getAbsoluteFile()
                                           .getAbsolutePath());
                System.out.println("@@@");
                return true;
            }
        });
    }
    
    /**
     * paths: <br/>
     * @author shengjie
     * @since JDK 1.7
     */
    @Test
    public void paths() {
        File f1 = new File(".");
        System.out.println(f1.getAbsolutePath());
        //
        System.out.println(this.getClass()
                               .getResource("/")
                               .getFile());
        //
        System.out.println(this.getClass()
                               .getResource("/")
                               .getPath());
    }
}
