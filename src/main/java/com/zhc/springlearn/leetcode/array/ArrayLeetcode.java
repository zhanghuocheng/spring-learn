package com.zhc.springlearn.leetcode.array;


import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayLeetcode {

    /**
     * 从数组中移除指定字符串
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        int left = 0, right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-2 ; i++) {
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 2, 3};
        System.out.println(new ArrayLeetcode().removeElement(array, 3));

    }
}
