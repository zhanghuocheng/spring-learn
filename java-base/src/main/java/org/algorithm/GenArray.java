package org.algorithm;

import java.util.Arrays;
import java.util.Random;

public class GenArray {

    public static void main(String[] args) {
       Arrays.stream(getRandomArrays(100)).forEach(System.out::print);
    }

    public static int [] getRandomArrays(int len){
        if(len==0){
            len=100;
        }
        int []array=new int[len];
        Random random=new Random();

        for (int i = 0; i <len ; i++) {
            array[i]=random.nextInt(100);
        }
        return array;
    }
}
