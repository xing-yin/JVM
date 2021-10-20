package volatile_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示：Volatile 可见性
 *
 * @author Alan Yin
 * @date 2021/10/15
 */

public class VolatileVisibility {

    /**
     * 线程不安全
     */
    public static volatile int i = 0;

    public static void increase() {
        i++;
    }

    // ----------------------------------------------------------------------------------------------
    /**
     * 线程安全
     */
    volatile boolean close;

    public void close() {
        close = true;
    }

    public void doSomething() {
        while (!close) {
            System.out.println("Thread safe");
        }
    }

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            executors.execute(() -> increase());
        }
        System.out.println("i is:" + i);
    }
}
