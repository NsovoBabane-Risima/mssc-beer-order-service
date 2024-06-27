package guru.framework.msscbeerorderservice.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import guru.framework.msscbeerorderservice.domain.BeerOrder;
import guru.springframework.brewery.model.BeerOrderDto;

@Mapper(uses = {DateMapper.class , BeerOrderLineMapper.class})
public interface BeerOrderMapper {
	
	//@Mapping(target = "customerId", source = "customer.id")
	BeerOrderDto beerOrderToBeerOrderDto(BeerOrder beerOrder);
	
	
	BeerOrder beerOrderDtoToBeerOrder(BeerOrderDto beerOrderDto);

}
