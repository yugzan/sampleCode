/*
 * *
 * * Copyright (c) 2015 Ivan Hristov * <p/> * Licensed under the Apache License, Version 2.0 (the
 * "License"); * you may not use this file except in compliance with the License. * You may obtain a
 * copy of the License at * <p/> * http://www.apache.org/licenses/LICENSE-2.0 * <p/> * Unless
 * required by applicable law or agreed to in writing, software * distributed under the License is
 * distributed on an "AS IS" BASIS, * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. * See the License for the specific language governing permissions and * limitations
 * under the License.
 */

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
