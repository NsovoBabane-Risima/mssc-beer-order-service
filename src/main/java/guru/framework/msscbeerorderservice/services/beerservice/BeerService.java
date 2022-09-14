package guru.framework.msscbeerorderservice.services.beerservice;

import java.util.UUID;

import guru.framework.msscbeerorderservice.services.beerservice.model.BeerDto;
import guru.framework.msscbeerorderservice.services.beerservice.model.BeerStyle;

public interface BeerService {
	
BeerDto getBeerById(UUID beerId);
BeerDto getBeerByUpc(String beerUpc);


}
