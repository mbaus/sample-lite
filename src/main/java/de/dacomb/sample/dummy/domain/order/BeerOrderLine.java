package de.dacomb.sample.dummy.domain.order;

import de.dacomb.sample.dummy.domain.Amount;
import de.dacomb.sample.error.domain.Assert;

public record BeerOrderLine(OrderedBeer beer, int quantity) {
  public BeerOrderLine {
    Assert.notNull("beer", beer);
    Assert.field("quantity", quantity).min(1);
  }

  Amount amount() {
    return beer().unitPrice().times(quantity());
  }
}
