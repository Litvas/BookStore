package org.litvas.bookstore.mappers;

import org.litvas.bookstore.domain.Customer;
import org.litvas.bookstore.dto.CustomerLoyaltyPointsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target="loyaltyPoints", source = "loyaltyPoints")
    CustomerLoyaltyPointsDTO toCustomerDTO(Customer customer);

}
