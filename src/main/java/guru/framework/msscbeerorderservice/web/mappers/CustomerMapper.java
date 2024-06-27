package guru.framework.msscbeerorderservice.web.mappers;

import org.mapstruct.Mapper;

import guru.framework.msscbeerorderservice.domain.Customer;
import guru.springframework.brewery.model.CustomerDto;

@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {
    CustomerDto customerToDto(Customer customer);

    Customer dtoToCustomer(Customer dto);
}