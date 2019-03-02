package com.alany.blog;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 4种引用类型
 *
 * @author yinxing
 * @date 2019/2/25
 */

public class ReferenceType {

    public static void main(String[] args) {
        // 1.强引用
        // 被强引用关联的对象不会被回收。
        // 使用 new 一个新对象的方式来创建强引用。
        Object obj1 = new Object();

        // 2.软引用
        // 被软引用关联的对象只有在内存不够的情况下才会被回收。
        // 使用 SoftReference 类来创建软引用。
        Object obj2 = new Object();
        SoftReference<Object> sf = new SoftReference<Object>(obj2);
        // 使对象只被软引用关联
        obj2 = null;

        // 3.弱引用
        // 被弱引用关联的对象一定会被回收，也就是说它只能存活到下一次垃圾回收发生之前。
        // 使用 WeakReference 类来创建弱引用。
        Object obj3 = new Object();
        WeakReference<Object> wr = new WeakReference<Object>(obj3);
        obj3 = null;

        // 4.虚引用
        // 又称为幽灵引用或者幻影引用，一个对象是否有虚引用的存在，不会对其生存时间造成影响，也无法通过虚引用得到一个对象。
        // 为一个对象设置虚引用的唯一目的是能在这个对象被回收时收到一个系统通知。
        // 使用 PhantomReference 来创建虚引用。
        Object obj4 = new Object();
        ReferenceQueue<Object> rq = new ReferenceQueue<>();
        PhantomReference<Object> pr = new PhantomReference<>(obj4, rq);
        obj4 = null;

    }
}
