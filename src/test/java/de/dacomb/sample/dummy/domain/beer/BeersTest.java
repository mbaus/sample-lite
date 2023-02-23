package de.dacomb.sample.dummy.domain.beer;

import static de.dacomb.sample.dummy.domain.BeersIdentityFixture.*;
import static de.dacomb.sample.dummy.domain.beer.BeersFixture.*;
import static org.assertj.core.api.Assertions.*;

import de.dacomb.sample.UnitTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class BeersTest {

  @Test
  void shouldSortBeersByNames() {
    Beer anteMeridiem = Beer
      .builder()
      .id(anteMeridiemId())
      .name(new BeerName("Ante Meridiem"))
      .unitPrice(anteMeridiemUnitPrice())
      .sellingState(BeerSellingState.SOLD)
      .build();

    Beers beers = new Beers(List.of(beer(), anteMeridiem));

    assertThat(beers.get()).usingRecursiveFieldByFieldElementComparator().containsExactly(anteMeridiem, beer());
  }
}
