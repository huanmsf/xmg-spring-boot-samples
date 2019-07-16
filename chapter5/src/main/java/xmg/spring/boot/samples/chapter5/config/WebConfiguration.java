package xmg.spring.boot.samples.chapter5.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@EnableAutoConfiguration
public class WebConfiguration {
    /**
     * webflux
     */
    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("/hello"), request -> ok().body(Mono.just("Hello World"), String.class));
    }
}
