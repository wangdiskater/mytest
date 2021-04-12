package mytest;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.context.event.HttpRequestReceivedEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private final Logger sLog = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }


    @EventListener
    void logRequest(HttpRequestReceivedEvent event) {
        HttpRequest<?> request = event.getSource();
        sLog.info("request: {} {}", request.getMethod(), request.getUri());
    }
}