package mytest.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FastJsonTest {

    private static final ObjectMapper sObjectMapper = new ObjectMapper();
    private final Logger sLog = LoggerFactory.getLogger(this.getClass());


    @Test
    void test() {

        BeanTest beanTest = new BeanTest();
        BeanTestList beanTestList = new BeanTestList();
        SubBeanTest subBeanTest = new SubBeanTest();
        ArrayList<String> strings = new ArrayList<>();

        strings.add("test1");
        strings.add("test2");
        strings.add("test3");
        strings.add("test4");
        strings.add("test5");
        subBeanTest.setStrList(strings);
        beanTestList.setSubBeanTestList(List.of(subBeanTest));
        beanTest.setData(List.of(beanTestList));

        try {
            String s = sObjectMapper.writeValueAsString(beanTest);
            sLog.info(s);


            BeanTest beanTestCopy = sObjectMapper.readValue(s, BeanTest.class);

            sLog.info(beanTestCopy.toString());


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }




    }
}
