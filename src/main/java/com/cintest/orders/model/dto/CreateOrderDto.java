package com.cintest.orders.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateOrderDto(
    @NotNull(message = "No puede ser nulo")
    @Positive(message = "debe ser mayor que 0")
    Integer units,

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe ser mayor que 0")
    Integer bonus,

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe ser mayor que 0")
    Integer promo,

    @NotNull(message = "no puede ser nulo")
    @Positive(message = "Debe ser mayor que 0")
    BigDecimal totalPrice,

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe ser mayor que 0")
    Long productId
) {
}
