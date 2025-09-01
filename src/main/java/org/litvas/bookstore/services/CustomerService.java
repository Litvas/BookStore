package org.litvas.bookstore.services;

import org.litvas.bookstore.domain.Customer;
import org.litvas.bookstore.dto.CustomerLoyaltyPointsDTO;

import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    CustomerLoyaltyPointsDTO getLoyaltyPointsByCustomer(UUID customerId);

    Optional<Customer> getCustomerById(UUID customerId);

}
