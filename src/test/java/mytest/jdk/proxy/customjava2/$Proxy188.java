package mytest.jdk.proxy.customjava2;

import java.lang.reflect.Method;

public class $Proxy188 implements mytest.jdk.proxy.customjava2.CustomSmsService {
    private static Method m1;

    static {
        try {
            m1 = Class.forName("mytest.jdk.proxy.customjava2.CustomSmsServiceImp").getDeclaredMethod("sendMsg",
                    String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private InvocationHandler h;

    public $Proxy188(InvocationHandler h) {
        this.h = h;
    }


    public String sendMsg(String msg) {
        Object[] args = new Object[]{msg};
        try {
            h.invoke(this, m1, args);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 功能描述 测试是否可用
     * @author wangdi
     * @date   2021/5/4 15:12
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        $Proxy188 $Proxy188 = new $Proxy188(new SendMsgInvocationHandler(new CustomSmsServiceImp()));
        $Proxy188.sendMsg("起飞了");

    }

}
