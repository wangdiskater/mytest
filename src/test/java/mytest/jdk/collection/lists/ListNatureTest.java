package mytest.jdk.collection.lists;

/**
 * @Description 考虑增删改查
 * @ClassName ListNatureTest
 * @Author wangDi
 * @date 2021-05-17 12:36
 */
import org.junit.jupiter.api.Test;

public class ListNatureTest {

    /**
     * 测试插入头尾
     * 头尾插入 arrayList 耗时多
     */
    @Test
    public void testAdd() {
        int[] testCount = {10000, 50000,100000};
        ListNature natureTest = new ListNature();
        for (int i : testCount) {
            natureTest.testAddFirstAndLast(i);
        }
    }

    /**
     * 随机插入 arrayList 耗时比 linkedList少
     */
    @Test
    public void testInsert() {
        int[] testCount = {10000, 50000,100000};
        int[] listSize = {10000, 50000,100000};
        ListNature natureTest = new ListNature();
        for (int i : testCount) {
            for (int j : listSize) {
                natureTest.testInsertRandom(j, i);
            }
        }
    }

    /**
     *  元素删除
     *
     */
    @Test
    public void testRemove() {
        int[] testCount = {10000, 50000};
        int[] listSize = {100000,200000};
        ListNature natureTest = new ListNature();
        for (int i : testCount) {
            for (int j : listSize) {
                natureTest.testRemoveRandom(j, i);
            }
        }
    }

    /**
     * 比较LinkedList/ArrayList 10W 添加1W个  10W  删除1W个
     *
     */
    @Test
    void testLinkedList() {
        int listSize = 100000;
        int testSize = 1000;
        ListNature natureTest = new ListNature();

        natureTest.testInsertRandom(listSize,testSize);

        natureTest.testRemoveRandom(listSize,testSize);


    }


    /**
     * 测试向前向后复制的时间差值
     * 经过测试：确实向后复制要比向前复制要慢很多。
     *
     */
    @Test
    void testSystemCopy(){
        int listSize = 100000;
        int haveValueSize = 90000;
        ListNature natureTest = new ListNature();
        natureTest.testSystemCopy(listSize,haveValueSize);
    }




    @Test
    public void testGet() {
        int[] testCount = {10000, 50000,100000};
        int[] listSize = {10000, 50000,100000};
        ListNature natureTest = new ListNature();
        for (int i : testCount) {
            for (int j : listSize) {
                natureTest.testGetRandom(j, i);
            }
        }
    }

    @Test
    public void testReplace() {
        int[] testCount = {10000, 50000,100000};
        int[] listSize = {10000, 50000,100000};
        ListNature natureTest = new ListNature();
        for (int i : testCount) {
            for (int j : listSize) {
                natureTest.testReplaceRandom(j, i);
            }
        }
    }


}