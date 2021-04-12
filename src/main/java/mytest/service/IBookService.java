package mytest.service;

import mytest.repository.BookDAO;

import java.io.FileNotFoundException;

/**
 * @Description
 * @ClassName BookService
 * @Author wangDi
 * @date 2021-03-23 17:41
 */
public interface IBookService {
    BookDAO saveBook() throws Exception;
}
