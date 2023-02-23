package de.dacomb.sample.dummy.domain.order;

import de.dacomb.sample.dummy.domain.Amount;
import de.dacomb.sample.dummy.domain.BeerId;
import de.dacomb.sample.error.domain.Assert;

public record OrderedBeer(BeerId beer, Amount unitPrice) {
  public OrderedBeer {
    Assert.notNull("beer", beer);
    Assert.notNull("unitPrice", unitPrice);
  }
}
