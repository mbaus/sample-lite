package de.dacomb.sample.dummy.infrastructure.primary.beer;

import static org.assertj.core.api.Assertions.*;

import de.dacomb.sample.JsonHelper;
import de.dacomb.sample.UnitTest;
import de.dacomb.sample.dummy.domain.beer.Beers;
import de.dacomb.sample.dummy.domain.beer.BeersFixture;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class RestBeersTest {

  @Test
  void shouldSerializeToJson() {
    assertThat(JsonHelper.writeAsString(RestBeers.from(new Beers(List.of(BeersFixture.beer()))))).isEqualTo(json());
  }

  private String json() {
    return "{\"beers\":[" + RestBeerTest.json() + "]}";
  }
}
