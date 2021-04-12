package mytest.jdk.switchtest;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @ClassName SwitchString
 * @Author wangDi
 * @date 2021-03-19 10:02
 */
public class SwitchString {
    @Test
    void switchString() {
        switchNull(null);
    }

    private void switchNull(String param) {
        switch (param) {
            case "sth":
                System.out.println("param");
                break;
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }

    }
}
