package gr.bytecode.multibaserest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Entry point to the Spring App
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "gr.bytecode.multibaserest.rest")
public class App {

    /**
     * description
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
