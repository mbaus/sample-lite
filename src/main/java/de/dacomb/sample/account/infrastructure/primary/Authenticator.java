package de.dacomb.sample.account.infrastructure.primary;

import de.dacomb.sample.account.application.AccountApplicationService;
import de.dacomb.sample.account.domain.Token;
import de.dacomb.sample.authentication.infrastructure.primary.AuthenticatedUser;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
class Authenticator {

  private final AccountApplicationService accounts;
  private final AuthenticationManagerBuilder authenticationManagerBuilder;

  public Authenticator(AccountApplicationService accounts, AuthenticationManagerBuilder authenticationManagerBuilder) {
    this.accounts = accounts;
    this.authenticationManagerBuilder = authenticationManagerBuilder;
  }

  Token authenticate(RestAuthenticationQuery query) {
    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(query.authenticationToken());

    SecurityContextHolder.getContext().setAuthentication(authentication);

    return accounts.createToken(query.toDomain(AuthenticatedUser.roles()));
  }
}