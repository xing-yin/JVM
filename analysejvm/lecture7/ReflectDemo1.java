package lecture7;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class 对象的常见反射方法
 *
 * @author yinxing
 * @date 2019/10/23
 */

public class ReflectDemo1 {

    public void test() throws ClassNotFoundException {
        Object o = new Object();
        Method[] methods = Class.forName("test").getDeclaredMethods();
        methods[1].setAccessible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Method[] methods = Class.forName("com.alany.analysejvm.lecture7.TestDemo").getDeclaredMethods();
        for (Method method : methods) {
            /**
             * Method.setAccessible（位于 java.lang.reflect 包，该方法继承自 AccessibleObject）绕过 Java 语言的访问权限，
             * 在私有方法所在类之外的地方调用该方法。
             */
            method.setAccessible(true);
            System.out.println("method is :" + method);
        }
        System.out.println("======================");
        Field[] fields = Class.forName("com.alany.analysejvm.lecture7.TestDemo").getDeclaredFields();
        for (Field field : fields) {
            // 可以获取私有字段
            field.setAccessible(true);
            System.out.println("field is :" + field);
            System.out.println("field name is :" + field.getName());
        }
        System.out.println("======================");
        Annotation[] annotations = Class.forName("com.alany.analysejvm.lecture7.TestDemo").getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation is :" + annotation);
        }
        System.out.println("======================");
        Constructor[] constructors = Class.forName("com.alany.analysejvm.lecture7.TestDemo").getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor is :" + constructor);
        }
    }
}
