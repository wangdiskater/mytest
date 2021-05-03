package mytest.jdk.jvm;

/**
 * @version 1.0
 * @ClassName ChangeTest
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 16:24
 **/

public class ChangeTest {

    public static void main(String[] args) {

        User user = new User();

        fillUserInfo(user);
        System.out.println("user: " + user);

//        Tool.fillUserInfo(user);
//        System.out.println("user: " + user);

        Tool tool = new Tool();
        tool.fillUserInfo(user);
        System.out.println("user: " + user);


    }

    private static void fillUserInfo(User user) {

        user.setName("名字");
        user.setPhone("18819472245");
    }
}
