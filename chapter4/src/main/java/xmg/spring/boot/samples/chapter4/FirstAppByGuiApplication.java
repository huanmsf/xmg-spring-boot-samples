package xmg.spring.boot.samples.chapter4;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class FirstAppByGuiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstAppByGuiApplication.class);
    }

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
    public ApplicationRunner applicationRunner(WebServerApplicationContext context) {
        return args -> {
            System.out.println("当前 WebServer 实现类：" +
                    context.getWebServer().getClass().getName() +
                    " ,port:" + context.getWebServer().getPort());
        };
    }

    /**
     * EventListener 获取 当前 WebServer 实现类
     */
    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerRready(WebServerInitializedEvent event) {
        System.out.println("EventListener 获取 当前 WebServer 实现类：" +
                event.getWebServer().getClass().getName() +
                " ,port:" + event.getWebServer().getPort());
    }
}
