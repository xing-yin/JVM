package lecture5;

/**
 * @author yinxing
 * @date 2019/10/22
 */

public abstract class Passenger {

    /**
     * 出国
     */
    abstract void goAbroad();

    public static void main(String[] args) {
        Passenger a = new Chinese();
        Passenger b = new Foreigner();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            Passenger c = (i < 1_000_000_000) ? a : b;
            c.goAbroad();
        }
    }
}


