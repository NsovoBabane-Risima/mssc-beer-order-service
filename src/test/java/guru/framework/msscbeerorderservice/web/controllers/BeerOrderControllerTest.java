package guru.framework.msscbeerorderservice.web.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import guru.framework.msscbeerorderservice.services.BeerOrderService;
import lombok.RequiredArgsConstructor;

@WebMvcTest(BeerOrderController.class)
@RequiredArgsConstructor
class BeerOrderControllerTest {

	@Autowired
	MockMvc mockMvc;

//	@Autowired
//	ObjectMapper mapper;

	@MockBean
	BeerOrderService beerOrderService;

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void getBeerOrderById() throws Exception {

		mockMvc.perform(get("/v1/beerOrder/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
