package ua.com.goevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "ua.com.goevent")
@EnableJpaRepositories(basePackages = { "ua.com.goevent.repository" })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
