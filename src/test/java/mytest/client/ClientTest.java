package mytest.client;

import io.micronaut.test.annotation.MicronautTest;
import mytest.baidu.BaiduClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

/**
 * @Description
 * @ClassName ClientTest
 * @Author wangDi
 * @date 2021-04-02 14:37
 */
@MicronautTest
public class ClientTest {

    @Inject
    BaiduClient baiduClient;

/*    @Test
    void test(){
        String url = "https://web.wechat.yaeherhealth.com/#/doctor-detail-patient?id=2214";
        String shortUrl2 = getShortUrl2(url);
    }

    private String getShortUrl2(String longUrl) {
        String token = "0d1052d3712bfd0b9c52a4976da1ee1e";
        BaiduClient.ShortUrlParam shortUrlParam = new BaiduClient.ShortUrlParam(longUrl, "long-term");
        BaiduClient.ShortUrlParam[] shortUrlParams = new BaiduClient.ShortUrlParam[]{shortUrlParam};
        String shortUrl = baiduClient.getShortUrl(token, shortUrlParams);

        return shortUrl;
    }*/
}
