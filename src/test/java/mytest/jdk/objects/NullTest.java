package mytest.jdk.objects;

import mytest.jdk.objects.bean.FatherStaticBlock;

/**
 * @Description
 * @ClassName NullTest
 * @Author wangDi
 * @date 2021-05-19 16:59
 */
public class NullTest {

    public static void main(String[] args) {

        FatherStaticBlock fatherStaticBlock = (FatherStaticBlock)null;
        // 肯定报错
        fatherStaticBlock.print();

    }
}
