package mytest.controller;

import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.*;
import io.micronaut.security.event.LoginFailedEvent;
import io.micronaut.security.event.LoginSuccessfulEvent;
import io.micronaut.security.handlers.LoginHandler;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.utils.SecurityService;
import io.reactivex.Flowable;
import io.reactivex.Single;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

@Controller("/token")
@Secured(SecurityRule.IS_ANONYMOUS)
public class TokenController {
    protected final Authenticator authenticator;
    protected final LoginHandler loginHandler;
    protected final ApplicationEventPublisher eventPublisher;

    public TokenController(Authenticator authenticator, LoginHandler loginHandler, ApplicationEventPublisher eventPublisher) {
        this.authenticator = authenticator;
        this.loginHandler = loginHandler;
        this.eventPublisher = eventPublisher;
    }

    @Inject
    SecurityService securityService;

    @Post("/create")
    Single<HttpResponse> getToken(@Body WechatAuthenticationCredentials authenticationCredentials, HttpRequest<?> request) {
        return doAuthentication(authenticationCredentials, request);

    }

    @Get("/getInfo")
    HttpResponse getInfo(@QueryValue String type) {
        Optional<Authentication> authenticationO = securityService.getAuthentication();
        if (!authenticationO.isPresent()) {
            return HttpResponse.ok();
        }
        if ("new".equals(type)) {
            String name = authenticationO.get().getName();
            TokenRsp tokenRsp = new TokenRsp();
            tokenRsp.setPublidId(name);
            return HttpResponse.ok(tokenRsp);
        } else if ("old".equals(type)) {
            Authentication authentication = authenticationO.get();
            String UserId = authentication.getName();
            Map<String, Object> attributes = authentication.getAttributes();
            String openId = (String) attributes.get("openId");
            TokenRsp tokenRsp = new TokenRsp();
            tokenRsp.setUserId(UserId);
            tokenRsp.setOpenId(openId);
            return HttpResponse.ok(tokenRsp);

        }
        return HttpResponse.ok("smlz");
    }


    private Single<HttpResponse> doAuthentication(AuthenticationRequest authenticationRequest, HttpRequest<?> request){
        Flowable<AuthenticationResponse> authenticationResponseFlowable = Flowable.fromPublisher(authenticator.authenticate(authenticationRequest));

        return authenticationResponseFlowable.map(authenticationResponse -> {
            if (authenticationResponse.isAuthenticated()) {
                UserDetails userDetails = (UserDetails) authenticationResponse;
                eventPublisher.publishEvent(new LoginSuccessfulEvent(userDetails));
                return loginHandler.loginSuccess(userDetails, request);
            } else {
                AuthenticationFailed authenticationFailed = (AuthenticationFailed) authenticationResponse;
                eventPublisher.publishEvent(new LoginFailedEvent(authenticationFailed));
                if(authenticationFailed.getReason() == AuthenticationFailureReason.ACCOUNT_EXPIRED){
                    return HttpResponse.status(HttpStatus.PAYMENT_REQUIRED);
                }else{
                    return HttpResponse.status(HttpStatus.UNAUTHORIZED);
                }
            }
        }).first(HttpResponse.status(HttpStatus.UNAUTHORIZED));
    }

}
