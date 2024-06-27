package guru.framework.msscbeerorderservice.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import guru.framework.msscbeerorderservice.domain.BeerOrderLine;
import guru.framework.msscbeerorderservice.services.beerservice.BeerService;
import guru.framework.msscbeerorderservice.services.beerservice.model.BeerDto;
import guru.springframework.brewery.model.BeerOrderLineDto;

public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {

	private  BeerService beerService;
	private  BeerOrderLineMapper beerOrderLineMapper;

    @Autowired
	public void setBeerService(BeerService beerService) {
		this.beerService = beerService;
	}
    @Autowired
	public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
		this.beerOrderLineMapper = beerOrderLineMapper;
	}
	@Override
	public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
		BeerDto  beerDto = beerService.getBeerById(line.getBeerId());
		line.setBeerName(beerDto.getBeerName());
		line.setBeerStyle(beerDto.getBeerStyle());
		return beerOrderLineMapper.beerOrderLineToDto(line);
	}
	@Override
	public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
