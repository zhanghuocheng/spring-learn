package zhc.algorithm;

public class RemoveDuplicates {

    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates(new int[]{1,2,2,2,2,3,45,45,55,99});

    }

    public int removeDuplicates(int[] nums) {
        int fast=1,slow=1;
        while (fast<nums.length){
            if(nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
