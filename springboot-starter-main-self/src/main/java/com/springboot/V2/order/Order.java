package com.springboot.V2.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Order {
    private long memberId;
    private long coffeeId;
}
