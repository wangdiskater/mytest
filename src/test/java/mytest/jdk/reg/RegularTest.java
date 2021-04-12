package mytest.jdk.reg;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @Description
 * @ClassName RegularTest
 * @Author wangDi
 * @date 2021-03-29 10:41
 */
public class RegularTest {

    /**
     * redo
     */
    @Test
    void regular() {
        String pattern = "^(a+)+$";

        for (int i = 1; i < 100000; i =i+10000) {
            getRegularResult(pattern,i);
        }

    }

    boolean getRegularResult(String pattern, long num){
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i <  num; i++) {
            sb.append("a");
        }
        sb.append("!");
        String s = new String(sb);
        long begin = System.currentTimeMillis();
        boolean matches = Pattern.matches(pattern, s);

        long end = System.currentTimeMillis();

        long l = (end - begin);

        System.out.println("使用时间（毫秒）" + l);

        return matches;
    }


    /**
     * 必须包括字母数字特殊字符任意2种的正则表达式    8-20位
     */
    @Test
    void regular2() {
        String pattern = "(?!^(\\d+|[a-zA-Z]+|[~!@#$%^&*?]+)$)^[\\w~!@#$%^&*?]{8,20}$";

        String s = "a222222";
        boolean matches = Pattern.matches(pattern, s);

        if (matches) {
            System.out.println(s + "  匹配");
        } else {
            System.out.println(s + "  不匹配");
        }
    }

    @Test
    void regular3() {
        String defaultPwd = getDefaultPwd();
        System.out.println(defaultPwd);
    }

    /**
     * 默认20位，8位数字 + 12位UUID
     * @return
     */
    public static String getDefaultPwd() {
        UUID uuid = UUID.randomUUID();
        String substring = uuid.toString().substring(0, 12);
        long math = RandomUtils.nextLong(10000000, 100000000);
        return math + substring;
    }
}
