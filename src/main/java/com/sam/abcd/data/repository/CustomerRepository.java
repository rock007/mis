package com.sam.abcd.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sam.abcd.data.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}