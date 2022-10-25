package org.algorithm.arraylink;

import org.algorithm.base.GenArray;

import java.util.Arrays;

/**
 * 冒泡排序
 * 冒泡 选择 插入 希尔 归并 快速 堆 计数 桶 基数
 */
public class Sort {

    public static void main(String[] args) {
        Arrays.stream(bubbleSort(GenArray.getRandomArrays(30))).forEach(i -> System.out.print(i + ","));

    }

    /**
     * 可以优化 比如本省有序的情况 直接跳过
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }


    /**
     * @return
     */
    public static int[] quickSort() {
        return new int[]{};
    }

    /**
     *归并排序
     * @return
     */
    public static int[] test(){
        return new int[]{};
    }
}
