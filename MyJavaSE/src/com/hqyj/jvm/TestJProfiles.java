package com.hqyj.jvm;

import java.util.ArrayList;

/**
 * 内存快照分析工具 JProfiles 的使用
 * 制造 OOM 错误，方便测试工具
 * 了解如何 Dump 文件
 *
 * -Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 */
public class TestJProfiles {

    public static void main(String[] args) {
        ArrayList<TestJProfiles> list = new ArrayList<>();
        int count = 0;


        try {
            while (true) {
                list.add(new TestJProfiles());
                count += 1;
            }
        } catch (Error e) {
            System.out.println("count: " + count);
            e.printStackTrace();
        }
    }
}
