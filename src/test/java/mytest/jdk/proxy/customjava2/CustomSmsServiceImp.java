package mytest.jdk.proxy.customjava2;

public class CustomSmsServiceImp implements CustomSmsService {
    @Override
    public String sendMsg(String msg) {
        System.out.println("print msg: " + msg);
        return msg;
    }
}
