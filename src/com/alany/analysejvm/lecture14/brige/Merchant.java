package com.alany.analysejvm.lecture14.brige;

/**
 * @author yinxing
 * @date 2019/12/12
 */

public class Merchant <T extends Customer> {

    public Number actionPrice(T customer){
        return 0.0d;
    }

}
