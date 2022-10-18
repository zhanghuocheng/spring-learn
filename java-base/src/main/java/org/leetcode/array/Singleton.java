package org.leetcode.array;

public class Singleton {


        private volatile static Singleton singleton;
        private Singleton() {
        }
        public static Singleton getSingleton() {


            Runtime.getRuntime().gc();
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton == null) {
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }

