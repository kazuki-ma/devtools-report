package myapp;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    @Value("${spring.thymeleaf.cache:NOT_SET}")
    String value;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void log() {
        LoggerFactory.getLogger(getClass())
                     .error("spring.thymeleaf.cache = {}", value);

        System.exit(0);
    }
}
