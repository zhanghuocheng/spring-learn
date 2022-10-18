package com.zhc.springlearn.juc;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(1000);
                countDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(2000);

                countDownLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(3000);
                countDownLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        countDownLatch.await();
        System.out.println("可以执行了");

    }
}
