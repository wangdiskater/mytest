package mytest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Singleton
public class WechatAuthenticationProvider implements AuthenticationProvider {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WechatAuthenticationProvider.class);


    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        return Flowable.just(generateUserDetailsAddRole(authenticationRequest));
    }

    private UserDetails generateUserDetailsAddRole(AuthenticationRequest authenticationRequest) {
        WechatAuthenticationCredentials wechatAuthenticationCredentials = (WechatAuthenticationCredentials) authenticationRequest;
        Map<String, Object> attributes = new HashMap<>();
        String type = wechatAuthenticationCredentials.getType();
        UserDetails userDetails = null;
        if ("new".equals(type)) {
            String publicId = wechatAuthenticationCredentials.getPublicId();
            userDetails = new UserDetails(publicId, Collections.emptyList(), attributes);
        } else if ("old".equals(type)) {
            String openId = wechatAuthenticationCredentials.getOpenId();
            Integer userId = wechatAuthenticationCredentials.getUserId();
            attributes.put("openId", openId);
            userDetails = new UserDetails(userId.toString(), Collections.emptyList(), attributes);
        } else {
            userDetails = new UserDetails("smlz", Collections.emptyList(), attributes);

        }

        return userDetails;
    }
}
