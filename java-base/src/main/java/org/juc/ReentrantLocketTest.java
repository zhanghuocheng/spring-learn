package org.juc;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocketTest {
    public int i = 0;
    public static ExecutorService executorService = new ThreadPoolExecutor(50, 100, 30L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantLocketTest reentrantLocketTest = new ReentrantLocketTest();
        for (int j = 0; j < 10000; j++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    if (reentrantLock.tryLock()) {
                        reentrantLock.lock();
                    }
                    reentrantLocketTest.i++;
                    reentrantLock.unlock();
                    System.out.println(reentrantLocketTest.i);
                }
            });
        }
        executorService.shutdown();
    }
}
