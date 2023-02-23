package de.dacomb.sample.account.domain;

public interface TokensRepository {
  Token buildToken(AuthenticationQuery query);
}
