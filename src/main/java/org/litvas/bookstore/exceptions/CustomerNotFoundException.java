package org.litvas.bookstore.exceptions;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(UUID id) {
        super(String.format("Client with id %s not found in system", id.toString()));
    }
}
