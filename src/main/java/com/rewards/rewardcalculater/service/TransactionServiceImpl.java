package com.rewards.rewardcalculater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.rewardcalculater.dao.TransactionRepository;
import com.rewards.rewardcalculater.entity.Transaction;
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionDao;

	@Override
	public Transaction findAllByCustomerId(Long transactionId) {
		List<Transaction> transactionList=transactionDao.findAllByCustomerId(transactionId);
		return transactionList.get(0);
	}

	

}
