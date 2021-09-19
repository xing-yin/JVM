package lecture7;

import java.lang.reflect.Method;

/**
 * @author yinxing
 * @date 2019/10/23
 */

public class ReflectDemo2 {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("ReflectDemo2");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }

}

/**
 * 上面获取了一个指向 Test.target 方法的 Method 对象，并且用它来进行反射调用。在 Test.target 中，会打印出栈轨迹。
 * <p>
 * 可以看到，反射调用先是调用了 Method.invoke，然后进入委派实现（DelegatingMethodAccessorImpl），
 * 再然后进入本地实现（NativeMethodAccessorImpl），最后到达目标方法。
 */
//java ReflectDemo2
//java.lang.Exception: #0
//        at ReflectDemo2.target(ReflectDemo2.java:11)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.lang.reflect.Method.invoke(Method.java:498)
//        at ReflectDemo2.main(ReflectDemo2.java:17)
