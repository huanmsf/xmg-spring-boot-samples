package xmg.spring.boot.samples.chapter6;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstAppByGuiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstAppByGuiApplication.class);
    }

    /**
     * 输出 WebServer 实现类
     */
    @Bean
    public ApplicationRunner applicationRunner(BeanFactory beanFactory) {
        return args -> {
            System.out.println("当前 WebConfiguration Bean 实现类：" +
                    beanFactory.getBean(FirstAppByGuiApplication.class).getClass().getName());
        };
    }
}
