package guru.framework.msscbeerorderservice.services;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guru.framework.msscbeerorderservice.domain.BeerOrder;
import guru.framework.msscbeerorderservice.domain.Customer;
import guru.framework.msscbeerorderservice.domain.BeerOrderStatusEnum;
import guru.framework.msscbeerorderservice.domain.exceptions.NotFoundException;
import guru.framework.msscbeerorderservice.repositories.BeerOrderRepository;
import guru.framework.msscbeerorderservice.repositories.CustomerRepository;
import guru.framework.msscbeerorderservice.web.mappers.BeerOrderLineMapper;
import guru.framework.msscbeerorderservice.web.mappers.BeerOrderMapper;
import guru.springframework.brewery.model.BeerOrderDto;
import guru.springframework.brewery.model.BeerOrderPagedList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerOrderServiceImpl implements BeerOrderService {

	private final BeerOrderRepository beerOrderRepository;
	private final BeerOrderMapper beerOrderMapper;
	private final CustomerRepository customerRepository;
	private final BeerOrderLineMapper lineMapper;

	@Override
	public BeerOrderPagedList listOrders(UUID customerId, Pageable pageable) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);

		if (customerOptional.isPresent()) {

			Page<BeerOrder> beerOrderPage = beerOrderRepository.findAllByCustomer(customerOptional.get(), pageable);
			return new BeerOrderPagedList(
					beerOrderPage.stream().map(x -> beerOrderMapper.beerOrderToBeerOrderDto(x))
							.collect(Collectors.toList()),
					PageRequest.of(beerOrderPage.getPageable().getPageNumber(),
							beerOrderPage.getPageable().getPageSize()),
					beerOrderPage.getTotalElements());
		} else {
			return null;
		}
	}

	@Transactional
	@Override
	public BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);

		if (customerOptional.isPresent()) {
            
			beerOrderDto.getBeerOrderLines().forEach(x -> lineMapper.dtoToBeerOrderLine(x));
			
			BeerOrder beerOrder = beerOrderMapper.beerOrderDtoToBeerOrder(beerOrderDto);
			beerOrder.setId(null);
			beerOrder.setCustomer(customerOptional.get());
			beerOrder.setOrderStatus(BeerOrderStatusEnum.NEW);

			beerOrder.getBeerOrderLines().forEach(line -> line.setBeerOrder(beerOrder));

			BeerOrder savedBeerOrder = beerOrderRepository.saveAndFlush(beerOrder);
			log.debug("Saved Beer Order: " + beerOrder.getId());
			return beerOrderMapper.beerOrderToBeerOrderDto(savedBeerOrder);
		}
		throw new RuntimeException("Customer Not Found");
	}

	@Override
	public BeerOrderDto getOrderById(UUID customerId, UUID beerOrderId) {
		return beerOrderMapper.beerOrderToBeerOrderDto(getOrder(customerId, beerOrderId));
	}

	private BeerOrder getOrder(UUID customerId, UUID beerOrderId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);

		if (customerOptional.isPresent()) {

			Optional<BeerOrder> beerOrderOptional = beerOrderRepository.findById(beerOrderId);
			if (beerOrderOptional.isPresent()) {
				BeerOrder beerOrder = beerOrderOptional.get();
				if (beerOrder.getCustomer().getId() == customerId) {
					return beerOrder;
				}
				throw new RuntimeException("order not for customer");
			}
			throw new RuntimeException("Beer order is not found");
		}
		throw new RuntimeException("Customer not found");

	}

	@Override
	public void pickupOrder(UUID customerId, UUID orderId) {

		Optional<Customer> customerOptional = customerRepository.findById(customerId);

		if (customerOptional.isPresent()) {
			Optional<BeerOrder> beerOrderOptional = beerOrderRepository.findById(orderId);

			if (beerOrderOptional.isPresent()) {

				BeerOrder beerOrder = beerOrderRepository.findById(orderId).get();
				if (beerOrder.getCustomer().getId() == customerId) {
					beerOrder.setOrderStatus(BeerOrderStatusEnum.PICKED_UP);
					beerOrderRepository.saveAndFlush(beerOrder);
				}
				throw new RuntimeException("order not for customer");
			}
			throw new RuntimeException("Beer order is not found");

		}
		throw new RuntimeException("Customer not found");

	}

//	@Override
//	public BeerOrderDto getBeerById(UUID beerOrderId) {
//
//		return beerOrderMapper
//				.beerOrderToBeerOrderDto(orderRepository.findById(beerOrderId).orElseThrow(NotFoundException::new));
//	}
//
//	@Override
//	public BeerOrderDto createNewBeerOrder(BeerOrderDto beerOrderDto) {
//
//		return beerOrderMapper
//				.beerOrderToBeerOrderDto(orderRepository.save(beerOrderMapper.beerOrderDtoToBeerOrder(beerOrderDto)));
//	}
//
//	@Override
//	public BeerOrderDto updateBeerOrderDto(UUID id, BeerOrderDto beerOrderDto) {
//	 BeerOrder beerOrder = orderRepository.findById(id).orElseThrow(NotFoundException::new);
//	 beerOrder.setBeerOrderLines(beerOrderDto.getBeerOrderLines());
//	 beerOrder.setOrderStatus(beerOrderDto.getOrderStatus());
//	 return beerOrderMapper.beerOrderToBeerOrderDto(orderRepository.save(beerOrder));
//	}
//
//	@Override
//	public void deleteBeerOrderById(UUID beerOrderId) {
//		orderRepository.deleteById(beerOrderId);
//		
//	}

}
