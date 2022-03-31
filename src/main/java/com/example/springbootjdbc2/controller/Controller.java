package com.example.springbootjdbc2.controller;

import com.example.springbootjdbc2.service.Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name="Rest controller", description="My Rest controller")
public class Controller {
    @Autowired
    private Service service;

    //public Controller(Service myService) {
    //    service=myService;
    //}

    @GetMapping( "/fetch-product")
    @Operation(
            summary = "Запрос купленного товара",
            description = "Получение названия купленных товаров по имени покупателя (Vasya OR Ivan)"
    )
    private List<String> getProduct(@RequestParam @Parameter(description = "Имя пользователя") String name){
        //return "123";
        return service.getProductFromRepo(name);
    }
}
