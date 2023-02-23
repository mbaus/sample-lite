package de.dacomb.sample.account.infrastructure.primary;

import static de.dacomb.sample.account.domain.TokensFixture.*;
import static org.assertj.core.api.Assertions.*;

import de.dacomb.sample.JsonHelper;
import de.dacomb.sample.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RestTokenTest {

  @Test
  void shouldConvertFromDomain() {
    assertThat(JsonHelper.writeAsString(RestToken.from(token()))).isEqualTo(json());
  }

  private String json() {
    return "{\"id_token\":\"token\"}";
  }
}
