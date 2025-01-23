package com.cintest.orders.vo;

import java.math.BigDecimal;

public record OrderVo(
        Long id,
        Integer units,
        Integer bonus,
        Integer promo,
        BigDecimal totalPrice,
        Long productId

) {
}
