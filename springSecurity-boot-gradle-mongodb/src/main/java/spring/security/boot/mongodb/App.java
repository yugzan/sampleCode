package spring.security.boot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author teddy
 *
 */

@EnableAutoConfiguration
@ComponentScan("spring.security.boot.mongodb")
public class App {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(App.class, args);
  }
}
