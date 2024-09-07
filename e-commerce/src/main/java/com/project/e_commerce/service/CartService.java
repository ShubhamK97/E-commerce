package com.project.e_commerce.service;

import com.project.e_commerce.payload.CartDTO;

import java.util.List;

public interface CartService {
    CartDTO addProductToCart(Long productId,Integer quantity);

    List<CartDTO> getAllCarts();

    CartDTO getCart(String emailId, Long cartId);

    CartDTO updateProductQuantityInCart(Long productId, Integer quantity);

    String deleteProductFromCart(Long cartId, Long productId);

    void updateProductInCarts(Long cartId, Long productId);
}
