package guru.framework.msscbeerorderservice.web.model;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import guru.framework.msscbeerorderservice.domain.BeerOrderLine;
import guru.framework.msscbeerorderservice.domain.Customer;
import guru.framework.msscbeerorderservice.domain.OrderStatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BeerOrderDto extends BaseItem {


	@JsonProperty("beerOrderLines")
	private Set<BeerOrderLineDto> beerOrderLines;
	@NotBlank
	private String customerRef;
	private OrderStatusEnum orderStatus = OrderStatusEnum.NEW;
	private String orderStatusCallbackUrl;
    @NotNull
	private UUID customerId;
	@Builder
	public BeerOrderDto(@Null UUID id, Integer version, @Null OffsetDateTime createdDate, OffsetDateTime lastModifiedDate,
			Set<BeerOrderLineDto> beerOrderLines, String customerRef, OrderStatusEnum orderStatus,
			String orderStatusCallbackUrl, UUID customerId) {
		super(id, version, createdDate, lastModifiedDate);
		this.beerOrderLines = beerOrderLines;
		this.customerRef = customerRef;
		this.orderStatus = orderStatus;
		this.orderStatusCallbackUrl = orderStatusCallbackUrl;
		this.customerId = customerId;
	}

}
