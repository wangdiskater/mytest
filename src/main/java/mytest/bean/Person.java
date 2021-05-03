package mytest.bean;

import java.util.Objects;

/**
 * @version 1.0
 * @ClassName Person
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 16:02
 **/

public class Person {
    int age;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
