package com.alany.analysejvm.lecture13;

/**
 * 验证一个坊间传闻：调用 Object.hashCode() 会关闭该对象的偏向锁
 *
 * @author yinxing
 * @date 2019/12/12
 */

/**
 * 你可以采用参数 -XX:+PrintBiasedLockingStatistics 来打印各类锁的个数。由于 C2 使用的是另外一个参数 -XX:+PrintPreciseBiasedLockingStatistics，因此你可以限制 Java 虚拟机仅使用 C1 来即时编译（对应参数 -XX:TieredStopAtLevel=1）。
 * <p>
 * 1.通过参数 -XX:+UseBiasedLocking，比较开关偏向锁时的输出结果。
 * 2.在 main 方法的循环前添加 lock.hashCode 调用，并查看输出结果。
 * 3.在 Lock 类中复写 hashCode 方法，并查看输出结果。
 * 4.在 main 方法的循环前添加 System.identityHashCode 调用，并查看输出结果。
 */
public class SynchronizedTest {

    // Run with -XX:+UnlockDiagnosticVMOptions -XX:+PrintBiasedLockingStatistics -XX:TieredStopAtLevel=1
    static Lock lock = new Lock();
    static int counter = 0;

    public static void foo() {
        synchronized (lock) {
            counter++;
        }
    }

    static class Lock {
        @Override
        public int hashCode() {
            // Step 3
            return 0;
        }
    }

    public static void main(String[] args) {
        // Step 2
        lock.hashCode();
        // Step 4
        System.identityHashCode(lock);
        for (int i = 0; i < 1_000_000; i++) {
            foo();
        }
        System.out.println(counter);
    }

}
