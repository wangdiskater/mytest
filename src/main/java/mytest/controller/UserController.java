package mytest.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller("/user")
@Secured(SecurityRule.IS_ANONYMOUS)
public class UserController {

    @Get()
    HttpResponse get(){
        return HttpResponse.ok("user");
    }
}
