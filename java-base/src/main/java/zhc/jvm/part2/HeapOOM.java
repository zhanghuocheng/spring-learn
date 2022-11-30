package zhc.jvm.part2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 1 配置相关jvm参数 分析堆内存快照 借助mat工具 定位问题。
 * 2 生成堆内存快照 1 jmap 2 通过配置参数 oom自动导出 3 通过实时工具分析
 *
 *
 *
 * 制造java堆溢出
 * vm
 * -Xmx20M
 * -XX:+HeapDumpOnOutOfMemoryError
 *  -XX:HeapDumpPath=/tmp/heapdump.hprof 来显示指定路径
 *
 *
 * result  Java heap space
 *
 */
public class HeapOOM {

    static class OOMObject{

    }
    public static void main(String[] args) {

        List<OOMObject> list=new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
