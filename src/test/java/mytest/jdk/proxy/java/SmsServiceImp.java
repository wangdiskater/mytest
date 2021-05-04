package mytest.jdk.proxy.java;

/**
 * @version 1.0
 * @ClassName CustomSmsServiceImp
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 22:01
 **/

public class SmsServiceImp implements SmsService {
    @Override
    public String sendMsg(String msg) {
        System.out.println("print msg: " + msg);
        return msg;
    }

    @Override
    public String sendMsg2(String msg) {
        System.out.println("print msg2: " + msg);
        return msg;

    }


}
