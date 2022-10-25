package org.algorithm.dynamic;

import org.algorithm.base.GenArray;

import java.util.Arrays;
import java.util.HashMap;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap hashMap = new HashMap<Integer, Integer>();
        hashMap.put(0, nums[0]);

        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempSum = (int) hashMap.get(i - 1);
            int sum = nums[i];
            int max = sum > tempSum ? sum : tempSum;
            for (int j = i - 1; j >= 0; j--) {
                sum = sum + nums[j];
                max = max > sum ? max : sum;
            }
            hashMap.put(i, max);
            maxSum = maxSum > max ? maxSum : max;
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] array = GenArray.getRandomArrays(5);
        Arrays.stream(array).forEach(System.out::println);
        System.out.println(maxSubArray1(array));

    }

    public static int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
