package com.springboot.V2.coffee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Coffee {
    private String korName;
    private String engName;
    private int price;

}
