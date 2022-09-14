package guru.framework.msscbeerorderservice.services.beerservice;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.framework.msscbeerorderservice.services.beerservice.model.BeerDto;
import guru.framework.msscbeerorderservice.services.beerservice.model.BeerStyle;

@Component
public class BeerServiceRestTemplateImpl implements BeerService {
	@Value("${BEER_SERVICE_HOST_URL}")
	private String BEER_SERVICE_HOST_URL;
	private final String BEER_SERVICE_BEER_ID_PATH = "/api/v1/beer";
	private final String BEER_SERVICE_BEER_UPC_PATH = "";
	private final RestTemplate restTemplate;

	public BeerServiceRestTemplateImpl(RestTemplateBuilder restTemplate) {
		super();
		this.restTemplate = restTemplate.build();
	}

	@Override
	public BeerDto getBeerById(UUID beerId) {
		ResponseEntity<BeerDto> beerDto = restTemplate.exchange(
				BEER_SERVICE_HOST_URL + BEER_SERVICE_BEER_ID_PATH + beerId, HttpMethod.GET, null, BeerDto.class);
		return beerDto.getBody();
	}

	@Override
	public BeerDto getBeerByUpc(String beerUpc) {
		ResponseEntity<BeerDto> beerDto = restTemplate.exchange(
				BEER_SERVICE_HOST_URL + BEER_SERVICE_BEER_UPC_PATH + beerUpc, HttpMethod.GET, null, BeerDto.class);
		return beerDto.getBody();
	}

}
