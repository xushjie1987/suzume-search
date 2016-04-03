/**
 * Project Name:suzume-search
 * File Name:TestRegex.java
 * Package Name:com.suzume.search.regex
 * Date:2016年4月2日下午6:50:47
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.regex;

import java.io.File;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * ClassName:TestRegex <br/>
 * Function: <br/>
 * Date: 2016年4月2日 下午6:50:47 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class TestRegex {
    
    /**
     * pattern_01: <br/>
     * @author shengjie
     * @since JDK 1.7
     */
    @Test
    public void pattern_01() {
        Pattern p = Pattern.compile("^a{3}bcd$");
        Matcher m = p.matcher("aaabcd");
        System.out.println(m.find());// true
        m.reset("aaabcde");
        System.out.println(m.find());// false
        m.reset("aaabcd$");
        System.out.println(m.find());// false
        m.reset("0aaabcd");
        System.out.println(m.find());// false
    }
    
    @Test
    public void pattern_02() {
        Pattern p = Pattern.compile("^a{3}bcd$");
        Matcher m = p.matcher("aaabcd");
        System.out.println(m.find(0));// true
    }
    
    @Test
    public void pattern_03() {
        Pattern p = Pattern.compile("^a{3}bcd$");
        Matcher m = p.matcher("aaabcd");
        System.out.println(m.find(1));// false
    }
    
    @Test
    public void pattern_04() {
        Pattern p = Pattern.compile("^a{3}bcd$");
        Matcher m = p.matcher("aaabcd");
        m.find();
        System.out.println(m.start());// 0
    }
    
    @Test
    public void pattern_05() {
        Pattern p = Pattern.compile("^a{3}bcd$");
        Matcher m = p.matcher("aaabcd");
        m.find();
        System.out.println(m.end());// 6
    }
    
    @Test
    public void pattern_06() {
        Pattern p = Pattern.compile("^a{3}bcd$");
        Matcher m = p.matcher("aaabcd");
        m.find();
        MatchResult mr = m.toMatchResult();
        System.out.println(mr.group());// aaabcd
    }
    
    @Test
    public void pattern_07() {
        Pattern p = Pattern.compile("^a{3}bcd$");
        Matcher m = p.matcher("aaabcd");
        m.find();
        MatchResult mr = m.toMatchResult();
        System.out.println(mr.group(1));// java.lang.IndexOutOfBoundsException: No group 1
    }
    
    @Test
    public void pattern_08() {
        Pattern p = Pattern.compile("^a{3}bcd$");
        Matcher m = p.matcher("aaabcd");
        m.find();
        MatchResult mr = m.toMatchResult();
        System.out.println(mr.group(2));// java.lang.IndexOutOfBoundsException: No group 2
    }
    
    @Test
    public void pattern_09() {
        Pattern p = Pattern.compile("(ab(c+([de]+)f{2})g+h+)");
        Matcher m = p.matcher("01abccddeeffgghh23");
        m.find();
        MatchResult mr = m.toMatchResult();
        System.out.println(mr.group());// abccddeeffgghh
        System.out.println(mr.group(1));// abccddeeffgghh
        System.out.println(mr.group(2));// ccddeeff
        System.out.println(mr.group(3));// ddee
    }
    
    @Test
    public void pattern_10() {
        Pattern p = Pattern.compile("(ab(c+([de]+)?f{2})g+h+)");
        Matcher m = p.matcher("01abccffgghh23");
        m.find();
        MatchResult mr = m.toMatchResult();
        System.out.println(mr.group());// abccffgghh
        System.out.println(mr.group(1));// abccffgghh
        System.out.println(mr.group(2));// ccff
        System.out.println(mr.group(3));// null
    }
    
    @Test
    public void pattern_11() {
        Pattern p = Pattern.compile("^a{3}bcd$");
        Matcher m = p.matcher("aaabcd");
        System.out.println(m.find());// true
        System.out.println(m.find());// false
    }
    
    @Test
    public void pattern_12() {
        System.out.println("abc".contains(""));// true
    }
    
    @Test
    public void pattern_13() {
        System.out.println("abc".matches(""));// false
    }
    
    @Test
    public void pattern_14() {
        File f = new File("e:/");
        String name = f.getName();// 空串
    }
    
    @Test
    public void pattern_15() {
        File f = new File("e:/druid");
        String name = f.getName();
        System.out.println(name);// druid
    }
    
}
