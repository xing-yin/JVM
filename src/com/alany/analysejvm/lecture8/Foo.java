package com.alany.analysejvm.lecture8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 我们来测量一下方法句柄的性能。
 * 你可以尝试通过重构代码，将方法句柄变成常量，来提升方法句柄调用的性能。
 *
 * @author yinxing
 * @date 2019/12/2
 */

public class Foo {

    public void bar(Object o) {
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(void.class, Object.class);
        MethodHandle mh = lookup.findVirtual(Foo.class, "bar", mt);

        long current = System.currentTimeMillis();
        for (int i = 0; i < 2_000_000_000; i++) {
            if (i % 1_000_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            mh.invokeExact(new Foo(), new Object());
        }
    }
}
