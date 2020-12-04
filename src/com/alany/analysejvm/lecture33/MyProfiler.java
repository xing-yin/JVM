package com.alany.analysejvm.lecture33;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alan Yin
 * @date 2019/12/27
 */

public class MyProfiler {

    public static ConcurrentHashMap<Class<?>, AtomicInteger> data = new ConcurrentHashMap<>();

    public static void fireAllocationEvent(Class<?> klass) {
        data.computeIfAbsent(klass, kls -> new AtomicInteger()).incrementAndGet();
    }

    public static void dump() {
        data.forEach((kls, counter) -> {
            System.err.printf("%s: %d\n", kls.getName(), counter.get());
        });
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(MyProfiler::dump));
    }

}
