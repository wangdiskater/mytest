package mytest.jdk.image;

import mytest.service.image.ImageUtils;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @Description
 * @ClassName DownloadTest
 * @Author wangDi
 * @date 2021-05-06 11:19
 */
public class DownloadTest {

    @Test
    void test() throws Exception {
        String substring = UUID.randomUUID().toString().substring(0, 5);

        String url = "https://yaeher-1257714652.cos.ap-guangzhou.myqcloud.com/idcard/image/idcardup/Applet20210426181333020161.png";

        ImageUtils.download(url,substring);


    }
}
