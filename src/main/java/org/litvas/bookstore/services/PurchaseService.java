package org.litvas.bookstore.services;

import org.litvas.bookstore.domain.Purchase;
import org.litvas.bookstore.dto.PurchaseDTO;

public interface PurchaseService {

    PurchaseDTO createPurchase(Purchase purchase);

}