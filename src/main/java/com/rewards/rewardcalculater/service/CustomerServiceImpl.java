package com.rewards.rewardcalculater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.rewardcalculater.dao.CustomerRepository;
import com.rewards.rewardcalculater.entity.Customer; 

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerDao;

	@Override
	public Customer findCustomerByCustomerId(Long customerId) {
		return customerDao.findCustomerByCustomerId(customerId);
	}

}
