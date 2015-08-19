/**
 * 
 */
package spring.security.boot.mongodb.config;

import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * @author teddy
 *
 */

@Configuration
public class DbConfig {
  @Bean
  public Jongo jongo() {
    DB db;
    try {
      db = new MongoClient("127.0.0.1", 27017).getDB("test");
    } catch (UnknownHostException e) {
      throw new MongoException("Connection error : ", e);
    }
    return new Jongo(db);
  }

  @Bean
  public MongoCollection users() {
    return jongo().getCollection("users");
  }
}
