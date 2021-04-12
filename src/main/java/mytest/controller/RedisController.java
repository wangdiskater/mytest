package mytest.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import mytest.utils.RedisUtils;

import javax.inject.Inject;

/**
 * @Description
 * @ClassName RedisControler
 * @Author wangDi
 * @date 2021-03-31 15:43
 */


@Controller("/redis")
@Secured(SecurityRule.IS_ANONYMOUS)
public class RedisController {

    @Inject
    RedisUtils redisUtils;

    @Get
    HttpResponse redis(@QueryValue String tranId) {

        boolean lock = redisUtils.getLock(tranId);
        redisUtils.delLock(tranId);



        boolean lock1 = redisUtils.getLock(tranId);
        redisUtils.delLock(tranId);

        System.out.println(lock);
        System.out.println(lock1);

        return HttpResponse.ok();
    }


}
