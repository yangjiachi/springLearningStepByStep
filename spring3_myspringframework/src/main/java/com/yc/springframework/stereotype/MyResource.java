package com.yc.springframework.stereotype;

import java.lang.annotation.*;

@Target(value={ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyResource {
    public String name() default "";
}
