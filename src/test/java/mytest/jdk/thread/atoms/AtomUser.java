package mytest.jdk.thread.atoms;

/**
 * @Description
 * @ClassName AtomUser
 * @Author wangDi
 * @date 2021-05-13 11:08
 */
public class AtomUser {
    public volatile String name;

    public AtomUser() {
    }

    public AtomUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AtomUser{" +
                "name='" + name + '\'' +
                '}';
    }
}
