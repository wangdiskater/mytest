package mytest.jdk.collection.lists;

/**
 * @Description
 * @ClassName ListNature
 * @Author wangDi
 * @date 2021-05-17 12:35
 */

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class ListNature {

    private static Logger logger = LoggerFactory.getLogger(ListNature.class);

    /**
     * @param listSize
     * @param removeCount
     */
    public void testRemoveRandom(int listSize, int removeCount) {
        if (listSize < removeCount) {
            throw new IllegalArgumentException("removeCount需要小于listSize");
        }
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        testAddLast(arrayList, listSize);
        System.gc();
        long arrayRemove = testRemoveRandom(arrayList, removeCount);
        arrayList.clear();
        System.gc();
        testAddLast(linkedList, listSize);
        System.gc();
        long linkedRemove = testRemoveRandom(linkedList, removeCount);
        linkedList.clear();
        System.gc();

        logger.debug("于{}集合数据量下，{}次测试Array与LinkedList测试随机删除，结果如下：===", listSize, removeCount);
        logger.debug("ArrayList：耗时{}", arrayRemove);
        logger.debug("LinkedList：耗时{}", linkedRemove);

    }

    /**
     * @param listSize
     * @param replaceCount
     */
    public void testReplaceRandom(int listSize, int replaceCount) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        testAddLast(arrayList, listSize);
        long arrayReplace = testReplaceRandom(arrayList, replaceCount);
        arrayList.clear();
        System.gc();
        testAddLast(linkedList, listSize);
        long linkedReplace = testReplaceRandom(linkedList, replaceCount);
        linkedList.clear();
        System.gc();

        logger.debug("于{}集合数据量下，{}次测试Array与LinkedList测试随机替换，结果如下：===", listSize, replaceCount);
        logger.debug("ArrayList：耗时{}", arrayReplace);
        logger.debug("LinkedList：耗时{}", linkedReplace);
    }

    /**
     * 测试ArrayList和LinkedList集合随机获取数据的效率
     *
     * @param listSize 集合原始容量
     * @param getCount 获取次数
     */
    public void testGetRandom(int listSize, int getCount) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        testAddLast(arrayList, listSize);
        long arrayGet = testGetRandom(arrayList, getCount);
        arrayList.clear();
        System.gc();
        testAddLast(linkedList, listSize);
        long linkedGet = testGetRandom(linkedList, getCount);
        linkedList.clear();
        System.gc();

        logger.debug("于{}集合数据量下，{}次测试Array与LinkedList测试随机获取，结果如下：===", listSize, getCount);
        logger.debug("ArrayList：耗时{}", arrayGet);
        logger.debug("LinkedList：耗时{}", linkedGet);
    }

    /**
     * 测试ArrayList和LinkedList集合中随机插入数据的效率
     *
     * @param listSize    数组原始容量
     * @param insertCount 插入次数
     */
    public void testInsertRandom(int listSize, int insertCount) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        testAddLast(arrayList, listSize);
        long arrayInsert = testInsertRandom(arrayList, insertCount);
        arrayList.clear();
        System.gc();
        testAddLast(linkedList, listSize);
        long linkedInsert = testInsertRandom(linkedList, insertCount);
        linkedList.clear();
        System.gc();

        logger.debug("于{}集合数据量下，{}次测试Array与LinkedList测试随机添加，结果如下：===", listSize, insertCount);
        logger.debug("ArrayList：耗时{}", arrayInsert);
        logger.debug("LinkedList：耗时{}", linkedInsert);
    }

    /**
     * 测试ArrayList和LinkedList集合中首尾插入数据的效率
     *
     * @param addCount 插入次数
     */
    public void testAddFirstAndLast(int addCount) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        long arrayListAddFirst = testAddFirst(arrayList, addCount);
        System.gc();
        long arrayListAddLast = testAddLast(arrayList, addCount);
        arrayList.clear();
        System.gc();
        long linkedListAddFirst = testAddFirst(linkedList, addCount);
        System.gc();
        long linkedListAddLast = testAddLast(linkedList, addCount);
        linkedList.clear();
        System.gc();

        logger.debug("{}次测试Array与LinkedList测试头尾添加，结果如下：===", addCount);
        logger.debug("ArrayList： 头部添加耗时: {} ms,  尾部添加耗时 {} ms", arrayListAddFirst, arrayListAddLast);
        logger.debug("LinkedList：头部添加耗时: {} ms,  尾部添加耗时 {} ms", linkedListAddFirst, linkedListAddLast);
    }


    /**
     * 测试向前移和向后移耗时
     *
     * @param listSize
     * @param haveValueSize
     */
    public void testSystemCopy(int listSize, int haveValueSize) {
        int[] randomArray1 = getRandomArray2(listSize, haveValueSize);
        int[] randomArray2 = getRandomArray2(listSize, haveValueSize);
        long systemCopyAdd = testSystemCopyAdd(randomArray1, haveValueSize, 1000);
        long systemCopyMinus = testSystemCopyMinus(randomArray2, haveValueSize, 1000);
        logger.debug("ArrayList： systemCopyAdd耗时: {} ms, systemCopyMinus耗时 {} ms", systemCopyAdd, systemCopyMinus);
    }


    private long testSystemCopyMinus(int[] elementData, int haveValueSize, int count) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int size = haveValueSize;
            int index = RandomUtils.nextInt(0, size);
            final int newSize = size - 1;
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }


    private long testSystemCopyAdd(int[] elementData, int haveValueSize, int count) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int size = haveValueSize;
            int index = RandomUtils.nextInt(0, size);
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
        }
        long time2 = System.currentTimeMillis();
        return time2 - time1;
    }


    private long testAddFirst(List list, int addCount) {
        int[] array = getRandomArray(addCount);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < addCount; i++) {
            list.add(0, array[i]);
        }
        long time2 = System.currentTimeMillis();
        long interval = time2 - time1;
        return interval;
    }


    private long testAddLast(List list, int addCount) {
        int[] array = getRandomArray(addCount);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < addCount; i++) {
            list.add(array[i]);
        }
        long time2 = System.currentTimeMillis();
        long interval = time2 - time1;
        return interval;
    }

    private long testInsertRandom(List list, int insertCount) {
        int[] array = getRandomArray(insertCount, list.size());
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < insertCount; i++) {
            list.add(array[i], array[i]);
        }
        long time2 = System.currentTimeMillis();
        long interval = time2 - time1;
        return interval;
    }

    private long testReplaceRandom(List list, int replaceCount) {
        int[] array = getRandomArray(replaceCount, list.size());
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < replaceCount; i++) {
            list.set(array[i], array[i]);
        }
        long time2 = System.currentTimeMillis();
        long interval = time2 - time1;
        return interval;
    }

    private long testGetRandom(List list, int getCount) {
        int[] array = getRandomArray(getCount, list.size());
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < getCount; i++) {
            list.get(array[i]);
        }
        long time2 = System.currentTimeMillis();
        long interval = time2 - time1;
        return interval;
    }

    private long testRemoveRandom(List list, int removeCount) {
        int[] array = getRandomArray(removeCount, list.size() / 100);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < removeCount; i++) {
            list.remove(array[i]);
        }
        long time2 = System.currentTimeMillis();
        long interval = time2 - time1;
        return interval;
    }


    private int[] getRandomArray(int count) {
        int[] ints = new int[count];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = RandomUtils.nextInt();

        }
        return ints;
    }

    private int[] getRandomArray(int count, int randomRange) {
        int[] ints = new int[count];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = RandomUtils.nextInt(0, randomRange);
        }
        return ints;
    }

    /**
     * 前半部分有数据，后面没有
     *
     * @param listSize
     * @param haveValueSize
     * @return
     */
    private int[] getRandomArray2(int listSize, int haveValueSize) {
        int[] ints = new int[listSize];
        for (int i = 0; i < haveValueSize; i++) {
            ints[i] = RandomUtils.nextInt();
        }
        return ints;
    }
}