package guru.framework.msscbeerorderservice.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import guru.framework.msscbeerorderservice.domain.BeerOrderLine;
import guru.springframework.brewery.model.BeerOrderLineDto;



@Mapper(uses = { DateMapper.class})
@DecoratedWith(BeerOrderLineMapperDecorator.class)
public interface BeerOrderLineMapper {

	BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

	BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
	
//	BeerOrderLine dtoToBeerOrderLineWithBeerName(BeerOrderLineDto dto);
//	
//	BeerOrderLine dtoToBeerOrderLineWithBeerBeerStyle(BeerOrderLineDto dto);
}
