package org.java.juc;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal=new ThreadLocal();
        Thread thread=Thread.currentThread().get
        threadLocal.set("test");

    }
}
