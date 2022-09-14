package guru.framework.msscbeerorderservice.web.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import guru.framework.msscbeerorderservice.services.beerservice.model.BeerStyle;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class BeerOrderLineDto extends BaseItem {

	@NotNull
	private BeerOrderDto beerOrderDto;
	private UUID beerId;
	@Positive
	private Integer orderQuantity;
	@Positive
	private Integer quantityAllocated;
	private String upc;
	private String beerName;
	private BeerStyle beerStyle;
	
	@Builder
	public BeerOrderLineDto(UUID id, Integer version, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate,
			@NotNull BeerOrderDto beerOrderDto, UUID beerId, @Positive Integer orderQuantity,
			@Positive Integer quantityAllocated,String upc) {
		super(id, version, createdDate, lastModifiedDate);
		this.beerOrderDto = beerOrderDto;
		this.beerId = beerId;
		this.orderQuantity = orderQuantity;
		this.quantityAllocated = quantityAllocated;
		this.upc = upc;
	}
	
	
}
