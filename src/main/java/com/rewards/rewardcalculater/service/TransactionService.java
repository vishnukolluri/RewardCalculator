package com.rewards.rewardcalculater.service;

import com.rewards.rewardcalculater.entity.Transaction;


public interface TransactionService {
	public 	Transaction findAllByCustomerId(Long trnsactionId);


}
