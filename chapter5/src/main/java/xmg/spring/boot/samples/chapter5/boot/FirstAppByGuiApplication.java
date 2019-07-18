package xmg.spring.boot.samples.chapter5.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import xmg.spring.boot.samples.chapter5.config.WebConfiguration;

@EnableAutoConfiguration
public class FirstAppByGuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstAppByGuiApplication.class);
    }

}

