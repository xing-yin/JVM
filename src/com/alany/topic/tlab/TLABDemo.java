package com.alany.topic.tlab;

/**
 * 演示 TLAB 作用：
 * <p>
 * 应用中有很多的对象的作用域都不会逃逸出方法外，即该对象的生命周期会随着方法的调用开始而开始，方法的调用结束而结束，
 *
 * @author Alan Yin
 * @date 2021/9/17
 */

public class TLABDemo {

    // ================================================================================================
    private User user;

    /**
     * user的作用域超出了函数setUser的范围,是逃逸对象。
     * 当函数结束调用时，不会自行销毁user
     */
    public void setUser() {
        user = new User();
        user.setId(20L);
        user.setName("rose");
    }

    /**
     * user 只在函数内部生效，不是逃逸对象。
     * 当函数调用结束，会自行销毁对象 user
     */
    public void createUser() {
        User user = new User();
        user.setId(20L);
        user.setName("mike");
    }
}
