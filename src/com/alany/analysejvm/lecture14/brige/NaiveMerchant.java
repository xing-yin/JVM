package com.alany.analysejvm.lecture14.brige;

/**
 * 生成桥接方法情况2：
 * 如果子类定义了一个与父类参数类型相同的方法，其返回类型为父类方法返回类型的子类，那么 Java 编译器也会为其生成桥接方法。
 *
 * @author yinxing
 * @date 2019/12/12
 */

public class NaiveMerchant extends Merchant {

    @Override
    public Double actionPrice(Customer customer) {
        return 0.0D;
    }

}
