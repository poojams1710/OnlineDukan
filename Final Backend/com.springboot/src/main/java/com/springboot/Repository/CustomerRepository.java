package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
