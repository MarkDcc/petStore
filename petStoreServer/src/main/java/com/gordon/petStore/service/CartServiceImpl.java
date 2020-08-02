package com.gordon.petStore.service;

import com.gordon.petStore.model.CartEO;
import com.gordon.petStore.model.CartItemEO;
import com.gordon.petStore.repository.CartRepository;
import com.gordon.petStore.request.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author dongchen
 * @Data 2020/8/2
 * @Time 20:01
 */
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepository cartRepository;

    @Override
    public void initCart(String userName) {
        if(cartRepository.findByName(userName) == null){
            CartEO cartEO = new CartEO();
            cartEO.setName(userName);
            cartRepository.save(cartEO);
        }
    }

    @Override
    public void addCart(CartRequest cartRequest) {
        CartEO cartEO =  cartRepository.findByName(cartRequest.getUserName());
        boolean containerGFlag = false;
        if(cartEO.getCartItemEOList().size() > 0){
            for (CartItemEO cartItemEO : cartEO.getCartItemEOList()) {
                if (!cartItemEO.getPayed() && cartItemEO.getPetName().equals(cartRequest.getPetName()) && cartItemEO.getPetCategoryName().equals(cartRequest.getPetCategoryName())) {
                    cartItemEO.setCount(cartItemEO.getCount() + Integer.valueOf(cartRequest.getCount()));
                    cartItemEO.setDate(new Date());
                    containerGFlag = true;
                    break;
                }
            }
        }

        if(!containerGFlag){
            CartItemEO cartItemEO = new CartItemEO();
            cartItemEO.setCart(cartEO);
            cartItemEO.setDate(new Date());
            cartItemEO.setPetName(cartRequest.getPetName());
            cartItemEO.setPetCategoryName(cartRequest.getPetCategoryName());
            cartItemEO.setPayed(cartRequest.getPayed());
            cartEO.getCartItemEOList().add(cartItemEO);
        }

        cartRepository.save(cartEO);
    }

    @Override
    public void payCart(String userName) {
        CartEO cartEO = cartRepository.findByName(userName);
        if(cartEO.getCartItemEOList().size() > 0){
            cartEO.getCartItemEOList().stream().forEach(cartItemEO -> {
                cartItemEO.setPayed(true);
            });
        }
        cartRepository.save(cartEO);
    }

    @Override
    public CartEO listCart(String userName) {
        return cartRepository.findByName(userName);
    }
}
