package lecture14.auto_box;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinxing
 * @date 2019/12/12
 */

public class AutoBoxDemo {

    public int foo() {
        List<Integer> list = new ArrayList<>(2);
        // 自动装箱: 字节码会用到 Integer.valueOf()
        list.add(1);
        // 自动拆箱: 字节码会用到 Integer.intValue()
        int result = list.get(0);
        return result;
    }
}


/**
 * javap -v XXX.class // 查看字节码
 *
 *  public com.alany.analysejvm.lecture14.auto_box.AutoBoxDemo();
         descriptor: ()V
         flags: ACC_PUBLIC
         Code:
         stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
         LineNumberTable:
         line 11: 0

 public int foo();
     descriptor: ()I
     flags: ACC_PUBLIC
     Code:
     stack=3, locals=3, args_size=1
     0: new           #2                  // class java/util/ArrayList
     3: dup
     4: iconst_2
     5: invokespecial #3                  // Method java/util/ArrayList."<init>":(I)V
     8: astore_1
     9: aload_1
     10: iconst_1
     11: invokestatic  #4                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
     14: invokeinterface #5,  2            // InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
     19: pop
     20: aload_1
     21: iconst_0
     22: invokeinterface #6,  2            // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
     27: checkcast     #7                  // class java/lang/Integer
     30: invokevirtual #8                  // Method java/lang/Integer.intValue:()I
     33: istore_2
     34: iload_2
     35: ireturn
     LineNumberTable:
     line 14: 0
     line 15: 9
     line 16: 20
     line 17: 34
     }
     SourceFile: "AutoBoxDemo.java"
 */
