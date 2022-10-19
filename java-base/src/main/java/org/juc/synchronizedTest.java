package org.juc;

public class synchronizedTest {

    /**
     * Synchronized
     * <p>
     * 锁class 对象
     * 实例对象
     *
     * @param args
     */

    private static int i;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                i++;

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                i++;

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                i++;

            }
        }).start();


    }
}
