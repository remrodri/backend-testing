package com.cintest.orders.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StandarResponse {
    private String message;
    private int statuCode;
    private Object data;
}
