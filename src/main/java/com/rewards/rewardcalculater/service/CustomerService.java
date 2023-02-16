package com.rewards.rewardcalculater.service;

import com.rewards.rewardcalculater.entity.Customer;

public interface CustomerService {

	public 	Customer findCustomerByCustomerId(Long customerId);
}
