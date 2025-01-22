package com.cintest.orders.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateProductDto(
        @NotNull(message = "El precio no puede ser nulo")
        Integer number,

        @NotBlank(message = "No debe estar vacio")
        String name,

        @NotNull(message = "El precio no puede ser nulo")
        @Positive(message = "El precio debe ser mayor que 0")
        BigDecimal price
) {
}
