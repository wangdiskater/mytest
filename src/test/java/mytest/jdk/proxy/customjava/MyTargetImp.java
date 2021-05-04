package mytest.jdk.proxy.customjava;

/**
 * @version 1.0
 * @ClassName MyTargetImp
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 22:46
 **/

public class MyTargetImp implements MyTarget {

    @Override
    public void send(String msg) {
        System.out.println("MyTargetImp send msg! msg is :" + msg);
    }
}
