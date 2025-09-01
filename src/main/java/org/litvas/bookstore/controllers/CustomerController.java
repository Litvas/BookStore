package org.litvas.bookstore.controllers;

import lombok.RequiredArgsConstructor;
import org.litvas.bookstore.dto.CustomerLoyaltyPointsDTO;
import org.litvas.bookstore.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/loyaltypoints")
    public CustomerLoyaltyPointsDTO getLoyaltyPointsDTOByCustomerId(@RequestParam final UUID customerId) {
        return customerService.getLoyaltyPointsByCustomer(customerId);
    }

}
