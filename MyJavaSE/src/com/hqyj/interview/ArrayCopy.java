package com.hqyj.interview;

import java.util.Arrays;

/**
 * 技术面试 ---- 国泰新点
 * 将旧数组复制到新数组的方法
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 5, 6, 7, 8, 9 };


        /**
         * 1、System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
         * src:源数组;
         * srcPos:源数组要复制的起始位置;
         * dest:目的数组;
         * destPos:目的数组放置的起始位置;
         * length:复制的长度.
         */
        System.arraycopy(arr, 1, arr2, 0, 3);
        System.out.println(Arrays.toString(arr2));

        System.out.println("------------------------------");

        /**
         * 2、Arrays.copyOf(int[] original, int newLength)
         *      original:   原数组
         *      newLength:  新数组长度
         */
        int[] arr3 = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(arr3));

        System.out.println("------------------------------");

        /**
         * 3、copyOfRange(int[] original, int from, int to)
         *      original: 原数组
         *      from: 从此索引处开始
         *      to: 终止索引
         *      from < to
         *      若 to > arr.length，则多出部分用默认值填充
         */
        int[] arr4 = Arrays.copyOfRange(arr, 0, arr.length); // full copy of the array
        int[] arr5 = Arrays.copyOfRange(arr, 3, arr.length); // copy only the last 2 elements
        System.out.println("arr4 = " + Arrays.toString(arr4));
        System.out.println("arr5 = " + Arrays.toString(arr5));

        System.out.println("------------------------------");

        /**
         * 4、Object.clone()
         * 照原样复制数组
         */
        int[] arr6 = arr.clone();
        System.out.println(Arrays.toString(arr6));
    }
}
