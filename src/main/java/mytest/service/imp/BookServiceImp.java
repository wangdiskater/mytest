package mytest.service.imp;

import mytest.repository.BookDAO;
import mytest.repository.BookRepository;
import mytest.repository.WriterRepository;
import mytest.service.IBookService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Description
 * @ClassName BookService
 * @Author wangDi
 * @date 2021-03-23 17:41
 */
@Singleton
public class BookServiceImp implements IBookService {

    WriterRepository writerRepository;
    @Inject
    BookRepository bookRepository;


    @Override
    @Transactional(rollbackOn = Exception.class)
//    @Transactional(Transactional.TxType.NEVER)
    public BookDAO saveBook() throws Exception {
        BookDAO bookDAO = new BookDAO();
        bookDAO.setTitle("算法导论");
        bookDAO.setPages(100L);
        bookDAO.setPageId(2L);
        BookDAO save = bookRepository.save(bookDAO);


        bookRepository.update(save);
        if (save != null) {

            throw new ClassNotFoundException("憨批");
        } else {
            return save;
        }
    }
}
