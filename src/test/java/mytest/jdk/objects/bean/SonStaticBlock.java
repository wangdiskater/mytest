package mytest.jdk.objects.bean;

/**
 * @version 1.0
 * @ClassName FatherStaticBlock
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/15 12:37
 **/

public class SonStaticBlock extends FatherStaticBlock{
    static {
        System.out.println("son static block");
    }
    {
        System.out.println("son block");
    }
    public SonStaticBlock() {
        System.out.println("son constructor");
    }
}
