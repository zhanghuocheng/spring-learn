package zhc.jvm.part2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *  -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 *  直接 内存溢出
 *
 */
public class DirectMemoryOOM {

    private static final int _1MB=1024*1024;

    public static void main(String[] args) throws IllegalAccessException {

        Field unsafeField= Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe= (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
