package de.dacomb.sample.account.application;

import de.dacomb.sample.account.domain.AuthenticationQuery;
import de.dacomb.sample.account.domain.Token;
import de.dacomb.sample.account.domain.TokensRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountApplicationService {

  private final TokensRepository tokens;

  public AccountApplicationService(TokensRepository tokens) {
    this.tokens = tokens;
  }

  public Token createToken(AuthenticationQuery query) {
    return tokens.buildToken(query);
  }
}
