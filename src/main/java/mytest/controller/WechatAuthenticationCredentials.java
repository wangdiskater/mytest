package mytest.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.security.authentication.AuthenticationRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Introspected
@JsonIgnoreProperties(ignoreUnknown = true)
public class WechatAuthenticationCredentials implements AuthenticationRequest<String, String> {

    @NotBlank
    @NotNull
    private String credential;
    private String account;
    private String password;
    private String type;

    // 兼容dotnet需要带上角色信息
    @JsonIgnore
    private String jwtData;

    private String publicId;

    private String openId;

    private Integer userId;


    public String getCredential() {
        return credential;
    }



    public void setCredential(String credential) {
        this.credential = credential;
    }

    @Override
    public String getIdentity() {
        return credential;
    }

    @Override
    public String getSecret() {
        return null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccount(String account){
        this.account=account;
    }
    public String getAccount(){
        return account;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword(){
        return password;
    }

    public String getJwtData() {
        return jwtData;
    }

    public void setJwtData(String jwtData) {
        this.jwtData = jwtData;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
