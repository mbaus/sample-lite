package de.dacomb.sample.dummy.domain;

import de.dacomb.sample.error.domain.Assert;
import java.util.UUID;

public record BeerId(UUID id) {
  public BeerId {
    Assert.notNull("id", id);
  }

  public static BeerId newId() {
    return new BeerId(UUID.randomUUID());
  }

  public UUID get() {
    return id();
  }
}
