package com.alany.analysejvm.lecture32;

/**
 * 通过执行javac -h . org/example/Foo.java命令，我们将在当前文件夹（对应-h后面跟着的.）生成名为org_example_Foo.h的头文件。
 *
 * @author Alan Yin
 * @date 2019/12/27
 */

public class Foo {

    public static native void foo();

    public native void bar(int i, long j);

    public native void bar(String s, int[] array);
}
