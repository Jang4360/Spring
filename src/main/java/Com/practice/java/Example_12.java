package Com.practice.java;

import Com.practice.product.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Example_12 {
    @interface TestInfo{
        int count() default 1;
        String[] value() default "abc";
    }

    @TestInfo
    class Exercise{}

    @TestInfo(count = 1)
    class Exercise2{}

    @TestInfo("bbb")
    class Exercise3{}

    @TestInfo(value = {"aaa","bbb"})
    class Exercise4{}
}
