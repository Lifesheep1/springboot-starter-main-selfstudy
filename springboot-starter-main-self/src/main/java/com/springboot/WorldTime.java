package com.springboot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class WorldTime {
    private String datetime;
    private String timezone;
    private int day_of_week;

}
