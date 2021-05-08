package mytest.jdk.enums;

/**
 * @Description
 * @ClassName Life
 * @Author wangDi
 * @date 2021-05-07 09:57
 */
public class Life {

    private Life lifeStatus;

    // 看起来好像是一个类里面可以有两个public类了，
    public enum LifeEnum {
        SLEEP,
        LEARN,
        PLAY,
        EAT;
    }


    public Life() {
    }

    public Life getLifeStatus() {
        return lifeStatus;
    }

    public void setLifeStatus(Life lifeStatus) {
        this.lifeStatus = lifeStatus;
    }
}
