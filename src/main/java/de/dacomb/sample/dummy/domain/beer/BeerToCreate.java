package de.dacomb.sample.dummy.domain.beer;

import de.dacomb.sample.dummy.domain.Amount;
import de.dacomb.sample.dummy.domain.BeerId;
import de.dacomb.sample.error.domain.Assert;

public record BeerToCreate(BeerName name, Amount unitPrice) {
  public BeerToCreate {
    Assert.notNull("name", name);
    Assert.notNull("unitPrice", unitPrice);
  }

  public Beer create() {
    return Beer.builder().id(BeerId.newId()).name(name()).unitPrice(unitPrice()).sellingState(BeerSellingState.SOLD).build();
  }
}
