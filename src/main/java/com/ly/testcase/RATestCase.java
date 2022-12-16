package com.ly.testcase;

import com.ly.api.BaseTestApiTestCase;
import com.ly.core.annotation.*;
import com.ly.core.parse.BaseModel;
import com.ly.core.parse.MultipleModel;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

/**
 * 测试RA
 */
@Story("登录模块接口")
public class RATestCase extends BaseTestApiTestCase {

 /*   @DataModel(value = {"login-not-found"},
            format = DataModel.Format.SINGLE,
            path = {"ra.yml"})
    @ApiBeforeClass
    public void beforeClass(BaseModel model) {
        System.out.println("===========beforeClass============: " + model);
    }

    @DataModel(value = {"login-not-found"},
            format = DataModel.Format.SINGLE,
            path = {"ra.yml"})
    @ApiBeforeMethod
    public void beforeMethod(BaseModel model) {
        System.out.println("===========beforeMethod============: " + model);
    }

    @DataModel(value = {"login-not-found"},
            format = DataModel.Format.SINGLE,
            path = {"ra.yml"})
    @ApiBeforeSuite
    public void beforeSuite(BaseModel model) {
        System.out.println("=============beforeSuite==========" + model);
    }

    @DataModel(value = {"login-not-found"},
            format = DataModel.Format.SINGLE,
            path = {"ra.yml"})
    @ApiAfterSuite
    public void afterSuite(BaseModel model) {
        System.out.println("=============afterSuite==========" + model);
    }

    @DataModel(value = {"login-not-found"},
            format = DataModel.Format.SINGLE,
            path = {"ra.yml"})
    @ApiAfterClass
    public void afterClass(BaseModel model) {
        System.out.println("=============afterClass==========" + model);
    }

    @DataModel(value = {"login-not-found"},
            format = DataModel.Format.SINGLE,
            path = {"ra.yml"})
    @ApiAfterMethod
    public void afterMethod(BaseModel model) {
        System.out.println("=============afterMethod==========" + model);
    }
*/


/*    @Severity(SeverityLevel.CRITICAL)
    @Description("获取code")
    @Test(groups = "ra-group-1")
    @DataModel(value = {"login-code"},
            format = DataModel.Format.SINGLE,
            path = {"ra.yml"})
    public void getCode(BaseModel model) {
        testApiClient.doHttp(model).auto();
    }*/

//    @Severity(SeverityLevel.CRITICAL)
//    @Description("用户登录")
//    @Test(groups = "ra-group-1")
//    @DataModel(value = {"login-not-found"},
//            format = DataModel.Format.SINGLE,
//            path = {"ra.yml"})
//    public void login(BaseModel model) {
//        testApiClient.doHttp(model).auto();
//    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("串行登录")
    @Test(groups = "ra-group-1")
    @DataModel(format = DataModel.Format.MULTIPLE, path = "ra.yml")
    public void test_login(MultipleModel model) {
        testApiClient.doHttp("login-code").auto();
        testApiClient.doHttp("login-not-found").auto();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("获取challenge值")
    @Test(groups = "ra-group-1")
    @DataModel(format = DataModel.Format.MULTIPLE, path = "ra.yml")
    public void test_mock_challenge(MultipleModel model) {
        testApiClient.doHttp("login-code").auto();
        testApiClient.doHttp("login-check").auto();
        testApiClient.doHttp("get-mock-challenge").auto();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("获取设备列表")
    @Test(groups = "ra-group-1")
    @DataModel(format = DataModel.Format.MULTIPLE, path = "ra.yml")
    public void getDeviceList(MultipleModel model) {
        testApiClient.doHttp("login-code").auto();
        testApiClient.doHttp("login-check").auto();
        testApiClient.doHttp("device-type-list").auto();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("获取证书号")
    @Test(groups = "ra-group-1")
    @DataModel(format = DataModel.Format.MULTIPLE, path = "ra.yml")
    public void makerCertSerial(MultipleModel model) {
        testApiClient.doHttp("login-code").auto();
        testApiClient.doHttp("login-check").auto();
        testApiClient.doHttp("maker-certSerial").auto();
    }


/*    @Severity(SeverityLevel.CRITICAL)
    @Description("获取司机信息")
    @Test(groups = "example")
    @DataModel(format = DataModel.Format.MULTIPLE, path = "example.yml")
    public void test(MultipleModel model) {
        testApiClient.doHttp("login-check").auto();

        testApiClient.doHttp("GetSeriesGames").auto();
    }*/
}
