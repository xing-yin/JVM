package com.alany.analysejvm.lecture27;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义了一个注解 @CheckGetter。
 * 它既可以用来标注类，也可以用来标注字段。此外，其生命周期被限定在源代码中。
 *
 * @author Alan Yin
 * @date 2019/12/25
 */

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface CheckGetter {

}
