package xmg.spring.boot.samples.chapter5.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xmg.spring.boot.samples.chapter5.config.WebConfiguration;


public class FirstAppByGuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebConfiguration.class);
    }

}
