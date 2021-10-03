package com.hqyj.jvm;

/**
 * 堆内存调优1
 */
public class HeapNice {
    public static void main(String[] args) {
        // 返回虚拟机试图使用的最大内存
        long max = Runtime.getRuntime().maxMemory(); // 字节 = M*1024*1024
        // 返回 jvm 的初始化总内存
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max=" + max + "字节\t" + (max / (double) 1024 / 1024) + "MB");
        System.out.println("total=" + total + "字节\t" + (total / (double) 1024 / 1024) + "MB");

        // 默认情况下：分配的总内存 是电脑内存的：1/4，而初始化的内存的：1/64；分配的总内存约为初始化内存的：16倍
            // 以我电脑为例，此电脑内存：16GB ≈ 15.9GB;
            // 此时程序运行出来 max=3611.0MB   total=243.5MB
            // max/15.9   = 3611.0/15.9 ≈ 1/4
            // total/15.9 = 243.5/15.9  ≈ 1/64
            // total/max ≈ 1/16
    }

    /**
     * OOM:
     *    1. 尝试扩大堆内存看结果
     *    2. 分析内存，看一下哪个地方出现了问题（专业工具）
     *
     * -Xms1024m -Xmx1024m -XX:+PrintGCDetails
     *  -Xms：初始内存
     *  -Xmx：总内存
     *
     * 运行后得到：
     *      PSYoungGen新生代 --- 305664K
     *      ParOldGen老年代  --- 699392K
     *      Metaspace元空间
     * 新生代 + 老年代 = 305664K + 699392K = 1,005,056K = 981.5M
     * 所以 元空间：逻辑上存在，物理上不存在
     *
     */
}
