package org.litvas.bookstore.repositories;

import org.litvas.bookstore.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {
}
