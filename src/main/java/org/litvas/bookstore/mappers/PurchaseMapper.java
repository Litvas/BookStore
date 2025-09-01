package org.litvas.bookstore.mappers;

import org.litvas.bookstore.domain.Purchase;
import org.litvas.bookstore.dto.PurchaseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    PurchaseDTO toPurchaseDTO(Purchase purchase);

}
