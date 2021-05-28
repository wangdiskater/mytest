package mytest.jdk.thread.safe;

/**
 * @Description
 * @ClassName ThreadSafe
 * @Author wangDi
 * @date 2021-05-28 10:51
 */
public class ThreadSafe {
    private int i = 0;

    public void write(int j) {
        i = j;
    }

    public int read(){
        return i;
    }

}
