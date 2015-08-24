package spring.security.boot.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.security.boot.mongodb.domain.Account;
import spring.security.boot.mongodb.repo.AccountRepository;

/**
 * @author teddy
 *
 */

@RestController
public class ResourceController {

  @Autowired
  private AccountRepository accountRepo;

  @Secured({"ROLE_ADMIN"})
  @RequestMapping("/resource")
  public Account home(@AuthenticationPrincipal UserDetails userDetails) {
    return accountRepo.findByUsername(userDetails.getUsername());
  }
}
