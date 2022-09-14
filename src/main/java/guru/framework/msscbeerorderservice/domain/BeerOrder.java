package guru.framework.msscbeerorderservice.domain;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class BeerOrder extends BaseEntity {

	@OneToMany(mappedBy = "beerOrder", cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private Set<BeerOrderLine> beerOrderLines;
	
	private String customerRef;
	private OrderStatusEnum orderStatus = OrderStatusEnum.NEW;
	private String orderStatusCallbackUrl;
	@ManyToOne
	private Customer customer;

	@Builder
	public BeerOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String customerRef,
			Customer customer, Set<BeerOrderLine> beerOrderLines, OrderStatusEnum orderStatus,
			String orderStatusCallbackUrl) {
		super(id, version, createdDate, lastModifiedDate);
		this.customerRef = customerRef;
		this.customer = customer;
		this.beerOrderLines = beerOrderLines;
		this.orderStatus = orderStatus;
		this.orderStatusCallbackUrl = orderStatusCallbackUrl;
	}

}
