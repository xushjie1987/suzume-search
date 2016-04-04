/**
 * Project Name:suzume-search
 * File Name:TestString.java
 * Package Name:com.suzume.search.string
 * Date:2016年4月4日下午3:55:22
 * Copyright (c) 2016, All Rights Reserved.
 *
 */

package com.suzume.search.string;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Properties;

import org.junit.Test;

/**
 * ClassName:TestString <br/>
 * Function: <br/>
 * Date: 2016年4月4日 下午3:55:22 <br/>
 * 
 * @author xushjie
 * @version
 * @since JDK 1.7
 * @see
 */
public class TestString {
    
    /**
     * getCharacterBytes: <br/>
     * 
     * @author xushjie
     * @throws UnsupportedEncodingException
     * @since JDK 1.7
     */
    @Test
    public void getCharacterBytes() throws UnsupportedEncodingException {
        String s = "我";
        System.out.println(Charset.defaultCharset()
                                  .name());
        byte[] b = s.getBytes(Charset.defaultCharset()
                                     .name());
        System.out.println(b.length);
        for (byte c : b) {
            System.out.println(Byte.valueOf(c)
                                   .toString());
            System.out.println(String.valueOf(Byte.valueOf(c)
                                                  .intValue()));
            System.out.println(Integer.toHexString(c));
            System.out.println(Byte.toString(c));
            System.out.println(Long.toHexString(c));
            System.out.println("##");
        }
        System.out.println(s);
    }
    
    @Test
    public void getDefaultCharset() throws UnsupportedEncodingException {
        System.out.println(Charset.defaultCharset()
                                  .name());
    }
    
    @Test
    public void getCharset() {
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset()
                                  .name());
    }
    
    //@formatter:off
    /**
     * 
java.runtime.name:Java(TM) SE Runtime Environment
sun.boot.library.path:D:\java\jdk1.7.0_60\jre\bin
java.vm.version:24.60-b09
java.vm.vendor:Oracle Corporation
java.vendor.url:http://java.oracle.com/
path.separator:;
java.vm.name:Java HotSpot(TM) 64-Bit Server VM
file.encoding.pkg:sun.io
user.country:CN
user.script:
sun.java.launcher:SUN_STANDARD
sun.os.patch.level:
java.vm.specification.name:Java Virtual Machine Specification
user.dir:G:\workspace\sts-3.6.4\spring-projects\java\samples\search\suzume-search
java.runtime.version:1.7.0_60-b19
java.awt.graphicsenv:sun.awt.Win32GraphicsEnvironment
java.endorsed.dirs:D:\java\jdk1.7.0_60\jre\lib\endorsed
os.arch:amd64
java.io.tmpdir:C:\Users\xushjie\AppData\Local\Temp\31\
line.separator:

java.vm.specification.vendor:Oracle Corporation
user.variant:
os.name:Windows 8.1
sun.jnu.encoding:GBK
java.library.path:D:\java\jdk1.7.0_60\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;D:/java/jdk1.6.0_45/bin/../jre/bin/server;D:/java/jdk1.6.0_45/bin/../jre/bin;D:/java/jdk1.6.0_45/bin/../jre/lib/amd64;C:\ProgramData\Oracle\Java\javapath;C:\Perl\site\bin;C:\Perl\bin;C:\Program Files (x86)\Common Files\NetSarang;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\Common Files\Acronis\SnapAPI\;D:\java\jdk1.6.0_45\bin;D:\java\jdk1.6.0_45\jre\bin;D:\java\jdk1.6.0_45\db\bin;D:\dev\maven\bin;D:\dev\nodejs\;D:\dev\MySQL\MySQL Server 5.6\bin;D:\dev\protoc-2.5.0-win32;C:\Users\xushjie\AppData\Roaming\npm;D:\dev\cpp\mingw\bin;D:\dev\cpp\cygwin64\bin;D:\dev\VisualSVN Server\bin;C:\Program Files\TortoiseSVN\bin;D:\dev\elasticsearch-1.5.2\bin;D:\dev\kibana-4.0.2-windows\bin;D:\dev\logstash-1.5.0\bin;d:\Program Files\IDM Computer Solutions\UltraEdit;C:\Windows\Microsoft.NET\Framework64\v4.0.30319;C:\Program Files (x86)\Microsoft Visual Studio 9.0\VC\vcpackages;C:\Program Files (x86)\Microsoft Visual Studio 9.0\VC\bin;d:\dev\IDM Computer Solutions\UltraCompare;d:\dev\GitStack\python;d:\dev\GitStack\python\Scripts;d:\dev\GitStack\php;d:\dev\GitStack\git\cmd;d:\dev\GitStack\git\bin;D:\dev\TortoiseGit\bin;D:\dev\GitExtensions\;d:\dev\Microsoft VS Code\bin;C:\Users\xushjie\AppData\Local\atom\bin;D:\dev\sts-3.6.4\sts-bundle\sts-3.6.4.RELEASE;;.
java.specification.name:Java Platform API Specification
java.class.version:51.0
sun.management.compiler:HotSpot 64-Bit Tiered Compilers
os.version:6.3
user.home:C:\Users\xushjie
user.timezone:
java.awt.printerjob:sun.awt.windows.WPrinterJob
file.encoding:UTF-8
java.specification.version:1.7
java.class.path:G:\workspace\sts-3.6.4\spring-projects\java\samples\search\suzume-search\target\test-classes;G:\workspace\sts-3.6.4\spring-projects\java\samples\search\suzume-search\target\classes;E:\maven\repository\junit\junit\4.11\junit-4.11.jar;E:\maven\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;E:\maven\repository\ch\qos\logback\logback-core\1.1.7\logback-core-1.1.7.jar;E:\maven\repository\ch\qos\logback\logback-classic\1.1.7\logback-classic-1.1.7.jar;E:\maven\repository\org\slf4j\slf4j-api\1.7.20\slf4j-api-1.7.20.jar;E:\maven\repository\io\airlift\airline\0.7\airline-0.7.jar;E:\maven\repository\javax\inject\javax.inject\1\javax.inject-1.jar;E:\maven\repository\com\google\code\findbugs\annotations\2.0.3\annotations-2.0.3.jar;E:\maven\repository\com\google\guava\guava\18.0\guava-18.0.jar;E:\maven\repository\com\google\inject\guice\4.0\guice-4.0.jar;E:\maven\repository\aopalliance\aopalliance\1.0\aopalliance-1.0.jar;/D:/dev/sts-3.6.4/sts-bundle/sts-3.6.4.RELEASE/configuration/org.eclipse.osgi/413/0/.cp/;/D:/dev/sts-3.6.4/sts-bundle/sts-3.6.4.RELEASE/configuration/org.eclipse.osgi/412/0/.cp/
user.name:xushjie
java.vm.specification.version:1.7
sun.java.command:org.eclipse.jdt.internal.junit.runner.RemoteTestRunner -version 3 -port 26138 -testLoaderClass org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader -loaderpluginname org.eclipse.jdt.junit4.runtime -test com.suzume.search.string.TestString:getProperties
java.home:D:\java\jdk1.7.0_60\jre
sun.arch.data.model:64
user.language:zh
java.specification.vendor:Oracle Corporation
awt.toolkit:sun.awt.windows.WToolkit
java.vm.info:mixed mode
java.version:1.7.0_60
java.ext.dirs:D:\java\jdk1.7.0_60\jre\lib\ext;C:\Windows\Sun\Java\lib\ext
sun.boot.class.path:D:\java\jdk1.7.0_60\jre\lib\resources.jar;D:\java\jdk1.7.0_60\jre\lib\rt.jar;D:\java\jdk1.7.0_60\jre\lib\sunrsasign.jar;D:\java\jdk1.7.0_60\jre\lib\jsse.jar;D:\java\jdk1.7.0_60\jre\lib\jce.jar;D:\java\jdk1.7.0_60\jre\lib\charsets.jar;D:\java\jdk1.7.0_60\jre\lib\jfr.jar;D:\java\jdk1.7.0_60\jre\classes
java.vendor:Oracle Corporation
file.separator:\
java.vendor.url.bug:http://bugreport.sun.com/bugreport/
sun.io.unicode.encoding:UnicodeLittle
sun.cpu.endian:little
sun.desktop:windows
sun.cpu.isalist:amd64
     * getProperties: <br/>
     * @author xushjie
     * @throws UnsupportedEncodingException
     * @since JDK 1.7
     */
    //@formatter:on
    @Test
    public void getProperties() throws UnsupportedEncodingException {
        Properties p = System.getProperties();
        for (Object key : p.keySet()) {
            System.out.println(key +
                               ":" +
                               p.getProperty((String) key));
        }
    }
    
    @Test
    public void encodeDecode() throws UnsupportedEncodingException {
        String s = "我";
        String a = new String(s.getBytes(),
                              System.getProperty("sun.jnu.encoding"));
        System.out.println(a);
        byte[] b = a.getBytes();
        byte[] c = a.getBytes(System.getProperty("sun.jnu.encoding"));
        byte[] d = s.getBytes(System.getProperty("sun.jnu.encoding"));
        File f = new File("./我");
        byte[] e = f.getName()
                    .getBytes();
        byte[] g = f.getName()
                    .getBytes(System.getProperty("sun.jnu.encoding"));
        String h = new String(f.getName()
                               .getBytes(),
                              System.getProperty("sun.jnu.encoding"));
        String i = new String(f.getName()
                               .getBytes(System.getProperty("sun.jnu.encoding")),
                              System.getProperty("sun.jnu.encoding"));
        byte[] j = f.getName()
                    .getBytes();
        byte[] k = i.getBytes();
        System.out.println();
    }
    
}
