package org.litvas.bookstore.services.impl;

import lombok.RequiredArgsConstructor;
import org.litvas.bookstore.domain.Customer;
import org.litvas.bookstore.dto.CustomerLoyaltyPointsDTO;
import org.litvas.bookstore.mappers.CustomerMapper;
import org.litvas.bookstore.repositories.CustomerRepository;
import org.litvas.bookstore.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public CustomerLoyaltyPointsDTO getLoyaltyPointsByCustomer(UUID customerId) {
        return customerMapper.toCustomerDTO(customerRepository.findById(customerId).get());

    }

    @Override
    public Optional<Customer> getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId);
    }
}
