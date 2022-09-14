package guru.framework.msscbeerorderservice.web.model;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import guru.framework.msscbeerorderservice.domain.BeerOrder;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomerDto extends BaseItem {
	@NotBlank
	private String customerName;

	@NotNull
	private Set<BeerOrderDto> beerOrderDtos;

	@Builder
	public CustomerDto(UUID id, Integer version, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate,
			@NotBlank String customerName, @NotNull Set<BeerOrderDto> beerOrderDtos) {
		super(id, version, createdDate, lastModifiedDate);
		this.customerName = customerName;
		this.beerOrderDtos = beerOrderDtos;
	}

}
