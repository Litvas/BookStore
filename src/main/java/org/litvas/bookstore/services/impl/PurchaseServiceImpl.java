package org.litvas.bookstore.services.impl;

import lombok.RequiredArgsConstructor;
import org.litvas.bookstore.domain.*;
import org.litvas.bookstore.dto.PurchaseDTO;
import org.litvas.bookstore.mappers.PurchaseMapper;
import org.litvas.bookstore.repositories.PurchaseRepository;
import org.litvas.bookstore.services.BookService;
import org.litvas.bookstore.services.CustomerService;
import org.litvas.bookstore.services.PurchaseService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;
    private final BookService bookService;
    private final CustomerService customerService;

    @Override
    public PurchaseDTO createPurchase(Purchase purchase) {
        purchase.setTotalPrice(getTotalPrice(purchase.getItems()));
        purchase.getCustomer().setLoyaltyPoints(getLoayltyPoints(purchase));
        purchase.getItems().forEach(item -> {item.setPurchase(purchase);});
        return purchaseMapper.toPurchaseDTO(purchaseRepository.save(purchase));
    }

    private BigDecimal getTotalPrice(List<PurchaseItem> purchaseItemList) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        purchaseItemList.forEach(purchaseItem -> {
            Book book = bookService.getBookById(purchaseItem.getBook().getId()).orElse(null);
            purchaseItem.setBook(book);
        });

        for (BookType bookType : BookType.values()) {
            BigDecimal bookTypePrice = new BigDecimal(0);
            BigDecimal discount = bookType.getDiscount();
            List<PurchaseItem> itemsByType = purchaseItemList.stream().filter(e -> e.getBook().getType().equals(bookType)).toList();
            Long totalQuantityByItems = 0L;
            for (PurchaseItem purchaseItem : itemsByType) {
                bookTypePrice = bookTypePrice.add(purchaseItem.getBook().getPrice().multiply(BigDecimal.valueOf(purchaseItem.getQuantity())));
                totalQuantityByItems += purchaseItem.getQuantity();
            }
            if (totalQuantityByItems >= 3) {
                discount = bookType.getDiscount().multiply(bookType.getAdditionalDiscount());
            }
            discount = new BigDecimal(1).subtract(discount);
            BigDecimal totalPriceByType = bookTypePrice.multiply(discount);
            totalPrice = totalPrice.add(totalPriceByType);
        }
        return totalPrice;
    }

    private Long getLoayltyPoints(Purchase purchase) {
        Customer customer = customerService.getCustomerById(purchase.getCustomer().getId()).get();
        Long totalQuantity = purchase.getItems().stream().map(PurchaseItem::getQuantity).reduce(0L, Long::sum);
        return customer.getLoyaltyPoints() + totalQuantity * 10L;
    }
}
