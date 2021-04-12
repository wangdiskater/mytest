package mytest.jdk.string;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @ClassName StringTest
 * @Author wangDi
 * @date 2021-03-16 18:03
 */
public class StringTest {

    @Test
    void stringTest1() {
        String[] strArr = new String[]{"a","b","c","",""};
        String str = String.join(",", strArr);
        System.out.println(str);
        int len = strArr.length;
        String[] ary = str.split(","); // 预期大于3，结果是3
        for (int i = 0; i < len; i++) {
            System.out.println(ary[i]);
        }

    }

    @Test
    void stringTest2() {
        String str = "a,b,c,,";
        String divideNote = ",";
        int len = getCompensatedNum(str,divideNote);
        String[] ary = str.split(divideNote); // 预期大于3，结果是3
        for (int i = 0; i < len; i++) {
            System.out.println(ary[i]);
        }

    }

    /**
     * 获取实际分隔
     * @param str
     * @param divideNote
     * @return
     */
    private int getCompensatedNum(String str, String divideNote) {
        int compensated = 0;
        while (str.endsWith(divideNote)) {
            String substring = str.substring(0, str.lastIndexOf(divideNote));
            str = substring;
            compensated++;
        }
        return  compensated;
    }
}
