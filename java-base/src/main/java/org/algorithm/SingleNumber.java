package org.algorithm;

/**
 * 答案是使用位运算。对于这道题，可使用异或运算 \oplus⊕。异或运算有以下三个性质。
 *
 * 任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
 * 任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
 * 异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
 *

 */

public class SingleNumber {


    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,2,21,3,4,3,4,1,2}));
    }

    public static int singleNumber(int[] nums) {
        int single=0;
        for (int num:nums) {
            single^=num;
        }
        return single;
    }
}
