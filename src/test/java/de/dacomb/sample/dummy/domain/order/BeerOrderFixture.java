package de.dacomb.sample.dummy.domain.order;

import static de.dacomb.sample.dummy.domain.BeersIdentityFixture.*;

public class BeerOrderFixture {

  private BeerOrderFixture() {}

  public static BeerOrder beerOrder() {
    return BeerOrder.builder().add(orderedCloakOfFeather()).add(orderedCloakOfFeather()).add(orderedAnteMeridiem(), 3).build();
  }

  public static OrderedBeer orderedCloakOfFeather() {
    return new OrderedBeer(cloackOfFeathersId(), cloakOfFeatherUnitPrice());
  }

  public static OrderedBeer orderedAnteMeridiem() {
    return new OrderedBeer(cloackOfFeathersId(), anteMeridiemUnitPrice());
  }
}
