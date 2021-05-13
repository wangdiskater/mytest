package mytest.jdk.thread.atoms;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Description
 * @ClassName AtomFieldType
 * @Author wangDi
 * @date 2021-05-13 11:36
 */
public class AtomFieldType {

    @Test
    void AtomicReferenceField() {
        // cannot access a member of class mytest.jdk.thread.atoms.AtomUser with modifiers "private"
        // Must be volatile type
        AtomicReferenceFieldUpdater<AtomUser, String> fieldUpdater
                = AtomicReferenceFieldUpdater.newUpdater(AtomUser.class, String.class, "name");
        String name = "old name";
        AtomUser atomUser = new AtomUser(name);
        boolean b1 = fieldUpdater.compareAndSet(atomUser, name, "新的名字");
        boolean b2 = fieldUpdater.compareAndSet(atomUser, name, "新的名字2");
    }
}
