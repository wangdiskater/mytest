package mytest.mysql;

import io.micronaut.test.annotation.MicronautTest;
import mytest.repository.BookDAO;
import mytest.repository.BookRepository;
import mytest.repository.WriterDAO;
import mytest.repository.WriterRepository;
import mytest.service.IBookService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Optional;

/**
 * @Description
 * @ClassName MysqlTest
 * @Author wangDi
 * @date 2021-03-23 16:25
 */
@MicronautTest
public class MysqlTest {

    @Inject
    WriterRepository writerRepository;
    @Inject
    BookRepository bookRepository;
    @Inject
    IBookService iBookService;


    @Test
    void test() {

        Long i = 1L;
        Optional<WriterDAO> byId = writerRepository.findById(i);
        System.out.println(byId.get());
    }


    @Test
//    @Transactional(rollbackOn = Exception.class)
    @Transactional()
    void test2() {

//        iBookService.saveBook();

        File file = new File("/abc.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }







}
