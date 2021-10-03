package com.hqyj.jvm;

import java.util.Random;

/**
 * 堆内存调优2
 *
 * -Xms8m -Xmx8m -XX:+PrintGCDetails
 */
public class Hello {
    public static void main(String[] args) {
        String str = "helloJava";

        while (true) {
            str += str + new Random().nextInt(888888888) + new Random(999999999);
        }
    }
}
