package gr.bytecode.multibaserest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Entry point to the Spring App
 */
@Configuration
@ComponentScan
// @EnableAutoConfiguration(exclude = {RepositoryRestMvcAutoConfiguration.class})
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
