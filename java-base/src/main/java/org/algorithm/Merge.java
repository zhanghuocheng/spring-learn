package org.algorithm;

public class Merge {


    public static void main(String[] args) {
        new Merge().merge(new int[]{}, 0, new int[]{4, 5, 6}, 3);
    }

    /**
     * 合并有序数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0||n==0){
            nums1=m==0?nums2:nums1;
            return;
        }

        int curr = m + n - 1;
        while (n >= 1) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[curr] = nums2[n - 1];
                n--;
            } else {
                nums1[curr] = nums1[m - 1];
                m--;
            }
            curr--;
        }
    }
}
