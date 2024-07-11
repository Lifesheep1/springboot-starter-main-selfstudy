package com.springboot.V2.coffee;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/v2/coffees")
public class CoffeeController_v2 {
    @PostMapping

    public ResponseEntity postCoffee(@RequestHeader("user-agent")String userAgent,
                                     @RequestParam("engName") String engName,
                                     @RequestParam("korName") String korName,
                                     @RequestParam("price") int price)
    {
        System.out.println("user-agent: " + userAgent);
        return new ResponseEntity<>(new Coffee(korName,engName,price), HttpStatus.CREATED);
    }

    @GetMapping("/{coffee-id}")
    public String getCoffee(@PathVariable("coffee-id")long coffeeId){
        System.out.println("# coffeeId: " + coffeeId);

        //not implementation
        return null;
    }

    @GetMapping
    public ResponseEntity getCoffees(HttpEntity httpEntity){
        for (Map.Entry<String, List<String>> entry : httpEntity.getHeaders().entrySet()){
            System.out.println("key: " + entry.getKey()
                                + ", " +"value: " + entry.getValue());
        }
        System.out.println("host: " + httpEntity.getHeaders().getHost());
        return null;
    }
}
