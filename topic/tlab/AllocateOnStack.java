package tlab;

/**
 * 演示：栈上分配
 * <p>
 * 参考链接：https://www.cnblogs.com/myseries/p/12884249.html
 *
 * @author Alan Yin
 * @date 2021/9/17
 */

public class AllocateOnStack {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            allocate();
        }
        long end = System.currentTimeMillis();
        System.out.println("cost time:" + (end - start));
    }

    /**
     * 分配空间
     */
    private static void allocate() {
        User user = new User();
        user.setId(20L);
        user.setName("mike");
    }

    /**
     * 试验1
     * // 使用server模式 最大堆空间为15m 初始堆空间为15m 启用逃逸分析 打印ＧＣ日志 关闭TLAB 启用标量替换，允许对象打散分配到栈上
     * -server -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations
     *  > 使用该参数运行，不会触发GC
     */

    /**
     * 试验2
     * //关闭逃逸分析 关闭TLAB 启用标量替换，允许对象打散分配到栈上
     * -server -Xmx15m -Xms15m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations
     *
     * //启用逃逸分析 关闭TLAB 关闭标量替换
     * -server -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB -XX:－EliminateAllocations
     *
     * > 使用该参数（任意一行）运行，会发现触大量ＧＣ
     */
}
