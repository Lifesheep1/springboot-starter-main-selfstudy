package com.springboot;

import com.google.gson.Gson;
import com.springboot.V2.coffee.Coffee;

public class JsonExample {
    public static void main(String[] args) {
        Coffee coffee = new Coffee("아메리카노", "Americano", 3000);
        Gson gson = new Gson();
        String jsonString = gson.toJson(coffee);

        System.out.println(jsonString);
    }
}
