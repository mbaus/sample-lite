package de.dacomb.sample.dummy.application;

import de.dacomb.sample.dummy.domain.BeerId;
import de.dacomb.sample.dummy.domain.beer.Beer;
import de.dacomb.sample.dummy.domain.beer.BeerToCreate;
import de.dacomb.sample.dummy.domain.beer.Beers;
import de.dacomb.sample.dummy.domain.beer.BeersCreator;
import de.dacomb.sample.dummy.domain.beer.BeersRemover;
import de.dacomb.sample.dummy.domain.beer.BeersRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BeersApplicationService {

  private final BeersRepository beers;
  private final BeersCreator creator;
  private final BeersRemover remover;

  public BeersApplicationService(BeersRepository beers) {
    this.beers = beers;

    creator = new BeersCreator(beers);
    remover = new BeersRemover(beers);
  }

  @PreAuthorize("hasRole('ADMIN')")
  public Beer create(BeerToCreate beerToCreate) {
    return creator.create(beerToCreate);
  }
  
  @PreAuthorize("hasRole('ADMIN')")
  public void remove(BeerId beer) {
    remover.remove(beer);
  }

  public Beers catalog() {
    return beers.catalog();
  }

}
