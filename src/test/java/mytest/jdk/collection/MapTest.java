package mytest.jdk.collection;

import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

    @Test
    void test1() {

        Map<String, Object> attributes = new HashMap<>();
//        attributes.put("openId", null);
        attributes.put("role", "asdasdasd");
        System.out.println(attributes);
        int userId = 826966;
        UserDetails userDetails = new UserDetails(Integer.toString(userId), Collections.emptyList(), attributes);

        Object openId = userDetails.getAttributes("role", "username").get("openId");
        if (openId == null) {
            openId = "UNKNOWN";
        }
    }

    /**
     * 测试两种遍历的效率？
     */
    @Test
    void test2() {
        Map<String, Object> attributes = getMap(100000);


        long start1 = System.nanoTime();
        attributes.forEach((key,value)->{
            System.out.println("key: " + key + " value: " + value);
        });
        long end1 = System.nanoTime();
        long interval1 = end1 - start1;


        System.out.println("--------------------------------------------------------------------------------------------------------------");

        long start2 = System.nanoTime();
        Set<String> strings = attributes.keySet();
        strings.forEach(key->{
            System.out.println("key: " + key + " value: " + attributes.get(key));
        });
        long end2 = System.nanoTime();
        long interval2 = end2 - start2;

        System.out.println("时间： " + interval1);
        System.out.println("时间： " + interval2);
    }

    private Map<String, Object> getMap(int len) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        for (int i = 0; i <len ; i++) {
            stringObjectHashMap.put(i+"" , "憨批测试");
        }
        return stringObjectHashMap;
    }

    /**
     * 看源码
     */
    @Test
    void test3() {
        HashMap<String, String> hashMap = new HashMap<>();

        String put = hashMap.put("a", "b");


    }


}
