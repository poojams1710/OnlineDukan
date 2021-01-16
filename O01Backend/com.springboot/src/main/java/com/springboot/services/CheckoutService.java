package com.springboot.services;

import com.springboot.dto.Purchase;
import com.springboot.dto.PurchaseResponse;


public interface CheckoutService {
	 PurchaseResponse placeOrder(Purchase purchase);
}
