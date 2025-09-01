package org.litvas.bookstore.controllers;

import lombok.RequiredArgsConstructor;
import org.litvas.bookstore.domain.Purchase;
import org.litvas.bookstore.dto.PurchaseDTO;
import org.litvas.bookstore.services.PurchaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    public PurchaseDTO getBooks(@RequestBody Purchase purchase) {
        return purchaseService.createPurchase(purchase);
    }

}
