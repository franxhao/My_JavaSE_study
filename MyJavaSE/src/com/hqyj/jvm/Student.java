package com.hqyj.jvm;

/**
 * 类加载机制：双亲委派机制 实验
 * BOOT 和 EXC 中没有 Student，所以最终会在这里(APP)执行
 */
public class Student {

    @Override
    public String toString(){
        return "Hello";
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getClass().getClassLoader());
        System.out.println(student.toString());
    }
}
