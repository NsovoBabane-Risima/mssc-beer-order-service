package guru.framework.msscbeerorderservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import guru.framework.msscbeerorderservice.domain.BeerOrder;
import guru.framework.msscbeerorderservice.domain.BeerOrderLine;
import guru.framework.msscbeerorderservice.domain.Customer;
import guru.framework.msscbeerorderservice.domain.OrderStatusEnum;

public interface BeerOrderLineRepository extends PagingAndSortingRepository<BeerOrderLine, UUID> {

//	Page<BeerOrder> findAllByCustomer(Customer customer, Pageable pageable);
//
//	List<BeerOrder> findAllByOrderStatus(OrderStatusEnum orderStatusEn);
}
