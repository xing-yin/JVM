package lecture14.foreach;

/**
 * @author yinxing
 * @date 2019/12/12
 */

public class ArrayForeachDemo {

    public void foo(int[] array) {
        for (int item : array) {
        }
    }

    /**
     * 等同于
     */
    public void bar(int[] array) {
        for (int i = 0; i < array.length; i++) {
        }
    }

}
