package zhc.algorithm;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {

        System.out.println( majorityElement1(new int[]{1,2,3,4,4,4,44,4}));
    }
    public  static int majorityElement(int []nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    public static int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
