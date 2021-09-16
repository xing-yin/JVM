package com.alany.analysejvm.lecture4.demo3;

import java.util.Random;

/**
 * 奸商
 *
 * @author Alan Yin
 * @date 2021/9/13
 */

public class ProfiteerMerchant extends Merchant {

    @Override
    public Double actionPrice(double price, Customer customer) {
        if (customer.isVIP()) {         // invokeinterface：用于调用接口方法
            return price * vipPrice(); // invokestatic：用于调用静态方法
        } else {
            return super.actionPrice(price, customer);  // invokespecial：用于调用私有实例方法、构造器，以及使用 super 关键字调用父类的实例方法或构造器，和所实现接口的默认方法。
        }
    }

    private double vipPrice() {
        // 咱们的杀熟算法太粗暴了，应该将客户城市作为随机数生成器的种子。
        return new Random()                          // invokespecial
                .nextDouble()                         // invokevirtual：用于调用非私有实例方法
                + 0.8d;
    }

}
