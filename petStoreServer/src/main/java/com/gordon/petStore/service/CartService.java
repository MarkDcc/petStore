package com.gordon.petStore.service;

import com.gordon.petStore.request.CartRequest;

/**
 * @author dongchen
 * @Data 2020/8/2
 * @Time 20:00
 */
public interface CartService {

    void initCart(String userName);

    void addCart(CartRequest cartRequest);
}
