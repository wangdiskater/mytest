package mytest.jdk.thread.atoms;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.function.UnaryOperator;

/**
 * @Description 引用类型使用
 * @ClassName AtomReferenceType
 * @Author wangDi
 * @date 2021-05-13 11:08
 */
public class AtomReferenceType {

    public static void main(String[] args) {
        //AtomicReference
        AtomicReference<AtomUser> atomUserAtomicReference = new AtomicReference<>();
        AtomUser atomUser = new AtomUser();
        atomUserAtomicReference.set(atomUser);
        atomUser.setName("原来的名字");
        AtomUser user = atomUserAtomicReference.getAndUpdate(atomUser1 -> {
            atomUser1.setName("后来的名字1");
            return atomUser1;
        });
        System.out.println(user);

    }

    @Test
    void atomicStampReference() {
        AtomUser user = new AtomUser("你的名字");
        //AtomicStampedReference
        AtomicStampedReference<AtomUser> atomUserAtomicStampedReference = new AtomicStampedReference<>(user, 0);
        int stamp = atomUserAtomicStampedReference.getStamp();

        AtomUser atomUser1 = new AtomUser("新来的1");
        AtomUser atomUser2 = new AtomUser("新来的2");

        boolean b1 = atomUserAtomicStampedReference.compareAndSet(user, atomUser1, stamp, stamp + 1);
        // false
        boolean b2 = atomUserAtomicStampedReference.compareAndSet(user, atomUser2, stamp, stamp + 1);
        AtomUser reference = atomUserAtomicStampedReference.getReference();
        System.out.println(reference);
    }

    @Test
    void atomicMarkableReference() {
        AtomUser user = new AtomUser("你的名字");
        Boolean initialBool = Boolean.FALSE;
        AtomicMarkableReference<AtomUser> atomicMarkableReference = new AtomicMarkableReference<>(user, initialBool);
        AtomUser user1 = new AtomUser("新名字1");
        AtomUser user2 = new AtomUser("新名字2");
        AtomUser user3 = new AtomUser("新名字3");

        // 期望值相等，期望mark相等
        boolean b = atomicMarkableReference.compareAndSet(user, user1, initialBool, initialBool);

        // 期望值相等，mark相等
        boolean b1 = atomicMarkableReference.compareAndSet(user1, user2, Boolean.FALSE, Boolean.TRUE);

        // 期望值相等，mark相等
        boolean b2 = atomicMarkableReference.compareAndSet(user1, user3, Boolean.TRUE, Boolean.FALSE);

    }

}
