package com.example.springbootjdbc2.controller;

import com.example.springbootjdbc2.service.Service;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class Controller {
    private Service service;

    public Controller(Service myService) {
        service=myService;
    }

    @RequestMapping(value = "/fetch-product", method = RequestMethod.GET)
    private List<String> getProduct(@RequestParam String name){
        //return "123";
        return service.getProductFromRepo(name);
    }
}
