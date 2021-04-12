package mytest.jdk.enums;

import org.junit.jupiter.api.Test;

public class MyEnum {

    @Test
    void test() {
        ConsultState consultState = ConsultState.valueOf("created".toUpperCase());
        System.out.println(consultState == ConsultState.CREATED);
    }
}
