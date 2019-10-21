package com.alany.analysejvm.lectue2;

/**
 * 掩码操作
 * </b>
 *
 * @author yinxing
 * @date 2019/10/18
 */

public class MaskOperationDemo {

    public static boolean booleanValue;

    public static void main(String[] args) {
        // case 1
        booleanValue = true;
        // case 2
//        booleanValue = 2;
        // case 3
//        booleanValue = 3;
        if (booleanValue) {
            System.out.println("hi");
        }
        if (booleanValue == true) {
            System.out.println("hello");
        }
    }
}
