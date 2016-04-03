/**
 * Project Name:suzume-search
 * File Name:TestGuice.java
 * Package Name:com.suzume.search.guice
 * Date:2016年4月3日下午5:41:43
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.guice;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * ClassName:TestGuice <br/>
 * Function: <br/>
 * Date: 2016年4月3日 下午5:41:43 <br/>
 * @author shengjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class TestGuice {
    
    public static class A {
        @Inject
        private B b;
    }
    
    public static class B {
        private String value;
        
        public B(String value) {
            this.value = value;
            System.out.println("B");
        }
    }
    
    public static class M extends AbstractModule {
        @Override
        protected void configure() {
            bind(B.class).toInstance(new B("b"));
        }
    }
    
    @Test
    public void injectNew() {
        Injector injector = Guice.createInjector(new M());// B
        A a = new A();
        A aa = new A();
        A aaa = injector.getInstance(A.class);
        A aaaa = injector.getInstance(A.class);
        System.out.println();
    }
    
}
