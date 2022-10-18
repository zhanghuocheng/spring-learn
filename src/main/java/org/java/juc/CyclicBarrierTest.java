package org.java.juc;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;
//可以循环使用
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName());

            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(2000);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }

}
