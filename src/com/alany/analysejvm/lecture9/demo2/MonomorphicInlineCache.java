package com.alany.analysejvm.lecture9.demo2;

import java.lang.invoke.*;

/**
 * 为了支持调用任意类的 race 方法，下面实现了一个简单的单态内联缓存。
 * 如果调用者的类型命中缓存中的类型，便直接调用缓存中的方法句柄，否则便更新缓存。
 *
 * @author yinxing
 * @date 2019/12/9
 */

public class MonomorphicInlineCache {

    private final MethodHandles.Lookup lookup;

    private final String name;

    public MonomorphicInlineCache(MethodHandles.Lookup lookup, String name) {
        this.lookup = lookup;
        this.name = name;
    }

    private Class<?> cachedClass = null;

    private MethodHandle mh = null;

    public void invoke(Object receiver) throws Throwable {
        if (cachedClass != receiver.getClass()) {
            cachedClass = receiver.getClass();
            mh = lookup.findVirtual(cachedClass, name, MethodType.methodType(void.class));
        }
        mh.invoke(receiver);
    }

    /**
     * 尽管 invokedynamic 指令调用的是所谓的 race 方法，
     * 但是实际上这里返回了一个链接至名为“invoke”的方法的调用点。
     * 由于调用点仅要求方法句柄的类型能够匹配，因此这个链接是合法的。
     */
    public static CallSite bootstrap(MethodHandles.Lookup lookup, String name, MethodType callSiteType) throws NoSuchMethodException, IllegalAccessException {
        MonomorphicInlineCache cache = new MonomorphicInlineCache(lookup, name);
        MethodHandle mh = lookup.findVirtual(MonomorphicInlineCache.class,
                "invoke",
                MethodType.methodType(void.class, Object.class));
        return new ConstantCallSite(mh.bindTo(cache));
    }
}
