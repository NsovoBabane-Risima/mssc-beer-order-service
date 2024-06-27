package guru.framework.msscbeerorderservice.web.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import guru.framework.msscbeerorderservice.services.BeerOrderService;
import guru.springframework.brewery.model.BeerOrderDto;

@RestController
@RequestMapping("/v1/beerOrder/")
public class BeerOrderController {

	private final BeerOrderService beerOrderService;

	public BeerOrderController(BeerOrderService beerOrderService) {
		this.beerOrderService = beerOrderService;
	}

//	@RequestMapping("/{beerOrderId}")
//	public ResponseEntity<BeerOrderDto> getBeerById(@RequestParam("beerOrderId") UUID beerOrderId) {
//
//		return new ResponseEntity<BeerOrderDto>(beerOrderService.getBeerById(beerOrderId), HttpStatus.OK);
//	}
//
//	@PostMapping
//	public ResponseEntity<BeerOrderDto> createNewBeerOrder(@RequestBody BeerOrderDto beerOrderDto) {
//		return new ResponseEntity<BeerOrderDto>(beerOrderService.createNewBeerOrder(beerOrderDto), HttpStatus.CREATED);
//	}
//
//	@PutMapping("/{beerOrderId}")
//	public ResponseEntity<BeerOrderDto> updateBeerOrder(@RequestParam("beerOrderId") UUID beerOrderId,
//			@RequestBody BeerOrderDto beerOrderDto) {
//		;
//		return new ResponseEntity<BeerOrderDto>(beerOrderService.updateBeerOrderDto(beerOrderId, beerOrderDto),
//				HttpStatus.NO_CONTENT);
//	}
//
//	@DeleteMapping("/{beerOrderId}")
//	public ResponseEntity deleteBeerOrderById(@RequestParam("beerOrderId") UUID beerOrderId) {
//		beerOrderService.deleteBeerOrderById(beerOrderId);
//		return new ResponseEntity(HttpStatus.NO_CONTENT);
//	}

}
