package com.zhc.springlearn.juc;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                semaphore.acquire();
                while (true){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                semaphore.acquire();
                while (true){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                semaphore.acquire();
                while (true){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                semaphore.acquire();
                while (true){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
    }
}
