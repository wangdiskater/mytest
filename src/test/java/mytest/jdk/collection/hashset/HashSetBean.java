package mytest.jdk.collection.hashset;

import java.util.Objects;

/**
 * @Description
 * @ClassName HashSetBean
 * @Author wangDi
 * @date 2021-05-07 16:41
 */
public class HashSetBean {
    private String name;
    public HashSetBean(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
