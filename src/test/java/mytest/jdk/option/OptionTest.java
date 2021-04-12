package mytest.jdk.option;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Description
 * @ClassName OptionTest
 * @Author wangDi
 * @date 2021-03-23 15:26
 */
public class OptionTest {

    @Test
    void optionTest() {
        Optional<String> empty = Optional.empty();
        String s1 = "";

        Optional<String> s11 = Optional.ofNullable(s1);

        s11.ifPresent(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if ("".equals(s)) {
                    s = "1";
                }
            }
        });

        String s = s11.get();
    }
}
