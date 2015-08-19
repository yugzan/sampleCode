
package spring.security.boot.mongodb.security;


import java.util.Optional;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.security.boot.mongodb.domain.Client;

/**
 * @author teddy
 *
 */

@Service
public class MongoDBUserDetailsService implements UserDetailsService {


  @Autowired
  private MongoCollection users;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserDetails> loadedUser;

    try {
      Client client = users.findOne("{#: #}", Client.USERNAME, username).as(Client.class);
      loadedUser =
          Optional.of(new User(client.getUsername(), client.getPassword(), client.getRoles()));
      if (!loadedUser.isPresent()) {
        throw new InternalAuthenticationServiceException(
            "UserDetailsService returned null, which is an interface contract violation");
      }
    } catch (Exception repositoryProblem) {
      throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(),
          repositoryProblem);
    }


    return loadedUser.get();
  }
}
