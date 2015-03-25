package com.sam.temple.db.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sam.temple.db.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}