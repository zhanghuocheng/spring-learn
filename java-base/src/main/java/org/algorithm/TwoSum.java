package org.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
       Arrays.stream(twoSum(new int[]{1,2,3,4,5,6,7,8},8)).forEach(System.out::println);

    }

    /**
     * 暴力 n方
     *  hash 表 n
     * @param nums
     * @param target
     * @return
     */
    public static int []twoSum(int []nums,int target){
        HashMap hashMap=new HashMap<Integer,Integer>();
        for (int i = 0; i <nums.length ; i++) {
            if(hashMap.get(target-nums[i])!=null){
                return new int[]{i, (int) hashMap.get(target-nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{};
    }
}
