package com.gordon.petStore.controller;

import com.gordon.petStore.model.CartEO;
import com.gordon.petStore.request.CartRequest;
import com.gordon.petStore.response.ApiResponse;
import com.gordon.petStore.response.CartResponse;
import com.gordon.petStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
        cartService.addCart(cartRequest);
        return ResponseEntity.ok(new ApiResponse("Successful invoke", HttpStatus.CREATED.name()));

    }

    //付款
    @PostMapping("/pay")
    public ResponseEntity payCart(@Valid @RequestBody CartRequest cartRequest){
        cartService.payCart(cartRequest.getUserName());
        return ResponseEntity.ok(new ApiResponse("Successful invoke", HttpStatus.CREATED.name()));
    }

    //查看购物车
    @PostMapping("/list")
    public List<CartResponse> listCart(@RequestParam String userName){
       CartEO cartEO =  cartService.listCart(userName);
       ArrayList<CartResponse> cartResponseList = new ArrayList<CartResponse>();
       cartEO.getCartItemEOList().stream().forEach(cartItemEO -> {
           CartResponse cartResponse = new CartResponse();
           cartResponse.setPetName(cartItemEO.getPetName());
           cartResponse.setPetCategoryName(cartItemEO.getPetCategoryName());
           cartResponse.setCount(cartItemEO.getCount());
           cartResponse.setDate(cartItemEO.getDate());
           cartResponse.setPrice(cartItemEO.getPrice());
           cartResponse.setPayed(cartItemEO.getPayed());
           cartResponseList.add(cartResponse);
       });
        return cartResponseList;
    }


}
