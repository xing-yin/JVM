package lecture12;

/**
 * 看看 Java 对象的生命周期对垃圾回收的影响
 * <p>
 * Run with java -XX:+PrintGC -Xmn100M -XX:PretenureSizeThreshold=10000 LifetimeTest
 * You may also try with -XX:+PrintHeapAtGC，-XX:-UsePSAdaptiveSurvivorSizePolicy or -XX:SurvivorRatio=N
 *
 * @author yinxing
 * @date 2019/12/10
 */

/**
 * 下面这段程序将生成 64G 的 Java 对象。
 * 并且，通过 ALIVE_OBJECT_SIZE 这一变量来定义同时存活的 Java 对象的大小。这也是一种对于垃圾回收器来说比较直观的生命周期。
 * <p>
 * 当我们使用 Java 8 的默认 GC，并且将新生代的空间限制在 100M 时，试着估算当 ALIVE_OBJECT_SIZE 为多少时，
 * 这段程序不会触发 Full GC（提示一下，如果 Survivor 区没法存储所有存活对象，将发生什么。）。实际运行情况又是怎么样的？
 */
public class LifetimeTest {

    private static final int K = 1024;
    private static final int M = K * K;
    private static final int G = K * M;

    private static final int ALIVE_OBJECT_SIZE = 32 * M;

    public static void main(String[] args) {
        int length = ALIVE_OBJECT_SIZE / 64;
        ObjectOf64Bytes[] array = new ObjectOf64Bytes[length];
        for (long i = 0; i < G; i++) {
            array[(int) (i % length)] = new ObjectOf64Bytes();
        }
    }

}
