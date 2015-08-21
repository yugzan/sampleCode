package spring.security.boot.mongodb.domain;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author teddy
 *
 */
@Document(collection = "users")
public class Account {

  public static final String USERNAME = "username";
  public static final String PASSWORD = "password";
  public static final String ROLES = "roles";
  
  private String username;
  private String password;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;
  private boolean enabled;

  private List<String> roles;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public List<String> getRoles() {
    return roles;
  }

  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public String toString() {
      return new ToStringBuilder(this)
        .append("username", username)
        .append("password", password)
        .append("roles", roles)
        .append("accountNonExpired", accountNonExpired)
        .append("accountNonLocked", accountNonLocked)
        .append("credentialsNonExpired", credentialsNonExpired)
        .append("enabled", enabled)
        .toString();
  }

}
