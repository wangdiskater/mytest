package mytest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import mytest.baidu.BaiduClient;
import mytest.repository.BaseDAO;
import mytest.repository.BookDAO;
import mytest.repository.WriterDAO;
import mytest.repository.WriterRepository;
import mytest.service.IBookService;
import mytest.utils.encode.RSAHelper;
import net.minidev.json.JSONUtil;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @ClassName WriterController
 * @Author wangDi
 * @date 2021-03-23 16:31
 */
@Controller
@Secured(SecurityRule.IS_ANONYMOUS)
public class WriterController {
    @Inject
    WriterRepository writerRepository;
    @Inject
    IBookService iBookService;
    @Inject
    BaiduClient baiduClient;

    @Get("/writer")
    HttpResponse getWriter(@QueryValue Long id) {
        Optional<WriterDAO> writerOpt = writerRepository.findById(id);
        WriterDAO writerDAO = writerOpt.get();
        String writerName = writerDAO.getWriterName();
        writerDAO.setWriterName(RSAHelper.decipher(writerName, RSAHelper.PRIVATE_KEY_VALUES));


        return HttpResponse.ok(writerOpt);
    }


    @Get("/book")
    HttpResponse saveBook(){
        BookDAO bookDAO = null;
        try {
            bookDAO = iBookService.saveBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResponse.ok(Optional.ofNullable(bookDAO).orElse(new BookDAO("《论抛出异常的艺术》")));
    }


    @Post("/writer")
    HttpResponse postWriter() {
        WriterDAO writerDAO = new WriterDAO();
        String value = "你是猪吗2?";
        String encipher = RSAHelper.encipher(value, RSAHelper.PUBLIC_KEY_VALUES);
        writerDAO.setBookId(1);
        writerDAO.setWriterName(encipher);
        WriterDAO save = writerRepository.save(writerDAO);

        return HttpResponse.ok(save);
    }

}
