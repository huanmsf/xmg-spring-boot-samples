package xmg.spring.boot.samples.chapter5.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class WebConfiguration {
    /**
     * webflux
     */
    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return route(GET("/hello"), request -> ok().body(Mono.just("Hello World"), String.class));
    }

    /**
     * 输出 WebServer 实现类
     */
    @Bean
    public ApplicationRunner applicationRunner(BeanFactory beanFactory) {
        return args -> {
            System.out.println("当前 helloWorld Bean 实现类：" +
                    beanFactory.getBean("helloWorld").getClass().getName());

            System.out.println("当前 WebConfiguration Bean 实现类：" +
                    beanFactory.getBean(WebConfiguration.class).getClass().getName());
        };
    }
}
