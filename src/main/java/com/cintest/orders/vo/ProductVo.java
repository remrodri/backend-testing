package com.cintest.orders.vo;

import java.math.BigDecimal;

public record ProductVo(
        Long id,
        Integer number,
        String name,
        BigDecimal price
) {
}
