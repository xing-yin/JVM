package com.alany.analysejvm.lecture27;

/**
 * process方法涉及各种不同类型的Element，分别指代 Java 程序中的各个结构。
 * 如TypeElement指代类或者接口，VariableElement指代字段、局部变量、enum 常量等，ExecutableElement指代方法或者构造器。
 *
 * @author Alan Yin
 * @date 2019/12/25
 */
@CheckGetter
public class Foo {

    // VariableElement
    int a;
    // VariableElement
    static int b;

    // ExecutableElement
    Foo() {
    }

    // 方法  ExecutableElement
    // 参数 VariableElement
    void setA(int newA) {
    }

    public static void main(String[] args) {
        System.out.println(1);
    }

}
