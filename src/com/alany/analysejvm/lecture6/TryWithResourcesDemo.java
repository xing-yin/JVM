package com.alany.analysejvm.lecture6;

/**
 * try-with-resources 语法糖
 * 简洁，会使用 Supressed 异常的功能，来避免原异常“被消失”
 * 在声明多个 AutoCloseable 实例的情况下，编译生成的字节码类似于 Try-Catch-Finally 手工编写代码的编译结果。
 *
 * @author yinxing
 * @date 2019/10/23
 */

public class TryWithResourcesDemo implements AutoCloseable {

    private String name;

    public TryWithResourcesDemo(String name) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        throw new RuntimeException(name);
    }

    public static void main(String[] args) throws Exception {
        // try-with-resources 语法糖
        try (TryWithResourcesDemo demo0 = new TryWithResourcesDemo("demo0");
             TryWithResourcesDemo demo1 = new TryWithResourcesDemo("demo1");
             TryWithResourcesDemo demo2 = new TryWithResourcesDemo("demo2")) {
            throw new RuntimeException("initial");
        }

        // Java 7 还支持在同一 catch 代码块中捕获多种异常
//        try {
//            // some code
//        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
//        }
    }
}
