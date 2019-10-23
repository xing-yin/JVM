package com.alany.analysejvm.lecture6;

/**
 * 异常表条目展示（见字节码）
 *
 * @author yinxing
 * @date 2019/10/23
 */

public class ExceptionDemo1 {

    public static void main(String[] args) {
        try {
            throw new NullPointerException("test");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

// 编译: javac ExceptionDemo1.java
// 查看字节码: javap -c ExceptionDemo1.class
// 对应的字节码
//Compiled from "ExceptionDemo1.java"
//public class com.alany.analysejvm.lecture6.ExceptionDemo1 {
//public com.alany.analysejvm.lecture6.ExceptionDemo1();
//        Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//
//public static void main(java.lang.String[]);
//        Code:
//        0: new           #2                  // class java/lang/NullPointerException
//        3: dup
//        4: ldc           #3                  // String test
//        6: invokespecial #4                  // Method java/lang/NullPointerException."<init>":(Ljava/lang/String;)V
//        9: athrow
//        10: astore_1
//        11: aload_1
//        12: invokevirtual #5                  // Method java/lang/NullPointerException.printStackTrace:()V
//        15: return
//        Exception table:
//        from    to  target type
//        0    10    10   Class java/lang/NullPointerException // 异常表条目
//        }
