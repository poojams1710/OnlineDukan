package com.springboot.services;

import java.util.Set;
import java.util.UUID;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.springboot.Repository.CustomerRepository;
import com.springboot.dto.Purchase;
import com.springboot.dto.PurchaseResponse;
import com.springboot.model.Customer;
import com.springboot.model.Order;
import com.springboot.model.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private CustomerRepository customerRepository ;
	
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		
		this.customerRepository=customerRepository;
	}

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		// TODO Auto-generated method stub
		Order order= purchase.getOrder();
		 String orderTrackingNumber = generateOrderTrackingNumber();
	        order.setOrderTrackingNumber(orderTrackingNumber);
	        
	        Set<OrderItem> orderItems = purchase.getOrderItems();
	        orderItems.forEach(item -> order.add(item));
	        
	        order.setBillingAddress(purchase.getBillingAddress());
	        order.setShippingAddress(purchase.getShippingAddress());
	        Customer customer = purchase.getCustomer();
	        customer.add(order);
	        customerRepository.save(customer);

	        return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {
		// generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
	}

   
}

