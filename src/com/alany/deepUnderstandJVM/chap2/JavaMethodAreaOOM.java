package  com.alany.deepUnderstandJVM.chap2;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * <p>
 * 备注:需要借助CGLib字节码技术
 *
 * @author: yinxing
 * @date: 2019/3/3
 */
public class JavaMethodAreaOOM {

//    public static void main(String[] args) {
//        while (true) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperClass(OOMobject.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback(new MethodInterceptor() {
//                public Object intercept(Object obj,
//                                        Method method,
//                                        Object[] args,
//                                        MethodProxy proxy) throws Throwable {
//
//
//                    return proxy.invokeSuper(obj, args);
//                }
//            });
//            enhancer.create();
//        }
//
//    }

    static class OOMobject {

    }


}
