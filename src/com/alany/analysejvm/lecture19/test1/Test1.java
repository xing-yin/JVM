package com.alany.analysejvm.lecture19.test1;

/**
 * @author yinxing
 * @date 2019/12/17
 */

public class Test1 {

    public void foo() {
        Object o = new Object();
    }
}

/**
 * public void foo();
 * descriptor: ()V
 * flags: ACC_PUBLIC
 * Code:
 * stack=2, locals=2, args_size=1
 * 0: new           #2                  // class java/lang/Object
 * 3: dup
 * 4: invokespecial #1                  // Method java/lang/Object."<init>":()V
 * 7: astore_1
 * 8: return
 */