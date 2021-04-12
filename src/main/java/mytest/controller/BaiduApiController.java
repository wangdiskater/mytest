package mytest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import mytest.baidu.BaiduClient;
import mytest.repository.BookDAO;
import mytest.repository.WriterDAO;
import mytest.repository.WriterRepository;
import mytest.service.IBookService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @ClassName WriterController
 * @Author wangDi
 * @date 2021-03-23 16:31
 */
@Controller("/baidu")
@Secured(SecurityRule.IS_ANONYMOUS)
public class BaiduApiController {
    @Inject
    BaiduClient baiduClient;


    @Get("/shortUrl")
    HttpResponse shortUrl() {
        String token = "0d1052d3712bfd0b9c52a4976da1ee1e";
        BaiduClient.ShortUrlParam shortUrlParam = new BaiduClient.ShortUrlParam("https://web.wechat.yaeherhealth.com/#/doctor-detail-patient?id=2214", "long-term");
//        BaiduClient.ShortUrlParam[] shortUrlParams = new BaiduClient.ShortUrlParam[]{shortUrlParam};
        List<BaiduClient.ShortUrlParam> objects = new ArrayList<>();
        objects.add(shortUrlParam);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String objStr = objectMapper.writeValueAsString(objects);
            System.out.println(objStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpResponse shortUrl = baiduClient.getShortUrl(objects);
        return shortUrl;
    }

}
