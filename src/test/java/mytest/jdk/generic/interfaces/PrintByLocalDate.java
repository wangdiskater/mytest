package mytest.jdk.generic.interfaces;

import java.time.LocalDate;

/**
 * @version 1.0
 * @ClassName PrintByLocalDate
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/3 15:21
 **/

public class PrintByLocalDate implements GenericInterface<LocalDate> {
    @Override
    public LocalDate printBirthday() {
        return LocalDate.of(1995,7,13);
    }
}
