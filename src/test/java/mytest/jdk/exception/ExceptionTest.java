package mytest.jdk.exception;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionTest {
    private final Logger sLog = LoggerFactory.getLogger(this.getClass());

    @Test
    void exceptionTest() {
        try {
            getThrowable();
        } catch (Throwable th) {
            sLog.info("出错了",th);
            return;
        }

    }

    private void getThrowable(){
        throw new RuntimeException();
    }
}
