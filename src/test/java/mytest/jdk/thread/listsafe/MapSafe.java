package mytest.jdk.thread.listsafe;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @ClassName MapSafe
 * @Author wangDi
 * @date 2021-04-28 16:30
 */
public class MapSafe {

    @Test
    void mapSafe() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        String wd = "wangdi";
        concurrentHashMap.put(wd,"happly");
        concurrentHashMap.put(wd,"happly2");

        String s = concurrentHashMap.get(wd);


    }
}
