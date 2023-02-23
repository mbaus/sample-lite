package de.dacomb.sample.dummy.domain.beer;

import de.dacomb.sample.dummy.domain.BeerId;
import java.util.Optional;

public interface BeersRepository {
  void save(Beer beer);

  Beers catalog();

  Optional<Beer> get(BeerId beer);
}
