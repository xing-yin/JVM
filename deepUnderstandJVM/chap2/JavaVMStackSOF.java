package  chap2;

/**
 * VM Args：-Xss256k
 *
 * @author: yinxing
 * @date: 2019/3/3
 */
public class JavaVMStackSOF {

    private int stackLenth = 1;

    public void stackLeak() {
        stackLenth++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length: " + javaVMStackSOF.stackLenth);
            throw e;
        }
    }
}
