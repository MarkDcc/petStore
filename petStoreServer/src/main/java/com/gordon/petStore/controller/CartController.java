package com.gordon.petStore.controller;

import com.gordon.petStore.request.CartRequest;
import com.gordon.petStore.response.ApiResponse;
import com.gordon.petStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author dongchen
 * @Data 2020/8/2
 * @Time 19:50
 */
@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartService cartService;

    //添加到购物车
    @PostMapping("/add")
    public ResponseEntity addCart(@Valid @RequestBody CartRequest cartRequest){
        cartService.initCart(cartRequest.getUserName());

        return ResponseEntity.ok(new ApiResponse("Successful invoke", HttpStatus.CREATED.name()));

    }
    //付款

    //查看购物车
}
