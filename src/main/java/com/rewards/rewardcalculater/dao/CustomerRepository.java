package com.rewards.rewardcalculater.dao;
import org.springframework.data.repository.CrudRepository;

import com.rewards.rewardcalculater.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Long> {
    public Customer findCustomerByCustomerId(Long customerId);
}