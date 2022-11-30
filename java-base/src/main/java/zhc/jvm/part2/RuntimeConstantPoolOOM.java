package zhc.jvm.part2;

import java.util.HashSet;
import java.util.Set;

/**
 * jdk1,7之前 配合-XX:PermSize=1M -XX:MaxPermSize=1M 参数 可以 可以看PermGen space 异常
 *
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        short i=0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
