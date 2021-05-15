package mytest.jdk.objects;

import mytest.jdk.objects.bean.FatherStaticBlock;
import mytest.jdk.objects.bean.SonStaticBlock;
import org.junit.jupiter.api.Test;

/**
 * @version 1.0
 * @ClassName StaticBlockTest
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/15 12:36
 **/

public class StaticBlockTest {

    public StaticBlockTest() {

    }

    @Test
    void StaticBlockTest(){
        FatherStaticBlock sonStaticBlock = new SonStaticBlock();
        System.out.println("------------------------------------------------------------------");
        sonStaticBlock = new SonStaticBlock();

}
}
