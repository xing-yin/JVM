package not_null_annotation;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Alan Yin
 * @date 2019/12/25
 */

public class BaseRequest {

    public void nullFieldvalidate() throws IllegalAccessException, InvocationTargetException {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            Object fieldValue = runGetter(field, this);

            // 获取类属性上的注解有3种方法:

            boolean isAnnotationbNotNull = field.isAnnotationPresent(NotNull.class);
            if (isAnnotationbNotNull && fieldValue == null) {
                System.out.println(fieldName + "can' t be null");
            }

//            // 方法1
//            Annotation[] annotations = field.getDeclaredAnnotations();
//            for (Annotation annotation : annotations) {
//                if (annotation instanceof NotNull && fieldValue == null) {
//                    System.out.println(field.getName() + " can't be null");
//                }
//            }

//            // 方法2
//            Annotation annotation = field.getAnnotation(NotNull.class);
//            if (annotation != null && fieldValue == null) {
//                System.out.println(field.getName() + " can't be null");
//            }

//            // 方法3
//            boolean isAnnotationNotNull = field.isAnnotationPresent(NotNull.class);
//            if (isAnnotationNotNull && fieldValue == null) {
//                System.out.println(field.getName() + " can't be null");
//            }
        }
    }

    // 由于所有子类的属性都是private的，所以必须要找到属性的getter方法
    // 以下代码借鉴[stackoverflow的文章](https://stackoverflow.com/questions/13400075/reflection-generic-get-field-value)
    public Object runGetter(Field field, Object instance) {
        // MZ: Find the correct method
        for (Method method : instance.getClass().getDeclaredMethods()) {
            if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3))) {
                if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase())) {
                    // MZ: Method found, run it
                    try {
                        return method.invoke(instance);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.out.println("Could not determine method: " + method.getName());
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        QueryUserRequest request = new QueryUserRequest();
//        request.setName(null);
//        request.setAge(null);
//        System.out.println(request);


    }
}
