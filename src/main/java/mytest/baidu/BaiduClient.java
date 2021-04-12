package mytest.baidu;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import java.util.List;


/**
 * @Description
 * @ClassName BaiduClient
 * @Author wangDi
 * @date 2021-04-02 14:12
 */
@Client("https://dwz.cn")
@Header(name = "Dwz-Token", value = "0d1052d3712bfd0b9c52a4976da1ee1e")
@Header(name = "Content-Type", value = "application/json")
public interface BaiduClient {

    class ShortUrlParam {
        @JsonProperty(value = "LongUrl")
        private String longUrl;

        @JsonProperty(value = "TermOfValidity")
        private String termOfValidity;

        public ShortUrlParam() {
        }

        public ShortUrlParam(String longUrl, String termOfValidity) {
            this.longUrl = longUrl;
            this.termOfValidity = termOfValidity;
        }

        public String getLongUrl() {
            return longUrl;
        }

        public void setLongUrl(String longUrl) {
            this.longUrl = longUrl;
        }

        public String getTermOfValidity() {
            return termOfValidity;
        }

        public void setTermOfValidity(String termOfValidity) {
            this.termOfValidity = termOfValidity;
        }
    }

    @Post(value = "/api/v3/short-urls", produces = MediaType.APPLICATION_JSON)
    HttpResponse getShortUrl(@Body List<BaiduClient.ShortUrlParam> shortUrls);

}
