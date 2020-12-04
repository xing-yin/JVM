package com.alany.topic.memory_leak;

import java.util.HashMap;
import java.util.Map;

/**
 * 参考链接: https://blog.csdn.net/lmb55/article/details/79267277
 * <p>
 * 模拟内存泄漏
 * <p>
 * 测试实验1（VisualVM）：配置的JVM参数如下：-Xms512m -Xmx512m -XX:-UseGCOverheadLimit
 * <p>
 * 测试实验2 (GCView 和 GCEasy)：-XX:+UseG1GC -XX:MaxGCPauseMillis=100 -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -Xloggc:/Users/yinxing/Desktop/gc.log
 *
 * @author Alan Yin
 * @date 2020/12/2
 */

public class MemoryLeakTest {

    /**
     * 声明缓存对象
     */
    private static final Map CACHE_MAP = new HashMap();

    public static void main(String args[]) {
        try {
            Thread.sleep(10000);//给打开visualvm时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //循环添加对象到缓存
        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            CACHE_MAP.put("key" + i, t);
        }
        System.out.println("first");
        System.out.println("----------------------------");

        //为dump出堆提供时间
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            CACHE_MAP.put("key" + i, t);
        }
        System.out.println("second");
        System.out.println("----------------------------");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3000000; i++) {
            TestMemory t = new TestMemory();
            CACHE_MAP.put("key" + i, t);
        }
        System.out.println("third");
        System.out.println("----------------------------");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 4000000; i++) {
            TestMemory t = new TestMemory();
            CACHE_MAP.put("key" + i, t);
        }
        System.out.println("forth");
        System.out.println("----------------------------");


        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
        System.out.println("----------------------------");
    }
}
