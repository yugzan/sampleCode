package spring.security.boot.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.net.UnknownHostException;


@EnableAutoConfiguration
@ComponentScan("spring.security.boot.mongodb")
public class App {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(App.class, args);
  }
}
