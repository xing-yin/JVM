package invokXXX;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * JVM指令之 invokestatic,invokespecial,invokeinterface,invokevirtual,invokedynamic
 * 参考链接：
 * https://blog.csdn.net/kangkanglou/article/details/79422520
 * https://www.infoq.cn/article/Invokedynamic-Javas-secret-weapon
 * <p>
 * invokestatic：用于调用静态方法。（Invoke a class (static) method ）
 * invokespecial：用于调用私有实例方法、构造器，以及使用 super 关键字调用父类的实例方法或构造器，和所实现接口的默认方法。
 * （Invoke instance method; special handling for superclass, private, and instance initialization method invocations ）
 * invokevirtual：用于调用非私有实例方法。（Invoke instance method; dispatch based on class）
 * invokeinterface：用于调用接口方法。（Invoke interface method）
 * invokedynamic：用于调用动态方法。(Invoke dynamic method)
 *
 * @author yinxing
 * @date 2019/12/2
 */

public class JVMInstuctionTest implements Runnable {

    public JVMInstuctionTest() {
        System.out.println("construct method ==> invokespecial");
    }

    private void invokeSpecialMethod() {
        System.out.println("private method ==> invokespecial");
    }

    void invokeVirtualMethod() {
        System.out.println("instance method ==> invokevirtual");
    }

    static void invokeStaticMethod() {
        System.out.println("static method ==> invoke static");
    }

    @Override
    public void run() {
        System.out.println("invoke interface");
    }

    //====================================================================================================

    /**
     * 以下为使用 MethodHandle (方法句柄)
     *
     * @param s
     */
    public void methodHandle(String s) {
        System.out.println("for method handle " + s + " ==> invokedynamic");
    }

    public static void staticMethodHandle(String s) {
        System.out.println("static for method handle " + s + " ==> invokestatic");
    }


    public static void main(String[] args) throws Throwable {
        // I.使用 invoke 指令
        /**
         * invokespecial
         */
        JVMInstuctionTest test = new JVMInstuctionTest();
        /**
         * invokespecial
         */
        test.invokeSpecialMethod();
        /**
         * invokevirtual
         */
        test.invokeVirtualMethod();
        /**
         * invokestatic
         */
        invokeStaticMethod();
        /**
         * invokeinterface
         */
        Runnable runnable = new JVMInstuctionTest();
        runnable.run();
        /**
         * invokedynamic
         * Java 8中，lambda表达式和默认方法时，底层会生成和使用invoke dynamic
         */
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream().forEach(System.out::println);
        System.out.println("==============");

        //===================================== MethodHandle VS Reflect ===================================================
        // II.使用 MethodHandle
        /**
         * invokedynamic
         */
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(JVMInstuctionTest.class,
                "methodHandle",
                MethodType.methodType(void.class, String.class));
        System.out.println(mh);
        mh.bindTo(test).invoke("no static string");
//        mh.bindTo(test).invokeExact("no static string");

        mh = lookup.findStatic(JVMInstuctionTest.class,
                "staticMethodHandle",
                MethodType.methodType(void.class, String.class));
        mh.invoke("static string");
        System.out.println("==============");

        // 演示使用 Object 类中的方法
//        mh = lookup.findVirtual(JVMInstuctionTest.class,
//                "toString",
//                MethodType.methodType(String.class));
//        mh.invoke();
//        System.out.println("==============");

        // III.使用 reflect
        Class clazz = Class.forName("invokXXX.JVMInstuctionTest");
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("methodHandle", String.class);
        method.invoke(obj, "aaa");
    }

}
