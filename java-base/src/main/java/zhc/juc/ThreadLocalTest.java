package zhc.juc;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal=new ThreadLocal();
        threadLocal.set("test");

    }
}
