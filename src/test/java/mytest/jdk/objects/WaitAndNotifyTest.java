package mytest.jdk.objects;

/**
 * @Description
 * @ClassName WaitTest
 * @Author wangDi
 * @date 2021-04-26 15:58
 */
public class WaitAndNotifyTest {
    public static void main(String[] args) {
        new Thread(() -> {
            Son son = new Son();
            try {
                son.sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Mother mother = new Mother();
        mother.wakeUpSon();
    }
    static class Son {
        public void sleep() throws InterruptedException {
            synchronized (Room.class) {
                System.out.println("困死了，睡会");
                Room.class.wait();
            }
            System.out.println("被妈（han）妈（pi）叫醒了");
        }
    }

    static class Mother {
        void wakeUpSon() {
            synchronized (Room.class) {
                Room.class.notifyAll();
            }
        }
    }
}
