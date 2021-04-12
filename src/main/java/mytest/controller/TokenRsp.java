package mytest.controller;

public class TokenRsp {
    private String publidId;
    private String openId;
    private String userId;

    public TokenRsp() {
    }

    public String getPublidId() {
        return publidId;
    }

    public void setPublidId(String publidId) {
        this.publidId = publidId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
