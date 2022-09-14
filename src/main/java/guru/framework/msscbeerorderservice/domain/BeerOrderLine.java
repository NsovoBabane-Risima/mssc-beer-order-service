package guru.framework.msscbeerorderservice.domain;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import guru.framework.msscbeerorderservice.services.beerservice.model.BeerStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class BeerOrderLine extends BaseEntity  {
  
	@ManyToOne
	private BeerOrder beerOrder;
	private UUID beerId;
	private Integer orderQuantity;
	private Integer quantityAllocated;
	private String beerName;
	private BeerStyle beerStyle;
	
	
	 @Builder
	    public BeerOrderLine(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
	                         BeerOrder beerOrder, UUID beerId, Integer orderQuantity,
	                         Integer quantityAllocated) {
	        super(id, version, createdDate, lastModifiedDate);
	        this.beerOrder = beerOrder;
	        this.beerId = beerId;
	        this.orderQuantity = orderQuantity;
	        this.quantityAllocated = quantityAllocated;
	    }

}
