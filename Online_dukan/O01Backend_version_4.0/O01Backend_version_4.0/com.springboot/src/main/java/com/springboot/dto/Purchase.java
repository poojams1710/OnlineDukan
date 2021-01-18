package com.springboot.dto;

import java.util.Set;

import com.springboot.model.Address;
import com.springboot.model.Customer;
import com.springboot.model.Order;
import com.springboot.model.OrderItem;


public class Purchase {
	  public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	private Customer customer;
	    private Address shippingAddress;
	    private Address billingAddress;
	    private Order order;
	    private Set<OrderItem> orderItems;


}
