package mytest.service.image;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Description
 * @ClassName ImageUtils
 * @Author wangDi
 * @date 2021-05-06 11:18
 */
public class ImageUtils {
    // 300K
    public static final Long LIMIT_FILE_SIZE = 1024*300L;

    //java 通过url下载图片保存到本地
    public static String download(String urlString, String i) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        String filename = "D:\\temp/" + i + ".jpg";  //下载路径及下载图片名称
        File file = new File(filename);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()){
            parentFile.mkdir();
        }

        FileOutputStream os = new FileOutputStream(file, true);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        System.out.println(i);
        // 完毕，关闭所有链接
        os.close();
        is.close();

        // 判断文件大小是否需要压缩
        // 字节数
        long length = file.length();

        if (LIMIT_FILE_SIZE < length) {

            BigDecimal divide = BigDecimal.valueOf(LIMIT_FILE_SIZE).divide(BigDecimal.valueOf(length),2, RoundingMode.HALF_UP);
            float outputQuality = divide.floatValue();

            // 需要压缩
            Thumbnails.of(file)
                    .scale(1f)
//                    .outputQuality(0.5f)
                    .outputQuality(outputQuality)
                    .allowOverwrite(Boolean.TRUE)
                    .toFile(file);
        }

        // 返回文件绝对路径名
        return filename;

    }
}
