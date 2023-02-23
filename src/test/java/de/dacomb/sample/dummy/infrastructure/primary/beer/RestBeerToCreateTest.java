package de.dacomb.sample.dummy.infrastructure.primary.beer;

import static de.dacomb.sample.BeanValidationAssertions.*;
import static org.assertj.core.api.Assertions.*;

import de.dacomb.sample.UnitTest;
import de.dacomb.sample.JsonHelper;
import de.dacomb.sample.dummy.domain.beer.BeersFixture;
import org.junit.jupiter.api.Test;

@UnitTest
class RestBeerToCreateTest {

  @Test
  void shouldDeserializeFromJson() {
    assertThat(JsonHelper.readFromJson(json(), RestBeerToCreate.class).toDomain())
      .usingRecursiveComparison()
      .isEqualTo(BeersFixture.beerToCreate());
  }

  private String json() {
    return """
        {
          "name": "Cloak of feathers",
          "unitPrice": 8.53
        }
        """;
  }

  @Test
  void shouldNotValidateEmptyBean() {
    assertThatBean(new RestBeerToCreate(null, null)).hasInvalidProperty("name").and().hasInvalidProperty("unitPrice");
  }
}
