package mytest.jdk.objects.bean;

/**
 * @version 1.0
 * @ClassName FatherStaticBlock
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/15 12:37
 **/

public class FatherStaticBlock {
    static {
        System.out.println("father static block");
    }
    {
        System.out.println("father  block");
    }
    public FatherStaticBlock() {
        System.out.println("father constructor");
    }
}
