package lecture6;

/**
 * finally 代码块的编译比较复杂。
 * 当前版本 Java 编译器的做法，是复制 finally 代码块的内容，分别放在 try-catch 代码块所有正常执行路径以及异常执行路径的出口中。
 *
 * @author yinxing
 * @date 2019/10/23
 */

public class Foo {

    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExist;

    public void test() {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
        }
        methodExist = 3;
    }

}


// javap -c Foo.class
// 字节码
//Compiled from "Foo.java"
//public class com.alany.analysejvm.lecture6.Foo {
//public com.alany.analysejvm.lecture6.Foo();
//        Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//
//public void test();
//        Code:
//        0: aload_0
//        1: iconst_0
//        2: putfield      #2                  // Field tryBlock:I
//        5: aload_0
//        6: iconst_2
//        7: putfield      #3                  // Field finallyBlock:I
//        10: goto          35
//        13: astore_1
//        14: aload_0
//        15: iconst_1
//        16: putfield      #5                  // Field catchBlock:I
//        19: aload_0
//        20: iconst_2
//        21: putfield      #3                  // Field finallyBlock:I
//        24: goto          35
//        27: astore_2
//        28: aload_0
//        29: iconst_2
//        30: putfield      #3                  // Field finallyBlock:I
//        33: aload_2
//        34: athrow
//        35: aload_0
//        36: iconst_3
//        37: putfield      #6                  // Field methodExist:I
//        40: return
//        Exception table:
//        from    to  target type
//        0     5    13   Class java/lang/Exception
//        0     5    27   any
//        13    19    27   any
//        }
/**
 * 可以看到，编译结果包含三份 finally 代码块。
 * 其中，前两份分别位于 try 代码块和 catch 代码块的正常执行路径出口。
 * 最后一份则作为异常处理器，监控 try 代码块以及 catch 代码块。它将捕获 try 代码块触发的、未被 catch 代码块捕获的异常，以及 catch 代码块触发的异常。
 */
