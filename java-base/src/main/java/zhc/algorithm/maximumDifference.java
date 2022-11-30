package zhc.algorithm;

public class maximumDifference {
    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{1, 2, 3, 4, 5, 6, 5}));
    }

    public static int maximumDifference(int[] nums) {
        int max = -1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                max = Math.max(max, nums[i] - pre);
            } else {
                pre = nums[i];
            }
        }
        return max;
    }
}
