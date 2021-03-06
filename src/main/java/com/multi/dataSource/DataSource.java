package com.multi.dataSource;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSource.dataSource1;
 
    public static String dataSource1 = "dataSource1";
 
    public static String dataSource2 = "dataSource2";

 
}
