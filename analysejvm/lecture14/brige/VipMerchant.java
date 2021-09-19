package lecture14.brige;

/**
 * 生成桥接方法情况1：泛型重写会生成桥接方法之外
 *
 * @author yinxing
 * @date 2019/12/12
 */

public class VipMerchant extends Merchant<VIP> {

    /**
     * VipMerchant 中的 actionPrice 方法是符合 Java 语言的方法重写的，使用 @Override 来注解了。
     * 然而，经过类型擦除后，父类的方法描述符为 (LCustomer;)D，而子类的方法描述符为 (LVIP;)D。
     * 这显然不符合 Java 虚拟机关于方法重写的定义。
     */
    @Override
    public Number actionPrice(VIP customer) {
        return 0.0d;
    }

    /**
     * 为了保证编译而成的 Java 字节码能够保留重写的语义，Java 编译器额外添加了一个桥接方法。
     * 该桥接方法在字节码层面重写了父类的方法，并将调用子类的方法。
     */

    public static void main(String[] args) {
        Customer customer = new VIP();
        VipMerchant vipMerchant = new VipMerchant();
        // 当你尝试通过传入一个声明类型为 Customer 的对象作为参数，
        // 调用 VipMerchant 类的 actionPrice 方法时，Java 编译器会报错，并且提示参数类型不匹配。
        // 尽管生成了桥接方法，但是使用时仍然不能传父类，不能通过编译
        // vipMerchant.actionPrice(customer);
    }
}
