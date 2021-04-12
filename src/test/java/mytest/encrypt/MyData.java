package mytest.encrypt;

import java.util.List;

/**
 * @Description
 * @ClassName MyData
 * @Author wangDi
 * @date 2021-04-12 15:02
 */
public class MyData {
    private String data;
    private String encryptkey;

    public MyData() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEncryptkey() {
        return encryptkey;
    }

    public void setEncryptkey(String encryptkey) {
        this.encryptkey = encryptkey;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "data='" + data + '\'' +
                ", encryptkey='" + encryptkey + '\'' +
                '}';
    }
}
