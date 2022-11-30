package zhc.jvm.part2;


/**
 *
 * -Xss128k  设置栈容量
 */
public class JavaVMStackSOF {
    private int satckLength=1;

    public void stackLek(){
        satckLength++;
        stackLek();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom=new JavaVMStackSOF();
        try{
            oom.stackLek();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.satckLength);
            throw e;
        }
    }
}
