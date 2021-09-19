package lecture19.test2;

/**
 * @author yinxing
 * @date 2019/12/17
 */

public class Test2 {

    public static boolean bar() {
        return false;
    }

    public void foo() {
        bar();
    }
}

/**
 * public void foo();
 * descriptor: ()V
 * flags: ACC_PUBLIC
 * Code:
 * stack=1, locals=1, args_size=1
 * 0: invokestatic  #2                  // Method bar:()Z
 * 3: pop
 * 4: return
 */
